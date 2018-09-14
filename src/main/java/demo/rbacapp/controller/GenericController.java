package demo.rbacapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.rbacapp.dao.BaseDao;
import demo.rbacapp.entity.BaseEntity;

/**
 * A generic entity controller that can do CRUD operations on Entities
 * generically and thus avoid implementation for individual controller for 
 * each entity separately.
 * 
 * However, we need to override for few of them like Role, Priviledge 
 * because roles, privileges are unmodifiable data.
 * 
 * By default controllers with @RestController uses json as data format for 
 * request and response messages.
 * 
 * @author sburnwal
 */
public class GenericController<T extends BaseEntity> {
	private Logger logger = LoggerFactory.getLogger(GenericController.class);

	@Autowired
	private BaseDao<T> dao;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list() {
		logger.debug("Calling {}.findAll()", dao.getClass().getSimpleName());
		return dao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T entity) {
		logger.debug("Calling {}.save()", dao.getClass().getSimpleName());
		return dao.save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T update(@PathVariable(value = "id") long id, @RequestBody T entity) {
		logger.debug("Calling {}.save()", dao.getClass().getSimpleName());
		return dao.save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) {
		logger.debug("Calling {}.delete() for id {}", dao.getClass().getSimpleName(), id);
		dao.delete(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public T get(@PathVariable(value = "id") long id) {
		logger.debug("Calling {}.getOne() for id {}", dao.getClass().getSimpleName(), id);
		return dao.getOne(id);
	}
}