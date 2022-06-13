package com.company.warehouse;

import java.util.Comparator;

//Класс- компаратор для "Товара"
public class ComparatorProduct implements Comparator<Product> {

    //метод сравнения товаров по сумме
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
