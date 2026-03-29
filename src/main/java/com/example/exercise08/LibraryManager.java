package com.example.exercise08;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryManager {
    private final Set<Book> books = new HashSet<>();

    public boolean addBook(Book book) {
        // HashSet sẽ tự động kiểm tra trùng lặp dựa vào equals() và hashCode()
        return books.add(book);
    }

    public List<Book> filterAndSortBooks(int afterYear) {
        return books.stream()
                .filter(book -> book.getYear() > afterYear)
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách trống.");
            return;
        }
        books.forEach(System.out::println);
    }
}
