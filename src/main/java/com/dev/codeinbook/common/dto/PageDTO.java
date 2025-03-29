package com.dev.codeinbook.common.dto;

import java.util.List;

public class PageDTO<T> {

    private final List<T> content;
    private final int page;
    private final int size;
    private final long totalElements;
    private final int totalPages;

    // Construtor explícito
    public PageDTO(List<T> content, int page, int size, long totalElements, int totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    // Criando um método builder manualmente
    public static <T> PageDTOBuilder<T> builder() {
        return new PageDTOBuilder<>();
    }

    // Classe interna para construir PageDTO<T>
    public static class PageDTOBuilder<T> {
        private List<T> content;
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;

        public PageDTOBuilder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public PageDTOBuilder<T> page(int page) {
            this.page = page;
            return this;
        }

        public PageDTOBuilder<T> size(int size) {
            this.size = size;
            return this;
        }

        public PageDTOBuilder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PageDTOBuilder<T> totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PageDTO<T> build() {
            return new PageDTO<>(content, page, size, totalElements, totalPages);
        }
    }
}
