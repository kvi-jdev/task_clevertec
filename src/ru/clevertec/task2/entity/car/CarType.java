package ru.clevertec.task2.entity.car;

public enum CarType {

    CARGO {
        @Override
        public String getCarTypeName() {
            return "Грузовой";
        }
    },
    PASSENGER {
        @Override
        public String getCarTypeName() {
            return "Пассажирский";
        }
    },
    GENERAL{
        @Override
        public String getCarTypeName() {
            return "Грузо-пассажирский";
        }
    };

    public abstract String getCarTypeName();


}
