package com.dev.codeinbook.infrastructure.model;

import com.dev.codeinbook.common.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;

@Document
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String id;

    private String title;

    private String subtitle;

    private String description;

    private BigDecimal price;

    public void with(BookDTO dto) {
        this.id = Objects.nonNull(dto.id()) ? dto.id() : this.id;
        this.title = Objects.nonNull(dto.title()) ? dto.title() : this.title;
        this.subtitle = Objects.nonNull(dto.subtitle()) ? dto.subtitle() : this.subtitle;
        this.description = Objects.nonNull(dto.description()) ? dto.description() : this.description;
        this.price = Objects.nonNull(dto.title()) ? dto.price() : this.price;

    }

    public BookDTO toBookDTO() {
        return new BookDTO(id, title, subtitle, description, price);

    }


}
