package com.company.warehouse;

//Класс "доверенность"
public class PowerOfAttorney {

    //поля
    private final String name = "Доверенность"; // доверенность
    private int number; // номер доверенности
    private int day_of_month; // день выдачи доверенности
    private int month; // месяц выдачи доверенности
    private int year; // год выдачи доверенности

    // Конструкторы
    // 1. Конструктор без параметров

    public PowerOfAttorney() {
        this.number = 1;
        this.day_of_month = 1;
        this.month = 1;
        this.year = 2000;
    }

    // 2. Конструктор с 4 параметрами

    public PowerOfAttorney(int number, int day_of_month, int month, int year) {
        this.number = number;
        this.day_of_month = day_of_month;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" № ").append(number).append(" от \" ").append(day_of_month).append(" \"");
        sb.append("    ").append(month).append("    ").append(year);
        return sb.toString();
    }
}//class close
