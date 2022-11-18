package ru.clevertec.task2.controller;

import ru.clevertec.task2.entity.car.Car;
import ru.clevertec.task2.entity.car.CarType;
import ru.clevertec.task2.entity.car.cargo.CargoCarBodyType;
import ru.clevertec.task2.entity.car.cargo.CargoCarImpl;
import ru.clevertec.task2.entity.car.general.GeneralCar;
import ru.clevertec.task2.entity.car.passenger.PassengerCarImpl;
import ru.clevertec.task2.entity.fuel.FuelType;
import ru.clevertec.task2.service.CarServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleController {

    private CarServiceImpl carServiceImpl;

    public void setCarService(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MenuConst.MAIN_MENU);
            System.out.print(MenuConst.CURSOR);
            String input = scanner.nextLine();
            switch (input) {
                case MenuConst.THREE -> System.exit(1);
                case MenuConst.ONE -> openAdminMenu();
                case MenuConst.TWO -> openUserMenu();
                default -> {
                    System.out.println(MenuConst.WRONG_NUMBER);
                    start();
                }
            }

        }

    }

    private void openUserMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.USER_MENU);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        if (MenuConst.EXIT.equalsIgnoreCase(input)) {
            start();
        }
    }

    private void openAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MenuConst.ADMIN_MENU);
            System.out.print(MenuConst.CURSOR);
            String input = scanner.nextLine();
            switch (input) {
                case MenuConst.THREE -> start();
                case MenuConst.ONE -> addCarMenu();
                case MenuConst.TWO -> deleteCarMenu();
                default -> {
                    System.out.println(MenuConst.WRONG_NUMBER);
                    openAdminMenu();
                }
            }
        }
    }

    private void deleteCarMenu() {
        Scanner scanner = new Scanner(System.in);
        carServiceImpl.readAll();
        System.out.println(MenuConst.DELETE_CAR_MENU);
        System.out.print(MenuConst.CURSOR);
        String carId = scanner.nextLine();
        try {
            if (carId.equalsIgnoreCase(MenuConst.EXIT)) {
                openAdminMenu();
            } else {
                int id = Integer.parseInt(carId);
                boolean delete = carServiceImpl.delete(id);
                if (delete) {
                    System.out.println(MenuConst.CAR_DELETED);
                } else {
                    System.out.println(MenuConst.CAR_NOT_DELETED);
                }
            }
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_NUMBER);
        }
    }

    private void addCarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MenuConst.ADD_CAR_MENU);
            System.out.print(MenuConst.CURSOR);
            String input = scanner.nextLine();
            //AUTO type selection
            switch (input) {
                case MenuConst.FOUR -> openAdminMenu();
                case MenuConst.ONE -> {
                    CargoCarImpl car = new CargoCarImpl();
                    car.setCarType(CarType.CARGO);
                    //Cargo car capacity selection
                    System.out.println(MenuConst.ENTER_CARGO_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    try {
                        int cargoCapacity = scanner.nextInt();
                        car.setCargoCapacity(cargoCapacity);
                    } catch (InputMismatchException e) {
                        System.out.println(MenuConst.WRONG_DATA);
                        addCarMenu();
                    }

                    //Cargo car body type selection
                    System.out.println(MenuConst.ENTER_BODY_TYPE);
                    System.out.print(MenuConst.CURSOR);
                    int bodyType = scanner.nextInt();
                    CargoCarBodyType cargoCarBodyType = carServiceImpl.selectBodyType(bodyType);
                    if (cargoCarBodyType != null) {
                        car.setBodyType(cargoCarBodyType);
                    } else {
                        addCarMenu();
                    }
                    addCar(car);
                }
                case MenuConst.TWO -> {
                    PassengerCarImpl car = new PassengerCarImpl();
                    car.setCarType(CarType.PASSENGER);
                    //Passenger car capacity selection
                    System.out.println(MenuConst.ENTER_PASSENGER_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    try {
                        int passCapacity = scanner.nextInt();
                        car.setPassengerCapacity(passCapacity);
                    }catch (InputMismatchException e) {
                        System.out.println(MenuConst.WRONG_NUMBER);
                        addCarMenu();
                    }


                    addCar(car);
                }
                case MenuConst.THREE -> {
                    GeneralCar car = new GeneralCar();
                    car.setCarType(CarType.GENERAL);
                    //General car passengers & cargo capacity selection
                    System.out.println(MenuConst.ENTER_PASSENGER_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    try {
                        int passCapacity = scanner.nextInt();
                        car.setPassengerCapacity(passCapacity);
                        System.out.println(MenuConst.ENTER_CARGO_CAPACITY);
                        System.out.print(MenuConst.CURSOR);
                        int cargoCapacity = scanner.nextInt();
                        car.setCargoCapacity(cargoCapacity);
                    }catch (InputMismatchException e) {
                        System.out.println(MenuConst.WRONG_NUMBER);
                        addCarMenu();
                    }
                    //General car body type selection
                    System.out.println(MenuConst.ENTER_BODY_TYPE);
                    System.out.print(MenuConst.CURSOR);
                    int bodyType = scanner.nextInt();
                    CargoCarBodyType cargoCarBodyType = carServiceImpl.selectBodyType(bodyType);
                    if (cargoCarBodyType != null) {
                        car.setBodyType(cargoCarBodyType);
                    } else {
                        addCarMenu();
                    }
                    addCar(car);
                }
                default -> {
                    System.out.println(MenuConst.WRONG_NUMBER);
                    addCarMenu();
                }
            }
        }
    }



    private void addCar(Car car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.LINE_ADD_CAR);
        System.out.print(MenuConst.CURSOR);
        String line = scanner.nextLine();
        String carData = line.replaceAll("[^А-Яа-я0-9A-Za-z]", " ").trim();
        String[] split = carData.split(" ");
        try {
            car.setBrand(split[0]);
            car.setModel(split[1]);
            car.setIssueYear(Integer.parseInt(split[2]));
            switch (split[3]) {
                case MenuConst.DIESEL -> car.setFuelType(FuelType.DIESEL);
                case MenuConst.PETROL -> car.setFuelType(FuelType.PETROL);
                case MenuConst.GAS -> car.setFuelType(FuelType.GAS);
                default -> throw new Exception();
            }

        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_DATA);
            addCarMenu();
        }
        if (carServiceImpl.add(car)) {
            System.out.println(MenuConst.CAR_ADDED);
        } else {
            System.out.println(MenuConst.CAR_NOT_ADDED);
        }
        addCarMenu();
    }
}
