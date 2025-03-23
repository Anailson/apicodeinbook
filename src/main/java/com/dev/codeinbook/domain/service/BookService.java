package com.dev.codeinbook.domain.service;

import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.domain.port.out.BookRepositoryPort;

public class BookService {

    private BookRepositoryPort bookRepositoryPort;

    private BookService(BookRepositoryPort bookRepositoryPort){
        this.bookRepositoryPort = bookRepositoryPort;
    }

    public BookDTO create(BookDTO dto){
            return bookRepositoryPort.create(dto);
    }
}
