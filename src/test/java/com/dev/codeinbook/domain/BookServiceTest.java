package com.dev.codeinbook.domain;


import com.dev.codeinbook.common.dto.BookDTO;
import com.dev.codeinbook.common.dto.PageDTO;
import com.dev.codeinbook.domain.port.out.BookRepositoryPort;
import com.dev.codeinbook.domain.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

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
    void shouldCreateNewBook() {
        BookDTO bookDTO = new BookDTO("", "Partindo do com java", "Apreda Java", "", BigDecimal.valueOf(29.90));
        BookDTO bookSaved = getBookSaved();
        when(bookRepositoryPort.create(bookDTO)).thenReturn(bookSaved);
        assertEquals(bookSaved, bookService.create(bookDTO));
        verify(bookRepositoryPort, times(1)).create(bookDTO);
    }

    /**
     * Atualizar
     */
    @Test
    void shouldUpdateNewBook() {
        BookDTO bookSaved = getBookSaved();
        bookService.update("123", bookSaved);
        verify(bookRepositoryPort, times(1)).udpate("123", bookSaved);

    }

    /**
     * Pesquisar
     */
    @Test
    void shouldGetBookById() {
        BookDTO bookSaved = getBookSaved();
        when(bookRepositoryPort.findById("123")).thenReturn(bookSaved);
        assertEquals(bookSaved, bookService.findById("123"));
    }

    /**
     * Delete
     */
    @Test
    void shoulDeleteBook() {
        bookService.deleteById("123");
        verify(bookRepositoryPort, times(1)).deleteById("123");
    }
    @Test
    void shouldGetBooksPaged() {
        List<BookDTO> bookList = List.of(getBookSaved());

        PageDTO<BookDTO> page = PageDTO.<BookDTO>builder()
                .content(bookList)
                .page(0)
                .size(10)
                .totalElements(1000)
                .totalPages(100)
                .build();

        when(bookRepositoryPort.findAll(0, 10)).thenReturn(page);
        assertEquals(page, bookService.findAll(0, 10));
    }

    private static BookDTO getBookSaved() {
        return new BookDTO("123", "Partindo do com java", "Apreda Java", "", BigDecimal.valueOf(29.90));
    }
}
