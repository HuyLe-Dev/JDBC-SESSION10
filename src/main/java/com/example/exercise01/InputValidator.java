package main.java.com.example.session10;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        while (true) {
            System.out.println(prompt);
            var input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui long khong de trong!");
                continue;
            }
            return input;
        }
    }

    public static int readPositiveInt(String prompt) {
        while (true) {
            try {
                var input = readString(prompt);
                var value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("Vui long nhap so nguyen >= 0!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("Vui long nhap so nguyen >= 0!");
            }
        }
    }

    public static double readPositiveDouble(String prompt) {
        while (true) {
            try {
                var input = readString(prompt);
                var value = Double.parseDouble(input);

                if (value < 0) {
                    System.out.println("Vui lòng nhập số thực >= 0 !");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực >= 0 !");
            }
        }
    }

    public static boolean askToContinue(String prompt) {
        System.out.println(prompt);
        var input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }
}
