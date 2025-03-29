package com.dev.codeinbook.infrastructure.repository;

import com.dev.codeinbook.infrastructure.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
