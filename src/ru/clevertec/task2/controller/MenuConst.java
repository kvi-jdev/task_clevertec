package ru.clevertec.task2.controller;

import java.time.LocalDate;

public class MenuConst {

    private MenuConst(){

    }

    public static final String CURSOR = "-->";

    public static final String EXIT = "exit";

    public static final String FOUR = "4";

    public static final String THREE = "3";

    public static final String TWO = "2";

    public static final String ONE = "1";

    public static final String WRONG_NUMBER = "\nВведено неверное число! Повторите попытку\n";
    public static final String WRONG_DATA = "\nВведены неверные значения! Повторите попытку\n";
    public static final String CAR_ADDED = "\nМашина успешно добавлена!\n";
    public static final String CAR_NOT_ADDED = "\nОшибка! Машина не добавлена!\n";

    public static final String CAR_LIST_EMPTY = "\nОшибка! Список машин пуст!\n";

    public static final String ORDER_LIST_EMPTY = "\nОшибка! Список заказов пуст!\n";
    public static final String CAR_DELETED = "\nМашина успешно удалена!\n";

    public static final String CAR_NOT_DELETED = "\nОшибка! Машина не удалена!\n";

    public static final String ENTER_CARGO_CAPACITY = "\nВведите вместимость грузов (кг):";

    public static final String UPDATE_CARGO = "\nВведите количество груза для добавления (кг):";

    public static final String UPDATE_PASS = "\nВведите количество пассажиров для добавления (чел):";

    public static final String ENTER_PASSENGER_CAPACITY = "\nВведите вместимость пассажиров (чел):";

    public static final String ENTER_FUEL_VOLUME = "\nВведите  количество топлива для заправки (л):";

    public static final String ORDER_CONFIRMED = "\nЗаказ успешно оформлен!\n";

    public static final String ORDER_NOT_CONFIRMED = "\nОшибка! Заказ не оформлен";

    public static final String TOO_MUCH_UNITS = "\nОшибка! автомобиль столько не вмещает!";

    public static final String DATE_NOT_PASSED = "\nОшибка! Введите дату после " + LocalDate.now();

    public static final String LIST_ORDER_MENU = "\nСписок заказов:\n";

    public static final String ENTER_ARRIVAL = "\nВведите пункт назначения (название города):";

    public static final String ENTER_DATE =  """
                        
            Введите желаемую дату отправки в формате:
                        [дд.мм.гггг]""";

    public static final String ADD_CARGO_PASS =  """
                        
            Введите 1 для добавления груза/пассажиров в заказ
            Введите 2 для выхода в меню""";

    public static final String CHOOSE_CAR = """
                        
            Введите id машины для оформления заказа:""";

    public static final String CHOOSE_ORDER = """
                        
            Введите id заказа для обновления:""";

    public static final String ENTER_BODY_TYPE = """
                        
                - Выберите тип кузова -
            Введите 1 для кузова-цистерны
            Введите 2 для кузова-тента
            Введите 3 для кузова-холодильника""";

    public static final String DIESEL = "дизель";

    public static final String PETROL = "бензин";

    public static final String GAS = "метан";

    public static final String CARGO = "Грузовой";

    public static final String PASSENGER = "Пассажирский";

    public static final String CARGO_PASSENGER = "Грузо-пассажирский";

    public static final String MAIN_MENU = """
                        
                   - Главное меню -
                       WELCOME!
            Введите 1 для авторизации как admin
            Введите 2 для авторизации как user
                  Введите 3 для выхода""";

    public static final String ADMIN_MENU = """
                        
            Введите 1 для добавления новой машины
            Введите 2 для просмотра/удаления машины
            Введите 3 для выхода в главное меню""";

    public static final String USER_MENU = """
            
            Введите 1 для работы с заказами
            Введите 2 для работы с машинами
            Введите 3 для выхода в главное меню""";

    public static final String USER_CAR_MENU = """
            
            Введите 1 для заправки машины
            Введите 2 для ремонта машины
            Введите 3 для выхода в меню""";

    public static final String USER_ORDER_MENU = """
            
            Введите 1 для оформления нового заказа
            Введите 2 для просмотра списка заказов
            Введите 3 для выхода в меню""";

    public static final String CREATE_ORDER_MENU = """
            
              - Меню оформления заказа -
            Введите пункт отправки заказа (название города)""";

    public static final String ADD_CAR_MENU = """
                        
            Введите 1 для добавления грузовой машины
            Введите 2 для добавления пассажирской машины
            Введите 3 для добавления грузо-пассажирской машины
            Введите 4 для выхода в меню""";

    public static final String DELETE_CAR_MENU = """
                        
            Введите id машины для удаления
            Введите exit для выхода в меню""";

    public static final String CAR_REPAIR_MENU = """
                        
            Введите id машины для ремонта
            Введите exit для выхода в меню""";

    public static final String CAR_REFUEL_MENU = """
                        
            Введите id машины для заправки
            Введите exit для выхода в меню""";

    public static final String LINE_ADD_CAR = """
                        
            Введите данные по машине в формате:
            [бренд,модель,год выпуска, вид топлива (дизель/бензин/метан)]
            Значения допускается разделять любым сиволом (не буквой и не цифрой)""";
}
