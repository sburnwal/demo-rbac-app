package demo.rbacapp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * This is to get the JWT token from the request, validate and parse it, load the user 
 * associated with the token, and pass it to Spring Security.
 * 
 * It sets the user details in spring security’s SecurityContext. Spring security 
 * uses the UserDetails to perform authorization checks. We can also access 
 * the UserDetails stored in the SecurityContext in our controllers to perform 
 * some specific needs.
 * 
 * @author sburnwal
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private JwtAuthProvider tokenProvider;

    @Autowired
    private DemoUserDetailsService userDetailsService;

    /* Validate and parse the token. Load the user details */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
    			FilterChain filterChain) throws ServletException, IOException {
        try {
        	logger.info("Checking if JsonWebToken is present in request from {}", request.getRemoteAddr());
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
            	logger.info("JsonWebToken of the request is VALID");
                String username = tokenProvider.getUserIdFromJWT(jwt);
                logger.info("Got username from JWT - {}", username);
                
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication 
                	= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                
                userDetails.getAuthorities().forEach(authority -> {
                	logger.info("Got granted authority {}", authority.getAuthority());
                });
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Error setting user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}