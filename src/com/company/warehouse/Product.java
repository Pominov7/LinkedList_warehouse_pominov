package com.company.warehouse;

//Класс - товар
public class Product implements Comparable<Product> {

    //поля
    private String titleProduct; // наименование товара
    private String unit; // единица измерения товара
    private double price; // цена товара
    private double quantityProduct; // количество товара

    // Конструкторы
    // 1. Конструктор без параметров

    public Product() {
        this.titleProduct = "title";
        this.unit = "unit";
        this.price = 0.0;
        this.quantityProduct = 1.0;
    }

    // 2. Конструктор с 3 параметрами
    public Product(String titleProduct, String unit, double quantityProduct, double price) {
        this.titleProduct = titleProduct;
        this.unit = unit;
        this.price = price;
        this.quantityProduct = quantityProduct;
    }

    //getters and setters

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(double quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Методы
    // 1. метод toString

    @Override
    public String toString() {
        // добавим информацию о товаре в строку
        StringBuilder sb = new StringBuilder();
        sb.append("Продукт \"").append(titleProduct).append("\":");
        sb.append(" цена - ").append(price).append(" руб.");
        sb.append(" ").append(unit).append(".");
        return sb.toString();
    }

    // 2. метод compare - сравнивает товар по количеству в накладной
    public int compareTo(Product product) {
        //сравниваем количество товара
        return Double.compare(quantityProduct, product.quantityProduct);
    }

}//close class
