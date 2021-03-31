package com.theweddingsupplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theweddingsupplier.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
