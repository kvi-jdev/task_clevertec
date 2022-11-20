package ru.clevertec.task2.service;

public interface Checker {

    boolean checkNames(String pointName);
    boolean checkDate(String date);

    boolean checkIfDateNotPassed(String localDate);
}
