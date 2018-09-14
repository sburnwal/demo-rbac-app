package demo.rbacapp.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import demo.rbacapp.entity.BaseEntity;

/**
 * We just need to define a generic interface for DAO (repository).
 * Spring takes care of providing implementation at runtime. Class annotated 
 * with @SpringBootApplication or @EnableAutoConfiguration will implement and create 
 * corresponding bean instances for all interfaces that extends JpaRepository.
 * 
 * Note that JpaRepository extends CrudRepository and PagingAndSortingRepository, so
 * you get some basic implementations by defaults. Of course you can add your own (which
 * too, if conventions followed, spring will implement for you).
 * 
 * @author sburnwal
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> extends JpaRepository<T, Serializable> {

}
