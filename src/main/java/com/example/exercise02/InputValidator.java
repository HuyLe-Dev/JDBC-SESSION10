package com.example.exercise02;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ERR_EMPTY = "Vui long khong de trong!";
    private static final String ERR_INVALID_NUMBER = "Vui long nhap mot so hop le!";

    private InputValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String readString(String prompt) {
        while (true) {
            System.out.println(prompt);
            var input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(ERR_EMPTY);
                continue;
            }
            return input;
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            var input = readString(prompt);
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(ERR_INVALID_NUMBER);
            }
        }
    }
}
