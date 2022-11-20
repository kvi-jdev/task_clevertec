package ru.clevertec.task2.controller;

import ru.clevertec.task2.entity.car.Car;
import ru.clevertec.task2.entity.car.CarType;
import ru.clevertec.task2.entity.car.cargo.CargoCarBodyType;
import ru.clevertec.task2.entity.car.cargo.CargoCarImpl;
import ru.clevertec.task2.entity.car.general.GeneralCar;
import ru.clevertec.task2.entity.car.passenger.PassengerCarImpl;
import ru.clevertec.task2.entity.fuel.FuelType;
import ru.clevertec.task2.entity.order.Order;
import ru.clevertec.task2.service.CarServiceImpl;
import ru.clevertec.task2.service.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {

    private final CarServiceImpl carServiceImpl;

    private final OrderServiceImpl orderService;

    public ConsoleController(CarServiceImpl carServiceImpl, OrderServiceImpl orderService) {
        this.carServiceImpl = carServiceImpl;
        this.orderService = orderService;
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
        switch (input) {
            case MenuConst.THREE -> start();
            case MenuConst.ONE -> openUserOrderMenu();
            case MenuConst.TWO -> openUserCarMenu();
            default -> {
                System.out.println(MenuConst.WRONG_NUMBER);
                openUserMenu();
            }
        }

    }

    private void openUserOrderMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.USER_ORDER_MENU);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        switch (input) {
            case MenuConst.ONE -> openCreateOrderMenu();
            case MenuConst.TWO -> openListOrderMenu();
            case MenuConst.THREE -> openUserMenu();
            default -> {
                System.out.println(MenuConst.WRONG_NUMBER);
                openUserOrderMenu();
            }
        }
    }

    private void openCreateOrderMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.CREATE_ORDER_MENU);
        System.out.print(MenuConst.CURSOR);
        String departurePoint = scanner.nextLine();
        boolean checkDepPoint = orderService.checkNames(departurePoint);

        System.out.println(MenuConst.ENTER_ARRIVAL);
        System.out.print(MenuConst.CURSOR);
        String arrivalPoint = scanner.nextLine();
        boolean checkArrPoint = orderService.checkNames(arrivalPoint);

        System.out.println(MenuConst.ENTER_DATE);
        System.out.print(MenuConst.CURSOR);
        String date = scanner.nextLine();
        boolean checkDate = orderService.checkDate(date);
        if (checkDate) {
            boolean datePassed = orderService.checkIfDateNotPassed(date);
            if (!datePassed) {
                System.out.println(MenuConst.DATE_NOT_PASSED);
                openUserOrderMenu();
            }
        }

        if (checkDate && checkArrPoint && checkDepPoint) {
            Order order = new Order();
            order.setLocalDate(date);
            order.setArrivalPoint(arrivalPoint);
            order.setDeparturePoint(departurePoint);

            List<Car> cars = carServiceImpl.readAll();
            System.out.println(MenuConst.CHOOSE_CAR);
            System.out.print(MenuConst.CURSOR);
            String carId = scanner.nextLine();

            try {
                int id = Integer.parseInt(carId);
                Car car = cars.get(id - 1);
                order.setCar(car);
                boolean add = orderService.add(order);
                if (add) {
                    System.out.println(MenuConst.ORDER_CONFIRMED);
                } else {
                    System.out.println(MenuConst.WRONG_DATA);
                    System.out.println(MenuConst.ORDER_NOT_CONFIRMED);
                }
            } catch (Exception e) {
                System.out.println(MenuConst.WRONG_NUMBER);
            } finally {
                openUserOrderMenu();
            }

        } else {
            System.out.println(MenuConst.WRONG_DATA);
            openUserOrderMenu();
        }


    }

    private void openListOrderMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.LIST_ORDER_MENU);
        orderService.readAll();
        System.out.println(MenuConst.ADD_CARGO_PASS);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        switch (input) {
            case MenuConst.ONE -> addCargoPassengerMenu();
            case MenuConst.TWO -> openUserOrderMenu();
            default -> {
                System.out.println(MenuConst.WRONG_NUMBER);
                openUserOrderMenu();
            }
        }
    }

    private void addCargoPassengerMenu() {
        System.out.println(MenuConst.LIST_ORDER_MENU);
        List<Order> orders = orderService.readAll();
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.CHOOSE_ORDER);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        try {
            int id = Integer.parseInt(input);
            Car car = orders.get(id).getCar();
            if (car.getCarType().getCarTypeName().equals(MenuConst.CARGO)) {
                openCargoMenu(car);
            } else if(car.getCarType().getCarTypeName().equals(MenuConst.PASSENGER)) {
                openPassengerMenu(car);
            } else if (car.getCarType().getCarTypeName().equals(MenuConst.CARGO_PASSENGER)) {
                openCargoMenu(car);
                openPassengerMenu(car);
            } else {
                System.out.println(MenuConst.WRONG_DATA);
                openUserOrderMenu();
            }
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_DATA);
            openUserOrderMenu();
        }


    }

    private void openPassengerMenu(Car car) {
        System.out.println(MenuConst.UPDATE_PASS);
        System.out.print(MenuConst.CURSOR);
        Scanner scanner = new Scanner(System.in);
        try {
            int i = scanner.nextInt();
            car.addPassenger(i);
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_DATA);
            openUserOrderMenu();
        } finally {
            openUserOrderMenu();
        }
    }

    private void openCargoMenu(Car car) {
        System.out.println(MenuConst.UPDATE_CARGO);
        System.out.print(MenuConst.CURSOR);
        Scanner scanner = new Scanner(System.in);
        try {
            int i = scanner.nextInt();
            car.addCargo(i);
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_DATA);
            openUserOrderMenu();
        } finally {
            openUserOrderMenu();
        }
    }

    private void openUserCarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConst.USER_CAR_MENU);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        switch (input) {
            case MenuConst.THREE -> openUserMenu();
            case MenuConst.TWO -> openRepairMenu();
            case MenuConst.ONE -> openRefuelMenu();
            default -> {
                System.out.println(MenuConst.WRONG_NUMBER);
                openUserCarMenu();
            }
        }
    }

    private void openRefuelMenu() {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = carServiceImpl.readAll();
        System.out.println(MenuConst.CAR_REFUEL_MENU);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(MenuConst.EXIT)) {
            openUserMenu();
        }
        try {
            int number = Integer.parseInt(input);
            System.out.println(MenuConst.ENTER_FUEL_VOLUME);
            int fuelVol = scanner.nextInt();
            Car car = cars.get(number - 1);
            car.refuelCar(fuelVol);
            car.updateFuelVolume(fuelVol);
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_DATA);
            openRefuelMenu();
        } finally {
            openUserMenu();
        }
    }

    private void openRepairMenu() {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = carServiceImpl.readAll();
        System.out.println(MenuConst.CAR_REPAIR_MENU);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(MenuConst.EXIT)) {
            openUserMenu();
        }
        try {
            int number = Integer.parseInt(input);
            cars.get(number - 1).repairCar();
        } catch (Exception e) {
            System.out.println(MenuConst.WRONG_DATA);
            openRepairMenu();
        } finally {
            openUserMenu();
        }

    }

    private void openAdminMenu() {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println(MenuConst.ADD_CAR_MENU);
        System.out.print(MenuConst.CURSOR);
        String input = scanner.nextLine();
        //AUTO type selection
        switch (input) {
            case MenuConst.FOUR -> openAdminMenu();
            case MenuConst.ONE -> {
                try {
                    CargoCarImpl car = new CargoCarImpl();
                    car.setCarType(CarType.CARGO);
                    //Cargo car capacity selection
                    System.out.println(MenuConst.ENTER_CARGO_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    int cargoCapacity = scanner.nextInt();
                    car.setCargoCapacity(cargoCapacity);
                    //Cargo car body type selection
                    System.out.println(MenuConst.ENTER_BODY_TYPE);
                    System.out.print(MenuConst.CURSOR);
                    int bodyType = scanner.nextInt();
                    CargoCarBodyType cargoCarBodyType = carServiceImpl.selectBodyType(bodyType);
                    if (cargoCarBodyType != null) {
                        car.setBodyType(cargoCarBodyType);
                        addCar(car);
                    }
                } catch (Exception e) {
                    System.out.println(MenuConst.WRONG_DATA);
                } finally {
                    addCarMenu();
                }
            }
            case MenuConst.TWO -> {
                try {
                    PassengerCarImpl car = new PassengerCarImpl();
                    car.setCarType(CarType.PASSENGER);
                    //Passenger car capacity selection
                    System.out.println(MenuConst.ENTER_PASSENGER_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    int passCapacity = scanner.nextInt();
                    car.setPassengerCapacity(passCapacity);
                    addCar(car);
                } catch (Exception e) {
                    System.out.println(MenuConst.WRONG_NUMBER);
                } finally {
                    addCarMenu();
                }

            }
            case MenuConst.THREE -> {
                try {
                    GeneralCar car = new GeneralCar();
                    car.setCarType(CarType.GENERAL);
                    //General car passengers & cargo capacity selection
                    System.out.println(MenuConst.ENTER_PASSENGER_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    int passCapacity = scanner.nextInt();
                    car.setPassengerCapacity(passCapacity);
                    System.out.println(MenuConst.ENTER_CARGO_CAPACITY);
                    System.out.print(MenuConst.CURSOR);
                    int cargoCapacity = scanner.nextInt();
                    car.setCargoCapacity(cargoCapacity);
                    //General car body type selection
                    System.out.println(MenuConst.ENTER_BODY_TYPE);
                    System.out.print(MenuConst.CURSOR);
                    int bodyType = scanner.nextInt();
                    CargoCarBodyType cargoCarBodyType = carServiceImpl.selectBodyType(bodyType);
                    if (cargoCarBodyType != null) {
                        car.setBodyType(cargoCarBodyType);
                        addCar(car);
                    }
                } catch (Exception e) {
                    System.out.println(MenuConst.WRONG_NUMBER);
                } finally {
                    addCarMenu();
                }
            }
            default -> {
                System.out.println(MenuConst.WRONG_NUMBER);
                addCarMenu();
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
    }
}
