package com.example.exercise10;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanConverter {
    // Sử dụng LinkedHashMap để BẢO TOÀN THỨ TỰ chèn vào (từ lớn nhất đến nhỏ nhất)
    private static final Map<Integer, String> ROMAN_MAP = new LinkedHashMap<>();

    // Khối static khởi tạo dữ liệu 1 lần duy nhất khi Class được load
    static {
        ROMAN_MAP.put(1000, "M");
        ROMAN_MAP.put(900, "CM");
        ROMAN_MAP.put(500, "D");
        ROMAN_MAP.put(400, "CD");
        ROMAN_MAP.put(100, "C");
        ROMAN_MAP.put(90, "XC");
        ROMAN_MAP.put(50, "L");
        ROMAN_MAP.put(40, "XL");
        ROMAN_MAP.put(10, "X");
        ROMAN_MAP.put(9, "IX");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(4, "IV");
        ROMAN_MAP.put(1, "I");
    }

    /**
     * Hàm tiện ích (Utility method) nên để static
     */
    public static String intToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Giá trị chỉ hỗ trợ từ 1 đến 3999.");
        }

        // Sử dụng StringBuilder thay cho phép cộng chuỗi truyền thống
        var romanBuilder = new StringBuilder();
        int remaining = number;

        // Vòng lặp for-each qua các Entry của Map (Tương tự for...of map.entries()
        // trong JS)
        for (var entry : ROMAN_MAP.entrySet()) {
            // Chừng nào số hiện tại còn lớn hơn hoặc bằng key (ví dụ: 3749 >= 1000)
            while (remaining >= entry.getKey()) {
                romanBuilder.append(entry.getValue()); // Nối chữ số La Mã
                remaining -= entry.getKey(); // Trừ đi giá trị tương ứng
            }

            // Tối ưu: Nếu đã trừ hết về 0 thì thoát vòng lặp sớm
            if (remaining == 0)
                break;
        }

        return romanBuilder.toString();
    }
}
