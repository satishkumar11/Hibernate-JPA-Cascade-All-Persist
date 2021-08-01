package com.satish.spring.persist.cascade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Author extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //@OneToMany(cascade = {CascadeType.ALL}, targetEntity = Book.class)
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Book.class)
    @JoinColumn(name = "author_fk", referencedColumnName = "id")
    private List<Book> books;
}
