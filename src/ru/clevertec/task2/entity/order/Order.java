package ru.clevertec.task2.entity.order;

import ru.clevertec.task2.entity.car.Car;

import java.time.LocalDate;
import java.util.Objects;


public class Order {

    private static int orderCount = 0;

    private int id;

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

    public void setLocalDate(String localDate) {
        String[] split = localDate.split("\\.");
        this.localDate = LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),
                Integer.parseInt(split[0]));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return departurePoint.equals(order.departurePoint) && arrivalPoint.equals(order.arrivalPoint)
                && localDate.equals(order.localDate) && car.equals(order.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departurePoint, arrivalPoint, localDate, car);
    }
}
