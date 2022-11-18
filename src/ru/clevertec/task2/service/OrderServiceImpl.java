package ru.clevertec.task2.service;


import ru.clevertec.task2.controller.MenuConst;
import ru.clevertec.task2.entity.order.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements RequestService<Order>{

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
    public void readAll() {
        List<Order> orders = getOrderList();
        if (orders.size() > 0) {
            for (Order order : orders) {
                System.out.println(order);
            }
        } else {
            System.out.println(MenuConst.ORDER_LIST_EMPTY);
        }

    }
}
