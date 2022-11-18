package ru.clevertec.task2.entity.order;

import ru.clevertec.task2.entity.car.Car;

import java.time.LocalDate;


public class Order {

    private static int orderCount = 0;

    private int id = 0;

    private String departurePoint;

    private String arrivalPoint;

    private LocalDate localDate;

    private Car car;

    public Order() {
        this.id = orderCount++;
    }

    public Order(String departurePoint, String arrivalPoint, LocalDate localDate, Car car) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.localDate = localDate;
        this.car = car;
        this.id = orderCount++;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public int getId() {
        return id;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Order " +
                "id=" + id +
                ", departurePoint=" + departurePoint +
                ", arrivalPoint=" + arrivalPoint +
                ", localDate=" + localDate +
                ", car=" + car.getBrand() + " " + car.getModel() + " " + car.getCarType();
    }
}
