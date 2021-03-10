package com.theweddingsupplier.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theweddingsupplier.model.ERole;
import com.theweddingsupplier.model.Role;

@Repository
public interface Rolerepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);

}
