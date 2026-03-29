package com.example.exercise10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var isRunning = true;

        System.out.println("=== CHUYỂN ĐỔI SỐ NGUYÊN SANG LA MÃ ===");

        while (isRunning) {
            System.out.print("\nNhập số nguyên dương (1-3999) hoặc '0' để thoát: ");

            try {
                int input = Integer.parseInt(scanner.nextLine().trim());

                if (input == 0) {
                    System.out.println("👋 Đã thoát chương trình.");
                    isRunning = false;
                    continue;
                }

                // Gọi class Utility để xử lý logic
                var result = RomanConverter.intToRoman(input);
                System.out.println("=> Kết quả La Mã: " + result);

            } catch (NumberFormatException e) {
                System.out.println("❌ Lỗi: Vui lòng nhập SỐ NGUYÊN hợp lệ.");
            } catch (IllegalArgumentException e) {
                // Bắt lỗi Validation ném ra từ tầng Business
                System.out.println("❌ Lỗi: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
