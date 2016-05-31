package com.sectong.repository;

import java.util.Collection;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.sectong.domain.User;

/**
 * 用户User CrudRepository定义
 * 
 * @author jiekechoo
 *
 */
@RestResource(exported = false) // 禁止暴露REST
@CacheConfig(cacheNames = "users") // 缓存users表，适用于固定不变的数据表
@Cacheable
public interface UserRepository extends CrudRepository<User, Long> {

	Collection<User> findAll();

	User findByUsername(String username);

	Page<User> findAll(Pageable p);

	Page<User> findByUsernameContaining(String searchPhrase, Pageable p);

}
