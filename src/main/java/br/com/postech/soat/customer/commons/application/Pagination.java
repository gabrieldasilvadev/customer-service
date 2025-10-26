package br.com.postech.soat.commons.application;

public record Pagination(int page, int size) {
    
    public Pagination {
        if (page < 0) {
            throw new IllegalArgumentException("Page must be >= 0");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be > 0");
        }
    }

    public int getOffset() {
        return page * size;
    }
}