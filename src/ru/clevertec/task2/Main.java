package ru.clevertec.task2;

import ru.clevertec.task2.controller.ConsoleController;
import ru.clevertec.task2.service.CarServiceImpl;
import ru.clevertec.task2.service.OrderServiceImpl;

public class Main {

    public static void main(String[] args) {

        CarServiceImpl carServiceImpl = new CarServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();
        ConsoleController controller = new ConsoleController(carServiceImpl, orderService);
        controller.start();


    }
}
