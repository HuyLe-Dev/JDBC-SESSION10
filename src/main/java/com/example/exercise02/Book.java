package com.example.exercise02;

public record Book(String name, String author, int publishYear) {
    @Override
    public String toString() {
        return String.format("Tên sách: %s, Tác giả: %s, Năm xuất bản: %d", name, author, publishYear);
    }
}
