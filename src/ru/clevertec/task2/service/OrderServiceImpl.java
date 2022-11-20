package ru.clevertec.task2.service;


import ru.clevertec.task2.controller.MenuConst;
import ru.clevertec.task2.entity.order.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderServiceImpl implements RequestService<Order>, Checker {

    private final List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }


    @Override
    public boolean add(Order order) {
        boolean result = true;
        try {
            orderList.add(order);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = true;
        try {
            orderList.remove(id - 1);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public List<Order> readAll() {
        List<Order> orders = getOrderList();
        if (orders.size() > 0) {
            for (Order order : orders) {
                System.out.println(order);
            }
        } else {
            System.out.println(MenuConst.ORDER_LIST_EMPTY);
        }
        return orders;
    }

    @Override
    public boolean checkNames(String pointName) {
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]{4,15}");
        Matcher matcher = pattern.matcher(pointName);
        return matcher.matches();
    }

    @Override
    public boolean checkDate(String date) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}.[0-9]{2}.[0-9]{4}");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    @Override
    public boolean checkIfDateNotPassed(String localDate) {
        String[] split = localDate.split("\\.");
        LocalDate date = LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),
                Integer.parseInt(split[0]));
        LocalDate dateNow = LocalDate.now();
        return date.isAfter(dateNow);
    }
}
