package demo.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import demo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Collection<User> findAll();
	
	User findByUsername(String username);
	

}
