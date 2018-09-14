package demo.rbacapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.rbacapp.dao.EndpointDao;
import demo.rbacapp.entity.Endpoint;
import demo.rbacapp.exception.RbacException;

@RestController
@RequestMapping("/entity/endpoint")
public class EndpointController extends GenericController<Endpoint>{
	private Logger logger = LoggerFactory.getLogger(EndpointController.class);

	@Autowired EndpointDao dao;
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('EndpointManager')")
	public Endpoint update(@PathVariable(value = "id") long id, @RequestBody Endpoint entity) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.debug("Calling save() on {}", mapper.writeValueAsString(entity));
		} catch (JsonProcessingException e) {
			logger.error("Json error", e);
			throw new RbacException(e.toString());
		}
		return dao.save(entity);
	}
}
