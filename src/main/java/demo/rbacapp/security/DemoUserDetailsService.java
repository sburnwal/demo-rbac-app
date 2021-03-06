package demo.rbacapp.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.rbacapp.dao.UserAccountDao;
import demo.rbacapp.entity.UserAccount;

/**
 * Method loadUserByUsername() is used by Spring security. 
 * Method loadUserById() will be used by JWTAuthenticationFilter
 * 
 * @author sburnwal
 */
@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired 
    UserAccountDao userDao;

    /* Marking this method @Transactional because it loads the UserAccount followed by 
     * its lazy loading of roles which otherwise would result into org.hibernate.LazyInitializationException: 
     * failed to lazily initialize a collection of role - could not initialize proxy - no Session
     */
    @Override @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userDao.findByUsername(username)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username - " + username)
        );

        return UserAccountDetails.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    public UserDetails loadUserById(Long id) {
        UserAccount user = userDao.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id - " + id)
        );

        return UserAccountDetails.create(user);
    }
}
