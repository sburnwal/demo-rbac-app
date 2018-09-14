package demo.rbacapp.dao;

import java.util.Optional;

import demo.rbacapp.entity.Role;

public interface RoleDao extends BaseDao<Role> {
	Optional<Role> findByName(String name);
	Optional<Role> findById(Long id);
}
