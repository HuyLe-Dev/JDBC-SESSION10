package com.example.exercise09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var manager = new ContactManager();
        var scanner = new Scanner(System.in);
        var isRunning = true;

        // Seed data để test 
        manager.addContact("Alice", "0901");
        manager.addContact("Bob", "0902");
        manager.addContact("Charlie", "0903");
        manager.addContact("David", "0904");
        manager.addContact("Eve", "0905");

        while (isRunning) {
            System.out.println("\n**************** QUẢN LÝ DANH BẠ ****************");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo SĐT");
            System.out.println("3. Tìm kiếm liên lạc theo SĐT");
            System.out.println("4. Hiển thị danh bạ (Phân trang)");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Nhập tên: ");
                        var name = scanner.nextLine().trim();
                        System.out.print("Nhập SĐT: ");
                        var phone = scanner.nextLine().trim();
                        manager.addContact(name, phone);
                    }
                    case 2 -> {
                        System.out.print("Nhập SĐT cần xóa: ");
                        var phone = scanner.nextLine().trim();
                        manager.removeContact(phone);
                    }
                    case 3 -> {
                        System.out.print("Nhập SĐT cần tìm: ");
                        var phone = scanner.nextLine().trim();
                        manager.findContact(phone).ifPresentOrElse(
                                contact -> System.out.println("🔍 Đã tìm thấy: " + contact),
                                () -> System.out.println("❌ Không tồn tại liên lạc này."));
                    }
                    case 4 -> {
                        System.out.print("Nhập số trang muốn xem (Ví dụ: 1): ");
                        int page = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Nhập số lượng hiển thị mỗi trang (Ví dụ: 2): ");
                        int pageSize = Integer.parseInt(scanner.nextLine().trim());
                        manager.displayContacts(page, pageSize);
                    }
                    case 5 -> isRunning = false;
                    default -> System.out.println("❌ Lựa chọn không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số!");
            }
        }
        scanner.close();
    }
}
