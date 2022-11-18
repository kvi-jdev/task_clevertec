package ru.clevertec.task2.entity.car.passenger;

import ru.clevertec.task2.entity.car.Car;

public interface PassengerCar {

    default void cleanInterior(Car car) {
        System.out.println(car.getBrand() + car.getModel() + ": произведена уборка и дезинфекция салона");
    }

    void addPassenger(int numberOfPassengers);

    void passengersLeft();
}
