package com.example.exercise05;

public interface IManage<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}
