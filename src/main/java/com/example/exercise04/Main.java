package com.example.exercise04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var manager = new AttendanceManager();
        var scanner = new Scanner(System.in);
        var isRunning = true;
        while (isRunning) {
            printMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> addStudent(scanner, manager);
                    case 2 -> updateStudent(scanner, manager);
                    case 3 -> deleteStudent(scanner, manager);
                    case 4 -> manager.display();
                    case 5 -> {
                        isRunning = false;
                        System.out.println("Thoát chương trình.");
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Cập nhật sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Hiển thị danh sách sinh viên");
        System.out.println("5. Thoát");
    }

    public static void addStudent(Scanner scanner, AttendanceManager manager) {
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine().trim();
        manager.add(new Student(id, name));
        System.out.println("Đã thêm sinh viên thành công.");
    }

    public static void updateStudent(Scanner scanner, AttendanceManager manager) {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine().trim();
        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên với mã này.");
            return;
        }
        System.out.print("Nhập tên mới cho sinh viên: ");
        String newName = scanner.nextLine().trim();
        manager.update(index, new Student(id, newName));
        System.out.println("Đã cập nhật sinh viên thành công.");
    }

    public static void deleteStudent(Scanner scanner, AttendanceManager manager) {
        System.out.println("Nhập mã sinh viên cần xóa: ");
        var id = scanner.nextLine().trim();
        int index = manager.findIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên với mã này.");
        } else {
            manager.delete(index);
            System.out.println("Đã xóa sinh viên thành công.");
        }
    }
}
