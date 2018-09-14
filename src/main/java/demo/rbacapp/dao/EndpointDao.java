package demo.rbacapp.dao;

import java.util.Optional;

import demo.rbacapp.entity.Endpoint;

public interface EndpointDao extends BaseDao<Endpoint> {
	Optional<Endpoint> findById(Long id);
}
