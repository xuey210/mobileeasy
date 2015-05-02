package demo.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import demo.domain.UserRegister;

/**
 * 用户User CrudRepository定义
 * 
 * @author jiekechoo
 *
 */
public interface UserRepository extends CrudRepository<UserRegister, Long> {

	Collection<UserRegister> findAll();

	UserRegister findByUsername(String username);

}
