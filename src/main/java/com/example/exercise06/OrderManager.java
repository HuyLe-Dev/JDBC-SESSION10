package com.example.exercise06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OrderManager implements Manage<Order> {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void add(Order item) {
        orders.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    @Override
    public void update(int index, Order item) {
        validateIndex(index);
        orders.set(index, item);
        System.out.println("Đơn hàng đã được sửa thành công.");
    }

    @Override
    public void delete(int index) {
        validateIndex(index);
        orders.remove(index);
        System.out.println("Đơn hàng đã được xóa thành công.");
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống.");
            return;
        }
        // Lặp qua index bằng IntStream (Functional approach)
        IntStream.range(0, orders.size())
                .forEach(i -> System.out.printf("%d. %s%n", (i + 1), orders.get(i)));
    }

    public int findIndexByCode(String code) {
        return IntStream.range(0, orders.size())
                .filter(i -> orders.get(i).getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(-1);
    }

    public int getSize() {
        return orders.size();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= orders.size()) {
            throw new IllegalArgumentException("Mã đơn hàng không tồn tại!");
        }
    }
}
