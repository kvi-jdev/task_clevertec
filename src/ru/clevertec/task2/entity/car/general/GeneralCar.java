package ru.clevertec.task2.entity.car.general;

import ru.clevertec.task2.entity.car.Car;
import ru.clevertec.task2.entity.car.CarType;
import ru.clevertec.task2.entity.car.cargo.CargoCar;
import ru.clevertec.task2.entity.car.cargo.CargoCarBodyType;
import ru.clevertec.task2.entity.car.passenger.PassengerCar;
import ru.clevertec.task2.entity.fuel.FuelType;

public class GeneralCar extends Car implements CargoCar, PassengerCar {

    private int passengerCapacity;

    private int cargoCapacity;

    private CargoCarBodyType bodyType;


    public GeneralCar(CarType carType, String brand, String model, CargoCarBodyType bodyType,
                      int issueYear, FuelType fuelType, int fuelConsumption,
                      int passengerCapacity, int cargoCapacity) {
        super(carType, brand, model, issueYear, fuelType, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.bodyType = bodyType;
    }

    public GeneralCar(){}


    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public CargoCarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CargoCarBodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public void addCargo(int numberOfCargo) {
        this.cargoCapacity += numberOfCargo;
    }

    @Override
    public void cargoLeft() {
        int left = this.cargoCapacity - this.getNumberOfUnits();
        System.out.println("Осталось свободного места под грузы: " + left);
    }

    @Override
    public void addPassenger(int numberOfPassengers) {
        this.passengerCapacity += numberOfPassengers;
    }

    @Override
    public void passengersLeft() {
        int left = passengerCapacity - this.getNumberOfUnits();
        System.out.println("Осталось свободных мест: " + left);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", passengerCapacity=" + passengerCapacity +
                ", cargoCapacity=" + cargoCapacity +
                ", bodyType=" + bodyType;
    }
}
