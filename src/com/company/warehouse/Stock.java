package com.company.warehouse;

import java.util.*;

//Класс - Склад
public class Stock {

    //поля
    private ConsignmentNote note; //  накладная на складе
    private LinkedList<ConsignmentNote> document = new LinkedList<>();//список накладных на складе
    private LinkedList<Product> products = new LinkedList<>(); // список товаров на складе
    // Конструкторы
    // 1. Конструктор без параметров

    public Stock() {
        this.note = new ConsignmentNote();
    }

    // 2. Конструктор с одним параметром
    public Stock(LinkedList<ConsignmentNote> document) {
        this.document = document;
    }

    //getters
    public LinkedList<ConsignmentNote> getDocument() {
        return document;
    }

    // Методы
    // 1. метод toString
    @Override
    public String toString() {
        // добавим информацию о товаре в строку
        StringBuilder sb = new StringBuilder();
        for (ConsignmentNote list : document) {
            sb.append("\nНакладная № ").append(list.getNumberDocument());
        }
        return sb.toString();
    }

    // 2. метод добавления товара на склад
    public void addProductInStock(Product product) throws Exception {
        for (Product p : products) {
            if (p == null) {
                throw new Exception("Товар не существует!");
            }
        }
        products.add(product);

    }

    // 3. метод добавления накладной на склад
    public void addConsignmentNote(ConsignmentNote doc) throws Exception {
        for (ConsignmentNote note : document) {
            if (note == null) {
                throw new Exception("Накладная не существует!");
            } else if (note.getNumberDocument() == doc.getNumberDocument()) {
                throw new Exception("Накладная с номером " + doc.getNumberDocument() + " уже существует, измените номер!!!");
            }
        }
        document.add(doc);
    }

    // 4. метод удаления накладной из склада
    public void removeConsignmentNote() throws Exception {
        Scanner in = new Scanner(System.in);
        String menu;
        for (ConsignmentNote note : document) {
            if (note == null) {
                throw new Exception("Накладная не существует!");
            }
        }
        for (ConsignmentNote n : document) {
            System.out.println("1 - Удалить накладную № " + n.getNumberDocument() + " ? ");
            System.out.println("2 - Выбрать следующую накладную ");
            System.out.println("3 - Назад ");

            menu = in.nextLine();
            if ("1".equals(menu)) {
                document.remove(n);
                break;
            }
            if ("2".equals(menu)) {
                continue;//выбор следующей накладной
            }
            if ("3".equals(menu)) {
                break;
            }
        }
    }

    // 5. метод изменения полей накладной
    public void changeConsignmentNote() throws Exception {
        Scanner in = new Scanner(System.in);
        String menu;//меню
        int valueNumber;//меню
        String valueStr;//меню
        for (ConsignmentNote note : document) {
            if (note == null) {
                throw new Exception("Накладная не существует!");
            }
        }
        for (ConsignmentNote n : document) {
            System.out.println("0 - Выбрать следующую накладную ");
            System.out.println("1 - Изменить поле накладной  " + n.getFromWhom() + " ? ");
            System.out.println("2 - Изменить поле накладной  " + n.getToWhom() + " ? ");
            System.out.println("3 - Изменить поле накладной  " + n.getTheReason() + " ? ");
            System.out.println("4 - Изменить поле накладной  " + n.getNumberDocument() + " ? ");
            System.out.println("5 - Назад ");
            menu = in.nextLine();

            if ("0".equals(menu)) {
                continue;//выбор следующей накладной
            }

            if ("1".equals(menu)) {
                System.out.println("Введите новое поле накладной ");
                valueStr = in.nextLine();
                n.setFromWhom(valueStr);
                System.out.println(n);
                break;
            }
            if ("2".equals(menu)) {
                System.out.println("Введите новое поле накладной ");
                valueStr = in.nextLine();
                n.setToWhom(valueStr);
                System.out.println(n);
                break;
            }
            if ("3".equals(menu)) {
                System.out.println("Введите новое поле накладной ");
                valueStr = in.nextLine();
                n.setTheReason(valueStr);
                System.out.println(n);
                break;
            }
            if ("4".equals(menu)) {
                System.out.println("Введите новое поле накладной ");
                valueNumber = in.nextInt();
                n.setNumberDocument(valueNumber);
                System.out.println(n);
                break;
            }
        }
    }

    // 6. метод поиска накладной
    public void searchConsignmentNote() {
        System.out.println("Введите номер накладной:");
        Scanner in = new Scanner(System.in);
        int numberDocument = in.nextInt();
        for (ConsignmentNote note : document) {
            if (numberDocument == note.getNumberDocument()) {
                System.out.println(note);
                return;
            }
        }
        System.out.println("Накладной с таким номером нет на складе");
    }


    // 7. вывод меню
    public void showMenu() throws Exception {
        Menu.showMenu();
    }

    // 8. метод поиска товара
    public void searchProduct() {
        System.out.println("Введите наименование товара:");
        Scanner in = new Scanner(System.in);
        String titleProduct = in.nextLine();
        for (Product p : products) {
            if (Objects.equals(titleProduct, p.getTitleProduct())) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Товара с таким наименованием нет на складе");
    }

}//class close
