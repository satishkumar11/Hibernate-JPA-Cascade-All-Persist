package com.satish.spring.persist.cascade.controller;

import com.satish.spring.persist.cascade.dto.AuthorRequest;
import com.satish.spring.persist.cascade.exception.ResourceNotFoundException;
import com.satish.spring.persist.cascade.model.Author;
import com.satish.spring.persist.cascade.model.Book;
import com.satish.spring.persist.cascade.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/author")
    public Author addAuthor(@RequestBody AuthorRequest request) {
        return authorRepository.save(request.getAuthor());
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@PathVariable(value = "id") Integer id, @RequestBody AuthorRequest request) {
        return authorRepository.findById(id).map(author -> {
            author.setName(request.getAuthor().getName());
            author.setBooks(request.getAuthor().getBooks());
            return authorRepository.save(author);
        }).orElseThrow(() -> new ResourceNotFoundException("Author with id : " + id + " not found"));
    }

    @GetMapping("/author")
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public ResponseEntity getAuthorById(@PathVariable(value = "id") Integer id) {
        return authorRepository.findById(id).map(author ->
                ResponseEntity.ok(author)).orElseThrow(() ->
                new ResourceNotFoundException("Author with id : " + id + " not found")
        );
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Integer id) {
        return authorRepository.findById(id).map(author -> {
            authorRepository.delete(author);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Author with id : " + id + " not found"));
    }
}
