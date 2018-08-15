package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.UserAccount;

@RestController
@RequestMapping("/entity/user")
public class UserAccountController extends GenericController<UserAccount>{

}
