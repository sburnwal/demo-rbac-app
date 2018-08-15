package demo.rbacapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.rbacapp.entity.Priviledge;
import demo.rbacapp.exception.RbacException;

/**
 * Overriding methods so that CRUD ops are disabled. Only GET is supported.
 * Normally, we do not need to override REST controllers for entities.
 * However, we need to override for few of them like Role, Priviledge 
 * so that their data remains intact.
 * @author sburnwal
 *
 */
@RestController
@RequestMapping("/entity/priviledge")
public class PriviledgeController extends GenericController<Priviledge> {
	private Logger logger = LoggerFactory.getLogger(GenericController.class);

	@RequestMapping(method = RequestMethod.POST)
	public Priviledge create(@RequestBody Priviledge entity) {
		throw new RbacException("Operation not permitted - Create Priviledge");
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Priviledge update(@PathVariable(value = "id") long id, @RequestBody Priviledge entity) {
		throw new RbacException("Operation not permitted - Update Priviledge");
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) {
		throw new RbacException("Operation not permitted - Delete Priviledge");
	}

}
