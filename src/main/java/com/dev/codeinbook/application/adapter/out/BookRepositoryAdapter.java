package com.dev.codeinbook.application.adapter.out;

import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.common.dto.PageDTO;
import com.dev.codeinbook.common.exception.NotFoundException;
import com.dev.codeinbook.domain.port.out.BookRepositoryPort;
import com.dev.codeinbook.infrastructure.model.Book;
import com.dev.codeinbook.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class BookRepositoryAdapter implements BookRepositoryPort {

    private BookRepository bookRepository;

    @Override
    public BookDTO create(BookDTO dto) {
        Book book = new Book();
        book.with(dto);
        return bookRepository.save(book).toBookDTO();
    }

    @Override
    public void udpate(String id, BookDTO dto) {

    }

    @Override
    public BookDTO findById(String id) {
        return getBook(id).toBookDTO();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public PageDTO<BookDTO> findAll(int page, int size) {
        return null;
    }


    private Book getBook(String id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new NotFoundException("Book not found");
        }
        return bookOptional.get();
    }
}
