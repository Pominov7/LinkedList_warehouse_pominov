package com.company.warehouse;

//Класс Вывода информации по складу

/**
 * Задание.
 * 1. Написать приложение «Склад». Склад служит хранилищем для товаров, товары добавляются на склад,
 * берутся со склада, изменяются через накладную. Необходимо написать соответствующие классы, реализующие
 * функционал для регистрации операция с товарами. Использовать коллекции ArrayList, LinkedList, HashSet,
 * HashMap (выбор обосновать для того или иного контейнера, выбрать нужные коллекции самостоятельно).
 * Регистрация поступления или отгрузки товаров осуществляется по накладной (документ).
 * 2. Реализовать:
 * - добавление/удаление/изменение товаров в накладной
 * - добавление/удаление/изменение накладных на складе
 * - вывод товаров накладной (+ поиск/сортировка по разным полям)
 * - вывод накладных товаров (+ поиск/сортировка по разным полям)
 * 3. Реализовать для двух любых сущностей Comparable и Comparator-интерфейсы (в случае компаратора сделать соответствующий класс).
 * 4. Написать CLI-часть (в достаточно мере для тестирования).
 */
public class ShowStock {

    public static void main(String[] args) throws Exception {

        //Создадим склад
        Stock stock = new Stock();
        //вызвали меню склада
        stock.showMenu();

    }//main

}//close class


