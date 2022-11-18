package ru.clevertec.task2.entity.car.cargo;

import ru.clevertec.task2.entity.car.Car;
import ru.clevertec.task2.entity.car.CarType;
import ru.clevertec.task2.entity.fuel.FuelType;

public class CargoCarImpl extends Car implements CargoCar {

    private int cargoCapacity;

    private CargoCarBodyType bodyType;

    public CargoCarImpl(CarType carType, String brand, String model, CargoCarBodyType bodyType, int issueYear,
                        FuelType fuelType, int fuelConsumption, int cargoCapacity) {
        super(carType, brand, model, issueYear, fuelType, fuelConsumption);
        this.cargoCapacity = cargoCapacity;
        this.bodyType = bodyType;
    }

    public CargoCarImpl() {
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
        this.setNumberOfUnits(numberOfCargo);
    }

    @Override
    public void cargoLeft() {
        int left = this.cargoCapacity - this.getNumberOfUnits();
        System.out.println("Осталось свободного места под грузы: " + left);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cargoCapacity=" + cargoCapacity +
                ", bodyType=" + bodyType;
    }
}
