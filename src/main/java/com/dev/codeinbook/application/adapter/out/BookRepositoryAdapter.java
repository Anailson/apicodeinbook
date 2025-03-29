package com.dev.codeinbook.application.adapter.out;

import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.common.dto.PageDTO;
import com.dev.codeinbook.domain.port.out.BookRepositoryPort;
import com.dev.codeinbook.infrastructure.repository.BookRepository;

public class BookRepositoryAdapter implements BookRepositoryPort {

    private BookRepository bookRepository;

    @Override
    public BookDTO create(BookDTO dto) {
        return null;
    }

    @Override
    public void udpate(String id, BookDTO dto) {

    }

    @Override
    public BookDTO findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public PageDTO<BookDTO> findAll(int page, int size) {
        return null;
    }
}
