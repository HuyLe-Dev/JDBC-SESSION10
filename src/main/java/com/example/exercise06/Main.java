package com.example.exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var manager = new OrderManager();
        var scanner = new Scanner(System.in);
        var isRunning = true;

        while (isRunning) {
            System.out.println("\n**************** MENU QUẢN LÝ ĐƠN HÀNG ****************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:\n");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> addOrder(scanner, manager);
                    case 2 -> updateOrder(scanner, manager);
                    case 3 -> deleteOrder(scanner, manager);
                    case 4 -> manager.display();
                    case 5 -> isRunning = false;
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
        scanner.close();
    }

    private static void addOrder(Scanner scanner, OrderManager manager) {
        var code = promptString(scanner, "Nhập mã đơn hàng:\n");
        var customerName = promptString(scanner, "Nhập tên khách hàng:\n");

        manager.add(new Order(code, customerName));
    }

    private static void updateOrder(Scanner scanner, OrderManager manager) {
        if (manager.getSize() == 0) {
            System.out.println("Danh sách trống, không có gì để sửa.");
            return;
        }

        manager.display();
        var code = promptString(scanner, "Nhập mã đơn hàng cần sửa:\n");
        int index = manager.findIndexByCode(code);

        try {
            var newCustomerName = promptString(scanner, "Nhập tên khách hàng mới:\n");

            manager.update(index, new Order(code, newCustomerName));
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void deleteOrder(Scanner scanner, OrderManager manager) {
        if (manager.getSize() == 0) {
            System.out.println("Danh sách trống, không có gì để xóa.");
            return;
        }

        manager.display();
        var code = promptString(scanner, "Nhập mã đơn hàng cần xóa:\n");
        int index = manager.findIndexByCode(code);

        try {
            manager.delete(index);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static String promptString(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            var input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            // In đúng thông báo lỗi như trong ảnh yêu cầu
            System.out.println("Vui lòng ko để trống !");
        }
    }
}
