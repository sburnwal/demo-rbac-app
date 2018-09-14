package demo.rbacapp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.dao.UserAccountDao;
import demo.rbacapp.entity.UserAccount;

@RestController
@RequestMapping("/entity/user")
public class UserAccountController extends GenericController<UserAccount>{
	private Logger logger = LoggerFactory.getLogger(UserAccountController.class);
	
	@Autowired UserAccountDao dao;
	
	@RequestMapping(value = "/findByUsername/{username}", method = RequestMethod.GET)
	public UserAccount get(@PathVariable(value = "username") String username) {
		logger.info("Calling {}.findByUsername for {}", dao.getClass().getSimpleName(), username);
		Optional<UserAccount> u = dao.findByUsername(username);
		u.ifPresent(account -> {
			account.getUserAccountRoles().forEach(accountRole -> {
				logger.info("User has role {}", accountRole.getRole().getName());
			});
		});
		return u.get();
	}
}