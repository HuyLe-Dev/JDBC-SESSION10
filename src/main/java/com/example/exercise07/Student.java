package com.example.exercise07;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // Gọi Enum để tự động lấy nhãn dựa vào GPA
        return String.format("ID: %-4d | Tên: %-20s | GPA: %-4.1f | Xếp loại: %s",
                id, name, gpa, AcademicRank.fromGpa(gpa).getLabel());
    }
}
