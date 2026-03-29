package com.example.exercise07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> searchByName(String keyword) {
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    // Nhóm danh sách sinh viên theo Học Lực (Map<AcademicRank, List<Student>>)
    public Map<AcademicRank, List<Student>> classifyByGPA() {
        return students.stream()
                .collect(Collectors.groupingBy(s -> AcademicRank.fromGpa(s.getGpa())));
    }
}
