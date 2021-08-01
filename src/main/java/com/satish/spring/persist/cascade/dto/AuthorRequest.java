package com.satish.spring.persist.cascade.dto;

import com.satish.spring.persist.cascade.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorRequest {

    private Author author;
}
