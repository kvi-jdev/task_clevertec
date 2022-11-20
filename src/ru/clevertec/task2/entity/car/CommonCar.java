package ru.clevertec.task2.entity.car;

public interface CommonCar {

    default void refuelCar(int fuel) {
        System.out.println("Автомобиль заправлен на " + fuel + " л.");
    }

    default void repairCar() {
        System.out.println("Машина успешно отремонтирована!");
    }
}
