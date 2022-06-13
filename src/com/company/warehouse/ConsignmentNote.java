package com.company.warehouse;

import java.util.*;


//Класс - "Накладная"
public class ConsignmentNote implements Comparable<ConsignmentNote> {

    //поля
    private String fromWhom; // поле накладной "От кого"
    private String toWhom; // поле накладной "Кому"
    private String theReason; // поле накладной "Основание выдачи"
    private LinkedList<Product> products = new LinkedList<>(); // список товаров в накладной
    private int numberDocument; // номер накладной


    // Конструкторы
    // 1. Конструктор без параметров

    public ConsignmentNote() {
        this.fromWhom = "___________";
        this.toWhom = "______________";
        this.theReason = "Пустой бланк";
        this.products = new LinkedList<>();
        this.numberDocument = 1;
    }

    // 2. Конструктор с 5 параметрами
    public ConsignmentNote(int numberDocument, String fromWhom, String toWhom, String theReason) {
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.theReason = theReason;
        this.numberDocument = numberDocument;
    }

    //getters and setters

    public String getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getTheReason() {
        return theReason;
    }

    public void setTheReason(String theReason) {
        this.theReason = theReason;
    }

    public int getNumberDocument() {
        return numberDocument;
    }

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<Product> products) {
        this.products = products;
    }

    public void setNumberDocument(int numberDocument) {
        this.numberDocument = numberDocument;
    }

    // Методы
    // 1. метод toString

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        // добавим информацию из накладной в строку
        StringBuilder sb = new StringBuilder();
        sb.append("                      Накладная №    ").append(numberDocument);
        sb.append("\n                \" ").append(calendar.get(Calendar.DAY_OF_MONTH)).append(" \"");
        sb.append("    ").append(calendar.get(Calendar.MONTH));
        sb.append("    ").append(calendar.get(Calendar.YEAR));
        sb.append("\nОт кого: ").append(fromWhom);
        sb.append("\nКому: ").append(toWhom);
        sb.append("\nОснование: ").append(theReason).append("\n");
        return sb.toString();
    }

    // 2. метод вывода шапки таблицы накладной
    public void invoiceTable() {
        int count = 1;
        System.out.println("+-------+--------------+-------+--------+---------+---------+");
        System.out.println("| № п/п | Наименование |Ед.изм.| Кол-во |  Цена   |  Сумма  |");
        System.out.println("+-------+--------------+-------+--------+---------+---------+");
        for (Product list : products) {
            System.out.format("| %-6d| %-13s| %-6s| %-7.2f| %-8.2f| %-8.2f|%n", count++, list.getTitleProduct(),
                    list.getUnit(), list.getQuantityProduct(), list.getPrice(), amountProduct(list));
            //добавили сумму спомощью метода amountProduct()
        }
    }

    // 3. метод добавления товара в накладную
    public void addProduct(Product product) throws Exception {
        for (Product p : products) {
            if (p == null) {
                throw new Exception("Товар не существует!");
            }
        }
        products.add(product);

    }


    // 4. метод удаления товара из накладную
    public void removeProduct(Product product) throws Exception {
        for (Product p : products) {
            if (p == null) {
                throw new Exception("Товар не существует!");
            }
        }
        products.remove(product);
    }


    // 5. метод изменения полей товара
    public void changeProduct() throws Exception {
        Scanner in = new Scanner(System.in);
        String menu;//меню
        String valueTitle;
        double valuePrice;
        double valueQuantity;
        String valueUnit;
        for (Product product : products) {
            if (product == null) {
                throw new Exception("Товар не существует!");
            }
        }
        for (Product p : products) {
            System.out.println("0 - Выбрать следующий продукт ");
            System.out.println("1 - Изменить имя товара " + p.getTitleProduct() + " ? ");
            System.out.println("2 - Изменить цену товара " + p.getTitleProduct() + " - " + p.getPrice() + " ? ");
            System.out.println("3 - Изменить количество товара " + p.getTitleProduct() + " - " + p.getQuantityProduct() + " ? ");
            System.out.println("4 - Изменить единицу измерения товара " + p.getTitleProduct() + " - " + p.getUnit() + " ? ");
            System.out.println("5 - Назад ");
            menu = in.nextLine();
            if ("0".equals(menu)) {
                continue;//выбор следующей накладной
            }

            if ("1".equals(menu)) {
                System.out.println("Введите новое имя товара: ");
                valueTitle = in.nextLine();
                p.setTitleProduct(valueTitle);
                System.out.println(p);
                break;
            }
            if ("2".equals(menu)) {
                System.out.println("Введите новую цену товара ");
                valuePrice = in.nextInt();
                p.setPrice(valuePrice);
                System.out.println(p);
                break;
            }
            if ("3".equals(menu)) {
                System.out.println("Введите количество товара ");
                valueQuantity = in.nextInt();
                p.setQuantityProduct(valueQuantity);
                System.out.println(p);
                break;
            }
            if ("4".equals(menu)) {
                System.out.println("Введите единицу измерения товара ");
                valueUnit = in.nextLine();
                p.setUnit(valueUnit);
                System.out.println(p);
                break;
            }
        }
    }

    // 6. метод вывода всех товаров  накладной
    public void printProductOfConsignment() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            if (p == null) {
                throw new Exception("Товар не существует!");
            }
            sb.append(p.getTitleProduct());
            sb.append("\n");
        }
        System.out.print(sb);
    }


    // 7. метод расчёта суммы товара
    public double amountProduct(Product product) {
        return product.getQuantityProduct() * product.getPrice();
    }

    // 8. метод compare - сравнивает накладные по номеру
    public int compareTo(ConsignmentNote product) {
        //сравниваем накладные по номеру
        return Double.compare(numberDocument, product.numberDocument);
    }

}//class close
