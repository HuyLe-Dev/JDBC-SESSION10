package com.example.exercise09;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ContactManager {
    private final Set<Contact> contacts = new HashSet<>();

    public void addContact(String name, String phone) {
        var newContact = new Contact(name, phone);
        // Hàm add() của Set trả về false nếu phần tử đã tồn tại (dựa vào equals &
        // hashCode)
        boolean isAdded = contacts.add(newContact);

        if (isAdded) {
            System.out.println("✅ Đã thêm liên lạc thành công.");
        } else {
            System.out.println("❌ LỖI: Số điện thoại '" + phone + "' đã tồn tại trong danh bạ!");
        }
    }

    public void removeContact(String phone) {
        // removeIf: Trả về true nếu có ít nhất 1 phần tử bị xóa.
        boolean isRemoved = contacts.removeIf(c -> c.getPhoneNumber().equals(phone));

        if (isRemoved) {
            System.out.println("✅ Đã xóa liên lạc có số: " + phone);
        } else {
            System.out.println("❌ Không tìm thấy liên lạc với số điện thoại này.");
        }
    }

    // Trả về Optional để controller tự quyết định cách xử lý nếu null (Tránh
    // NullPointerException)
    public Optional<Contact> findContact(String phone) {
        return contacts.stream()
                .filter(c -> c.getPhoneNumber().equals(phone))
                .findFirst();
    }

    public void displayContacts(int page, int pageSize) {
        if (contacts.isEmpty()) {
            System.out.println("📭 Danh bạ trống.");
            return;
        }

        long totalElements = contacts.size();
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        if (page < 1 || page > totalPages) {
            System.out.println("❌ Trang không tồn tại. Tổng số trang: " + totalPages);
            return;
        }

        System.out.printf("--- DANH BẠ (Trang %d/%d) ---%n", page, totalPages);

        // Logic Phân trang bằng Stream API (Giống hệt array.slice trong JS)
        contacts.stream()
                .skip((long) (page - 1) * pageSize) // Bỏ qua các phần tử của các trang trước
                .limit(pageSize) // Lấy đúng số lượng của trang hiện tại
                .forEach(System.out::println);
    }
}
