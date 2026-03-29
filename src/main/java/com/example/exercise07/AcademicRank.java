package com.example.exercise07;

public enum AcademicRank {
    EXCELLENT("Xuất sắc"),
    GOOD("Giỏi"),
    FAIR("Khá"),
    POOR("Trung bình/Yếu");

    private final String label;

    AcademicRank(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static AcademicRank fromGpa(double gpa) {
        if (gpa >= 8.5)
            return EXCELLENT;
        if (gpa >= 7.0)
            return GOOD;
        if (gpa >= 5.5)
            return FAIR;
        return POOR;
    }
}
