package com.dev.codeinbook.domain;


import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.domain.port.out.BookRepositoryPort;
import com.dev.codeinbook.domain.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepositoryPort bookRepositoryPort;

    @InjectMocks
    private BookService bookService;

    /**
     * Criar um novo livro(book)
     */
    @Test
    void shouldCreateNewBook(){
        BookDTO bookDTO = new BookDTO("","Partindo do com java","Apreda Java","", BigDecimal.valueOf(29.90));
        BookDTO bookSaved = new BookDTO("123","Partindo do com java","Apreda Java","", BigDecimal.valueOf(29.90));
        when(bookRepositoryPort.create(bookDTO)).thenReturn(bookSaved);
        assertEquals(bookSaved, bookService.create(bookDTO));
        verify(bookRepositoryPort,times(1)).create(bookDTO);
    }
}
