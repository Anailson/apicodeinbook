package com.dev.codeinbook.domain.service;

import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.common.dto.PageDTO;
import com.dev.codeinbook.domain.port.in.BookServicePort;
import com.dev.codeinbook.domain.port.out.BookRepositoryPort;

public class BookService implements BookServicePort {

    private BookRepositoryPort bookRepositoryPort;

    public BookService(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    public BookDTO create(BookDTO dto) {
        return bookRepositoryPort.create(dto);
    }

    public void update(String id, BookDTO dto) {
        bookRepositoryPort.udpate(id, dto);
    }


    public BookDTO findById(String id) {
        return bookRepositoryPort.findById(id);
    }

    public void delete(String id) {
        bookRepositoryPort.delete(id);
    }

    public PageDTO<BookDTO> findAll(int page, int size) {
        return bookRepositoryPort.findAll(page, size);
    }
}
