package ru.clevertec.task2.entity.car.cargo;

import ru.clevertec.task2.entity.car.Car;

public interface CargoCar {

    default void sealCargo(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() + ": груз успешно опечатан");
    }

    void addCargo(int numberOfCargo);

    void cargoLeft();
}
