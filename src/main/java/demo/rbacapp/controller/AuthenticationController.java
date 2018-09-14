package demo.rbacapp.controller;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.rbacapp.dao.RoleDao;
import demo.rbacapp.dao.UserAccountDao;
import demo.rbacapp.dao.UserAccountRoleDao;
import demo.rbacapp.dto.Credentials;
import demo.rbacapp.dto.JwtAuthResponse;
import demo.rbacapp.dto.RegisterUserRequest;
import demo.rbacapp.dto.SimpleResponse;
import demo.rbacapp.entity.Role;
import demo.rbacapp.entity.UserAccount;
import demo.rbacapp.entity.UserAccountRole;
import demo.rbacapp.exception.RbacException;
import demo.rbacapp.security.JwtAuthProvider;
import io.jsonwebtoken.lang.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	ObjectMapper jsonMapper = new ObjectMapper();
	
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UserAccountDao userDao;
    @Autowired RoleDao roleDao;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired JwtAuthProvider tokenProvider;
    
    /* Enum values must be same as the name of roles in database */
    enum InBuiltRoles {
    	Administrator,
    	Monitoring,
    	NetworkDeviceManager,
    	EndpointManager,
    	UserAccessManager
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Credentials creds) {
    	logger.info("Authenticating user {}", creds.getUsername());
    	logger.info("Password hash from db {}", userDao.findByUsername(creds.getUsername()).get().getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequest registerRequest) {
        if(userDao.existsByUsername(registerRequest.getUsername())) {
            return new ResponseEntity(new SimpleResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        
        try {
			logger.info("Received register request {}", jsonMapper.writeValueAsString(registerRequest));
		} catch (JsonProcessingException e) {
			logger.error("Json error", e);
		}
        
        UserAccount result = addUserAccount(registerRequest);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new SimpleResponse(true, "User registered successfully"));
    }
    
    @Transactional
    public UserAccount addUserAccount(RegisterUserRequest registerRequest) {
        if (Collections.isEmpty(registerRequest.getRoleIds())) {
        	throw new RbacException("No role for user");
        }

        // Creating user's account
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.getUsername());
        userAccount.setAge(registerRequest.getAge());
        userAccount.setGender(registerRequest.getGender());
        userAccount.setFirstName(registerRequest.getFirstName());
        userAccount.setFirstName(registerRequest.getLastName());
        userAccount.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        UserAccount result = userDao.save(userAccount);
        
        AtomicBoolean atLeastOneRole = new AtomicBoolean(false); 
        registerRequest.getRoleIds().forEach(roleId -> {
        	Optional<Role> role = roleDao.findById(roleId);
            if(role.isPresent()) {
            	logger.info("Adding role {} to the user {}", role.get().getId(), result.getUsername());
            	result.addRole(role.get());
            	atLeastOneRole.set(true);
            } else {
            	logger.info("No such role with id {}", roleId);
            }
        });
        
        if(! atLeastOneRole.get()) {
        	throw new RbacException("No valid role for user");
        }
        
        return userDao.save(result);
    }
}