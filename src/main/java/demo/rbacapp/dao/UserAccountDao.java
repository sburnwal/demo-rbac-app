package demo.rbacapp.dao;

import java.util.Optional;

import demo.rbacapp.entity.UserAccount;

public interface UserAccountDao extends BaseDao<UserAccount> {	
	Optional<UserAccount> findByUsername(String username);
	Optional<UserAccount> findById(Long id);
	Boolean existsByUsername(String username);
}
