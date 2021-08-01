package com.satish.spring.persist.cascade.repository;

import com.satish.spring.persist.cascade.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
