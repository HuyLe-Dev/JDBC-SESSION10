package com.example.exercise08;

public class Main {
    public static void main(String[] args) {
        var library = new LibraryManager(); // Dùng 'var' cho gọn (Java 10+)

        System.out.println("--- 1. THÊM SÁCH VÀO THƯ VIỆN ---");
        library.addBook(new Book("B01", "Clean Code", "Robert C. Martin", 2008));
        library.addBook(new Book("B02", "Effective Java", "Joshua Bloch", 2017));
        library.addBook(new Book("B03", "Refactoring", "Martin Fowler", 2018));
        library.addBook(new Book("B04", "Head First Design", "Eric Freeman", 2004));

        // Thử thêm một cuốn sách TRÙNG ID (B02)
        boolean isAdded = library.addBook(new Book("B02", "Sách Fake Trùng ID", "Kẻ Mạo Danh", 2024));
        System.out.println("Thêm sách B02 lần 2 thành công? -> " + isAdded); // Sẽ in ra false

        System.out.println("\n--- 2. DANH SÁCH SÁCH TRONG SET (Không trùng lặp, Không đảm bảo thứ tự) ---");
        library.displayAllBooks();

        System.out.println("\n--- 3. LỌC SÁCH XUẤT BẢN SAU 2010 & SẮP XẾP THEO TÊN ---");
        var filteredBooks = library.filterAndSortBooks(2010);
        filteredBooks.forEach(System.out::println);
    }
}
