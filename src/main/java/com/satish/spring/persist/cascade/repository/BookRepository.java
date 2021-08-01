package com.satish.spring.persist.cascade.repository;

import com.satish.spring.persist.cascade.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
