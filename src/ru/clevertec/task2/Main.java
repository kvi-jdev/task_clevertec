package ru.clevertec.task2;

import ru.clevertec.task2.controller.ConsoleController;
import ru.clevertec.task2.entity.car.CarType;
import ru.clevertec.task2.entity.car.cargo.CargoCarBodyType;
import ru.clevertec.task2.entity.car.cargo.CargoCarImpl;
import ru.clevertec.task2.entity.car.passenger.PassengerCarImpl;
import ru.clevertec.task2.entity.fuel.FuelType;
import ru.clevertec.task2.service.CarServiceImpl;
import ru.clevertec.task2.service.OrderServiceImpl;

public class Main {

    public static void main(String[] args) {

        CarServiceImpl carServiceImpl = new CarServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();
        ConsoleController controller = new ConsoleController(carServiceImpl, orderService);
        controller.start();

        /*CarServiceImpl carService = new CarServiceImpl();
        CargoCarImpl cargoCar = new CargoCarImpl(CarType.CARGO, "Mers", "BENZ", CargoCarBodyType.FRIDGE, 2015, FuelType.DIESEL,
                10, 200);
        PassengerCarImpl passengerCar = new PassengerCarImpl(CarType.PASSENGER,"Mers", "BENZ", 2015, FuelType.DIESEL,
                10, 200 );
        carService.add(cargoCar);
        carService.add(passengerCar);

        carService.readAll();*/

    }
}
