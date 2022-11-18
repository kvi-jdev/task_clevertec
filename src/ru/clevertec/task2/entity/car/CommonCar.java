package ru.clevertec.task2.entity.car;

public interface CommonCar {

    default void refuelCar(Car car, int fuel) {
        car.setFuelVolume(fuel);
        System.out.println(car.getBrand() + " " + car.getModel() + " заправлен на " + car.getFuelVolume() + " л.");
    }

    default void repairCar(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() + " отремонтирована");
    }
}
