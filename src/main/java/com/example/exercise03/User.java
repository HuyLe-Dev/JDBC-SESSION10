package main.java.com.example.exercise03;

public record User(String name, String email, String phone) {
    @Override
    public String toString() {
        return String.format("Tên: %s, Email: %s, Số điện thoại: %s", name, email, phone);
    }
}
