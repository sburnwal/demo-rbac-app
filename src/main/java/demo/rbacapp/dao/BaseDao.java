package demo.rbacapp.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import demo.rbacapp.entity.BaseEntity;

/**
 * We just need to define a generic interface for DAO (repository).
 * Spring takes care of providing implementation at runtime.
 * @author sburnwal
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> extends JpaRepository<T, Serializable> {
	
}
