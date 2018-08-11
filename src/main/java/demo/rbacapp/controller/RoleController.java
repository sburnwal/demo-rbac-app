package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.Role;

@RestController
@RequestMapping("/entity/role")
public class RoleController extends GenericController<Role> {

}
