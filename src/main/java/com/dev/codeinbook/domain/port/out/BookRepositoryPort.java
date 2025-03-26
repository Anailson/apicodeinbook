package com.dev.codeinbook.domain.port.out;

import com.dev.codeinbook.common.dto.BookDTO;

public interface BookRepositoryPort {

    BookDTO create(BookDTO dto);

    void udpate(String id, BookDTO dto);

    BookDTO findById(String id);

    void delete(String id);
}
