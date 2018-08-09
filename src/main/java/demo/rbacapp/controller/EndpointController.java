package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.Endpoint;

@RestController
@RequestMapping("/entity/endpoint")
public class EndpointController extends GenericController<Endpoint>{

}
