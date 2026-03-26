package main.java.com.example.exercise03;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserManager userManager = new UserManager();

    public static void main(String[] args) {
        var running = true;

        while (running) {
            printMenu();
            try {
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> handleAddUser();
                    case 2 -> handleDeleteUser();
                    case 3 -> handleDisplayUsers();
                    case 4 -> running = false;
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ.");
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi hệ thống: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n*************** MENU QUẢN LÝ NGƯỜI DÙNG ***************");
        System.out.println("1. Thêm người dùng");
        System.out.println("2. Xóa người dùng");
        System.out.println("3. Hiển thị danh sách người dùng");
        System.out.println("4. Thoát");
    }

    private static void handleAddUser() {
        var name = getRequiredInput("Nhập tên người dùng:\n");
        var email = getRequiredInput("Nhập email người dùng:\n");
        var phone = getRequiredInput("Nhập số điện thoại người dùng:\n");

        userManager.addUser(new User(name, email, phone));
        System.out.println("Người dùng đã được thêm thành công.");
    }

    private static void handleDeleteUser() {
        var email = getRequiredInput("Nhập email người dùng để xóa:\n");

        boolean isDeleted = userManager.deleteUserByEmail(email);
        if (isDeleted) {
            System.out.println("Người dùng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy người dùng với email này.");
        }
    }

    private static void handleDisplayUsers() {
        var users = userManager.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        System.out.println("\nDanh sách người dùng:");
        users.forEach(System.out::println);
    }

    private static String getRequiredInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                var input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Vui lòng ko để trống !");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
