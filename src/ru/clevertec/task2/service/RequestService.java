package ru.clevertec.task2.service;

import java.util.List;

public interface RequestService<T> {

    boolean add(T t);

    boolean delete (int id);

    List<T> readAll();
}
