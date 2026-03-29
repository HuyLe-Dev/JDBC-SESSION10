package com.example.exercise01;

public class Main {
    public static void main(String[] args) {
        var manager = new StudentManager();
        var isRunning = true;

        while (isRunning) {
            var name = InputValidator.readString("Nhap ten sinh vien: ");
            var age = InputValidator.readPositiveInt("Nhap tuoi sinh vien:");
            var gpa = InputValidator.readPositiveDouble("Nhap diem trung binh sinh vien: ");

            manager.addStudent(new Student(name, age, gpa));
            isRunning = InputValidator.askToContinue("Ban co muon them sinh vien khac? (y/n)");
        }
        manager.displayAll();
    }
}
