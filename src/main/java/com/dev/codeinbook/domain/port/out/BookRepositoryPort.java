package com.dev.codeinbook.domain.port.out;

import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.common.dto.PageDTO;

public interface BookRepositoryPort {

    BookDTO create(BookDTO dto);

    void udpate(String id, BookDTO dto);

    BookDTO findById(String id);

    void deleteById(String id);

    PageDTO<BookDTO> findAll(int page, int size);
}
