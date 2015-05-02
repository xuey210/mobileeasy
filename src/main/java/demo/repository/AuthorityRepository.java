package demo.repository;

import org.springframework.data.repository.CrudRepository;

import demo.domain.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
	

}
