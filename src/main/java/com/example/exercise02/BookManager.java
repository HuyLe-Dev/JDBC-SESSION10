package main.java.com.example.exercise02;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookManager {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        var key = book.name().toLowerCase();
        books.put(key, book);
        System.out.println("Sach da duoc them thanh cong. \n");
    }

    public Optional<Book> findByName(String name) {
        var key = name.toLowerCase();

        var book = books.get(key);
        return Optional.ofNullable(book);
    }

    public void displayAll() {
        if (books.isEmpty()) {
            System.out.println("Danh sach trong! \n");
            return;
        }
        System.out.println("\nDanh sach sach: ");
        books.values().forEach(System.out::println);
        System.out.println();
    }
}
