package com.gdxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdxx.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findRolesByUserId(Long userId);
}
