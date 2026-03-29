package com.example.exercise02;

public class Main {
    public static void main(String[] args) {
        var manager = new BookManager();
        var isRunning = true;

        while (isRunning) {
            printMenu();
            var choice = InputValidator.readString("Lua chon cua ban: ");

            switch (choice) {
                case "1" -> handleAddBook(manager);
                case "2" -> handleSearchBook(manager);
                case "3" -> manager.displayAll();
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("*************** MENU QUẢN LÝ SÁCH ***************");
        System.out.println("1. Thêm sách");
        System.out.println("2. Tìm kiếm sách");
        System.out.println("3. Hiển thị danh sách sách");
        System.out.println("4. Thoát");
    }

    private static void handleAddBook(BookManager manager) {
        var name = InputValidator.readString("Nhap vao ten sach: ");
        var author = InputValidator.readString("Nhap vao tac gia: ");
        var publishYear = InputValidator.readInt("Nhap vao nam san xuat: ");

        manager.addBook(new Book(name, author, publishYear));
    }

    private static void handleSearchBook(BookManager manager) {
        var keyword = InputValidator.readString("Nhap ten de tim kiem: ");

        manager.findByName(keyword).ifPresentOrElse(
                book -> System.out.println("Thong tin sach tim thay: " + book + "\n"),
                () -> System.out.println("Khong tim thay sach voi ten" + keyword + "\n"));
    }
}
