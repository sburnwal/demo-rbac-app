package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.NetworkDevice;

@RestController
@RequestMapping("/entity/networkDevice")
public class NetworkDeviceController extends GenericController<NetworkDevice>{

}
