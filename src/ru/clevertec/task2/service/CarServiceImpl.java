package ru.clevertec.task2.service;

import ru.clevertec.task2.controller.MenuConst;
import ru.clevertec.task2.entity.car.Car;
import ru.clevertec.task2.entity.car.cargo.CargoCarBodyType;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements RequestService<Car> {
    private final List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }


    @Override
    public boolean add(Car car) {
        boolean result = true;
        try {
            carList.add(car);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = true;
        try {
            carList.remove(id - 1);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public void readAll() {
        List<Car> cars = getCarList();
        if (cars.size() > 0) {
            for (Car car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println(MenuConst.CAR_LIST_EMPTY);
        }
    }

    public CargoCarBodyType selectBodyType(int idBodyType) {
        try {
            String bodyType = String.valueOf(idBodyType);
            switch (bodyType) {
                case MenuConst.ONE -> {
                    return CargoCarBodyType.CISTERN;
                }
                case MenuConst.TWO -> {
                    return CargoCarBodyType.TENT;
                }
                case MenuConst.THREE -> {
                    return CargoCarBodyType.FRIDGE;
                }
                default -> {
                    System.out.println(MenuConst.WRONG_NUMBER);
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_NUMBER);
            return null;
        }

    }
}
