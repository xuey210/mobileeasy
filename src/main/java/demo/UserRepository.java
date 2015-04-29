package demo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	Collection<User> findAll();
	
	User findByUsername(String username);
	

}
