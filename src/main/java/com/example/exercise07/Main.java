package com.example.exercise07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var service = new StudentService();
        var scanner = new Scanner(System.in);
        var isRunning = true;

        System.out.println("=== KHỞI TẠO DỮ LIỆU BAN ĐẦU ===");
        System.out.println("Yêu cầu: Nhập ít nhất 5 sinh viên.");
        seedInitialData(scanner, service, 5);

        while (isRunning) {
            System.out.println("\n--- MENU QUẢN LÝ SINH VIÊN ---");
            System.out.println("1. In danh sách sinh viên");
            System.out.println("2. Tìm kiếm sinh viên theo tên");
            System.out.println("3. Phân loại sinh viên theo GPA và hiển thị");
            System.out.println("4. Thêm sinh viên mới");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> service.getAllStudents().forEach(System.out::println);
                    case 2 -> searchStudent(scanner, service);
                    case 3 -> displayClassifiedStudents(service);
                    case 4 -> seedInitialData(scanner, service, 1); // Tái sử dụng hàm nhập liệu
                    case 5 -> isRunning = false;
                    default -> System.out.println("❌ Lựa chọn không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Lỗi: Vui lòng nhập số!");
            }
        }
    }

    // ==========================================
    // CÁC HÀM XỬ LÝ (CONTROLLERS)
    // ==========================================

    private static void seedInitialData(Scanner scanner, StudentService service, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");
            int id = promptInt(scanner, "  - Nhập ID: ");

            System.out.print("  - Nhập Tên: ");
            var name = scanner.nextLine().trim();

            double gpa = promptDouble(scanner, "  - Nhập GPA (0.0 - 10.0): ");

            service.addStudent(new Student(id, name, gpa));
        }
    }

    private static void searchStudent(Scanner scanner, StudentService service) {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        var keyword = scanner.nextLine().trim();
        var results = service.searchByName(keyword);

        if (results.isEmpty()) {
            System.out.println("🔍 Không tìm thấy sinh viên nào.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void displayClassifiedStudents(StudentService service) {
        var classifiedMap = service.classifyByGPA();

        if (classifiedMap.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        // Lặp qua Map (Tương đương Object.entries() hoặc for...in trong JS)
        classifiedMap.forEach((rank, studentList) -> {
            System.out.println("\n[+] Xếp loại: " + rank.getLabel());
            studentList.forEach(s -> System.out.println("    " + s.toString()));
        });
    }

    // ==========================================
    // MIDDLEWARE / BẮT LỖI NHẬP LIỆU (TRY-CATCH)
    // ==========================================

    private static int promptInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Lỗi định dạng: Vui lòng nhập SỐ NGUYÊN hợp lệ.");
            }
        }
    }

    private static double promptDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0 && value <= 10.0) {
                    return value;
                }
                System.out.println("❌ Lỗi: GPA phải nằm trong khoảng từ 0.0 đến 10.0.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Lỗi định dạng: Vui lòng nhập SỐ THỰC hợp lệ (ví dụ: 8.5).");
            }
        }
    }
}
