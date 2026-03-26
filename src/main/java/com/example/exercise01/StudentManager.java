package main.java.com.example.session10;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAll() {
        System.out.println("\nDanh sach sinh vien:");
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        students.forEach(System.out::println);
    }
}
