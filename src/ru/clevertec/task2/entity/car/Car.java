package ru.clevertec.task2.entity.car;

import ru.clevertec.task2.entity.fuel.FuelType;
import java.util.Objects;

public abstract class Car implements CommonCar {

    private static int carCount = 1;

    private int id;

    private CarType carType;

    private String brand;

    private String model;

    private int issueYear;

    private FuelType fuelType;

    private int fuelVolume = 10;


    private int numberOfUnitsPass = 0;



    private int numberOfUnitsCargo = 0;

    public Car() {
        this.id = carCount;
        carCount++;
    }

    public Car(CarType carType, String brand, String model, int issueYear, FuelType fuelType) {
        this.carType = carType;
        this.brand = brand;
        this.model = model;
        this.issueYear = issueYear;
        this.fuelType = fuelType;

    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public void updateFuelVolume(int fuelVolume) {
        this.fuelVolume += fuelVolume;
    }

    public int getNumberOfUnitsPass() {
        return numberOfUnitsPass;
    }

    public void setNumberOfUnitsPass(int numberOfUnitsPass) {
        this.numberOfUnitsPass = numberOfUnitsPass;
    }

    public int getNumberOfUnitsCargo() {
        return numberOfUnitsCargo;
    }

    public void setNumberOfUnitsCargo(int numberOfUnitsCargo) {
        this.numberOfUnitsCargo = numberOfUnitsCargo;
    }

    public void updateNumberOfUnitsPass(int numberOfUnits) {
        this.numberOfUnitsPass += numberOfUnits;
    }

    public void updateNumberOfUnitsCargo(int numberOfUnits) {
        this.numberOfUnitsCargo += numberOfUnits;
    }

    public void addCargo(int numberOfUnits) {
        this.numberOfUnitsCargo += numberOfUnits;
    }

    public void addPassenger(int numberOfUnits) {
        this.numberOfUnitsPass += numberOfUnits;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", carType=" + carType.getCarTypeName() +
                ", brand=" + brand +
                ", model=" + model +
                ", issueYear=" + issueYear +
                ", fuelType=" + fuelType +
                ", fuelVolume=" + fuelVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return issueYear == car.issueYear && carType == car.carType && brand.equals(car.brand) && model.equals(car.model) && fuelType == car.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carType, brand, model, issueYear, fuelType);
    }
}
