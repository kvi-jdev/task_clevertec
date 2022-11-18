package ru.clevertec.task2.entity.car.passenger;

import ru.clevertec.task2.entity.car.Car;
import ru.clevertec.task2.entity.car.CarType;
import ru.clevertec.task2.entity.fuel.FuelType;

public class PassengerCarImpl extends Car implements PassengerCar {

    private int passengerCapacity;


    public PassengerCarImpl(CarType carType, String brand, String model, int issueYear, FuelType fuelType,
                            int fuelConsumption, int passengerCapacity) {
        super(carType, brand, model, issueYear, fuelType, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
    }

    public PassengerCarImpl(){

    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }


    @Override
    public void addPassenger(int numberOfPassengers) {
        this.setNumberOfUnits(numberOfPassengers);
    }

    @Override
    public void passengersLeft() {
        int left = passengerCapacity - this.getNumberOfUnits();
        System.out.println("Осталось свободных мест: " + left);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", passengerCapacity=" + passengerCapacity;
    }
}
