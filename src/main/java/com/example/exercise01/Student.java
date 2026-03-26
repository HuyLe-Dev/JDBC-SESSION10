package main.java.com.example.session10;

public record Student(String name, int age, double gpa) {

    @Override
    public String toString() {
        return String.format("Tên: %s, Tuổi: %d, Điểm trung bình: %.1f", name, age, gpa);
    }

}
