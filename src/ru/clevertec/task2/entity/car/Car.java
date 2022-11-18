package ru.clevertec.task2.entity.car;

import ru.clevertec.task2.entity.fuel.FuelType;
import ru.clevertec.task2.entity.order.Order;

import java.util.List;
import java.util.Objects;

public abstract class Car implements CommonCar {

    private static int carCount = 0;

    private int id;

    private CarType carType;

    private String brand;

    private String model;

    private int issueYear;

    private FuelType fuelType;

    private int fuelVolume = 10;


    private int numberOfUnits = 0;

    private List<Order> orderList;

    public Car() {
        carCount++;
        this.id = carCount;
    }

    public Car(CarType carType, String brand, String model, int issueYear, FuelType fuelType, int fuelVolume) {
        this.carType = carType;
        this.brand = brand;
        this.model = model;
        this.issueYear = issueYear;
        this.fuelType = fuelType;
        this.fuelVolume = fuelVolume;
        carCount++;
        this.id = carCount;
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
        this.fuelVolume += fuelVolume;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits += numberOfUnits;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public boolean addOrder(Car car, Order order) {
        boolean b = checkOrder(car, order);
        if (b) {
            car.orderList.add(order);
        }
        return b;

    }

    private boolean checkOrder(Car car, Order order) {
        boolean result = true;
        for (Order value : orderList) {
            if (value.getLocalDate().isEqual(order.getLocalDate())) {
                result = false;
            }

        }
        return result;
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
