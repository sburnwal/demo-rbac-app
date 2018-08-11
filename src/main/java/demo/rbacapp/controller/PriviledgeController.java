package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.Priviledge;

@RestController
@RequestMapping("/entity/priviledge")
public class PriviledgeController extends GenericController<Priviledge> {

}
