package com.example.exercise08;

import java.util.Objects;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // --- Getters & Setters ---
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Tựa sách: %-20s | Tác giả: %-15s | Năm: %d", id, title, author, year);
    }

    // =========================================================================
    // TRICK: Bắt buộc Override equals() và hashCode() khi dùng với Set
    // =========================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true; // Cùng trỏ vào 1 vùng nhớ
        if (o == null || getClass() != o.getClass())
            return false; // Khác kiểu dữ liệu
        Book book = (Book) o;
        // Đề bài yêu cầu: sách duy nhất theo 'id'
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        // Băm mã id ra một con số nguyên để HashSet phân bổ bộ nhớ
        return Objects.hash(id);
    }
}
