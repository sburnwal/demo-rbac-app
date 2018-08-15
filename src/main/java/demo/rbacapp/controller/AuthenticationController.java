import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

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

import demo.rbacapp.dao.RoleDao;
import demo.rbacapp.dao.UserAccountDao;
import demo.rbacapp.dto.Credentials;
import demo.rbacapp.dto.JwtAuthResponse;
import demo.rbacapp.dto.RegisterUserRequest;
import demo.rbacapp.dto.SimpleResponse;
import demo.rbacapp.entity.Role;
import demo.rbacapp.entity.UserAccount;
import demo.rbacapp.exception.RbacException;
import demo.rbacapp.security.JwtAuthProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

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

        // Creating user's account
        UserAccount user = new UserAccount();
        user.setUsername(registerRequest.getUsername());
        user.setAge(registerRequest.getAge());
        user.setGender(registerRequest.getGender());
        user.setFirstName(registerRequest.getFirstName());
        user.setFirstName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleDao.findByName(InBuiltRoles.Monitoring.name())
                		.orElseThrow(() -> new RbacException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        UserAccount result = userDao.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new SimpleResponse(true, "User registered successfully"));
    }
}