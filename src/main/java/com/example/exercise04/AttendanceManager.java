package com.example.exercise04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AttendanceManager implements IManage<Student> {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int index, Student student) {
        if (isValidIndex(index)) {
            students.set(index, student);
        }
    }

    @Override
    public void delete(int index) {
        if (isValidIndex(index)) {
            students.remove(index);
        }
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        IntStream.range(0, students.size())
                .forEach(i -> System.out.println((i + 1) + ". " + students.get(i)));
    }

    public int findIndexById(String id) {
        return IntStream.range(0, students.size())
                .filter(i -> students.get(i).getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(-1);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < students.size();
    }
}
