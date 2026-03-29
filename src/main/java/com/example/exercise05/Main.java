package com.example.exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var manager = new InvoiceManager();
        var scanner = new java.util.Scanner(System.in);
        var isRunning = true;
        while (isRunning) {
            displayMenu();
            try {
                var choice = promptInt(scanner, "Choose an option: ");
                switch (choice) {
                    case 1 -> addInvoice(scanner, manager);
                    case 2 -> updateInvoice(scanner, manager);
                    case 3 -> deleteInvoice(scanner, manager);
                    case 4 -> manager.display();
                    case 5 -> {
                        isRunning = false;
                        System.out.println("Exiting...");
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Invoice");
        System.out.println("2. Update Invoice");
        System.out.println("3. Delete Invoice");
        System.out.println("4. Display Invoices");
        System.out.println("5. Exit");
    }

    private static void addInvoice(Scanner scanner, InvoiceManager manager) {
        var code = promptString(scanner, "Enter invoice ID: ");
        var amount = promptDouble(scanner, "Enter invoice amount: ");
        var invoice = new Invoice(code, amount);
        manager.add(invoice);
        System.out.println("Invoice added successfully.");
    }

    private static void updateInvoice(Scanner scanner, InvoiceManager manager) {
        if (manager.getSize() == 0) {
            System.out.println("Danh sách trống, không có gì để sửa.");
            return;
        }

        manager.display();
        int index = promptInt(scanner, "Nhập id hóa đơn cần sửa:\n") - 1; // Map 1-based ID to 0-based Index

        var newCode = promptString(scanner, "Nhập mã hóa đơn mới:\n");
        var newAmount = promptDouble(scanner, "Nhập số tiền mới:\n");

        manager.update(index, new Invoice(newCode, newAmount));
    }

    public static void deleteInvoice(Scanner scanner, InvoiceManager manager) {
        if (manager.getSize() == 0) {
            System.out.println("Danh sách trống, không có gì để xóa.");
            return;
        }

        manager.display();
        int index = promptInt(scanner, "Nhập id hóa đơn cần xóa:\n") - 1; // Map 1-based ID to 0-based Index
        manager.delete(index);
    }

    private static String promptString(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            var input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Vui lòng ko để trống !");
        }
    }

    private static double promptDouble(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                var input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    private static int promptInt(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                var input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
    }
}
