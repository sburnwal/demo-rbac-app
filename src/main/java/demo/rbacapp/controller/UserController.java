package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.User;

@RestController
@RequestMapping("/entity/user")
public class UserController extends GenericController<User>{

}
