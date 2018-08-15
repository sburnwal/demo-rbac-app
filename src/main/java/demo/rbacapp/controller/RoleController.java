package demo.rbacapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.Role;
import demo.rbacapp.exception.RbacException;

/**
 * Normally, we do not need to override REST controllers for entities.
 * However, we need to override for few of them like Role, Priviledge 
 * so that their data remains intact.
 *  
 * @author sburnwal
 *
 */
@RestController
@RequestMapping("/entity/role")
public class RoleController extends GenericController<Role> {
	@RequestMapping(method = RequestMethod.POST)
	public Role create(@RequestBody Role entity) {
		throw new RbacException("Operation not permitted - Create Role");
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Role update(@PathVariable(value = "id") long id, @RequestBody Role entity) {
		throw new RbacException("Operation not permitted - Update Role");
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) {
		throw new RbacException("Operation not permitted - Delete Role");
	}
}
