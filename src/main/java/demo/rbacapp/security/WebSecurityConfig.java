package demo.rbacapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This is the main (starting) class responsible for enabling security for the whole application.
 * The class extends WebSecurityConfigurerAdapter so that we can customize the AuthenticationManager 
 * and UserDetails service. @EnableWebSecurity is used on this with @Configuration annotated class     
 * to configure the security for the application.  
 * 
 * @EnableGlocalMethodSecurity is used to enable method level security based on annotations.  
 * We are using 'prePostEnabled' element of the annotation that allows complex expression based 
 * access control syntax with @PreAuthorize and @PostAuthorize annotations. 
 * 
 * Spring security needs a UserDetailsService to load the user details which can be used for username 
 * validation and to perform any role based checks.
 * 
 * JwtAuthenticationEntryPoint is needed to return a 401 unauthorized error to clients trying to access
 * protected resources withour proper authentication and authorization. It implements spring security's
 * AuthenticationEntryPoint interface.
 * 
 * JwtAuthenticationFilter is for validating JWT and loading the user priviledges using that token.
 * Sets the user details in Spring Security’s SecurityContext. Spring Security uses the user details 
 * to perform authorization checks. We can also access the user details stored in the SecurityContext 
 * in our controllers to perform our business logic.
 * 
 * AuthenticationManagerBuilder is used to create an AuthenticationManager instance which is the main 
 * Spring Security interface for authenticating a user. You can use AuthenticationManagerBuilder to 
 * do other types of authentications like LDAP authentication or add your custom authentication provider. 
 * In our example, we’ve provided our customUserDetailsService and a passwordEncoder to build the 
 * AuthenticationManager.
 * 
 * @author sburnwal
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DemoUserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Allow unauthenticated access to static files and login URL 
     * but restrict access to all other URLs. 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
        .authorizeRequests()
        	.antMatchers("/**/*.png", "/**/*.jpg", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()
            .antMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated()
        .and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}