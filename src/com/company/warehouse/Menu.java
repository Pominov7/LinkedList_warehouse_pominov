package com.company.warehouse;

import java.util.Collections;
import java.util.Scanner;

//Класс - Меню
public class Menu {

    //Вывод накладной
    public static void showConsignmentNote(ConsignmentNote note, PowerOfAttorney document) {
        //выводим поля накладной
        System.out.println(note);
        //выводим доверенность
        System.out.println(document);
        //выводим таблицу в накладной
        note.invoiceTable();
        System.out.println();
    }

    public static void showMenu() throws Exception {
        //Создали сканер

        Scanner in = new Scanner(System.in);
        String menu;// переменная для ввода меню
        System.out.println();
        //Создадим склад
        Stock stock = new Stock();

        //Создадим товары

        Product screw = new Product("Винты", "шт.", 10, 15.85);
        Product nails = new Product("Гвозди", "кг.", 3.0, 50.15);
        Product paper = new Product("Бумага", "уп.", 4.0, 90.99);
        Product pencil = new Product("Карандаш", "шт.", 20.0, 9.50);
        Product ductTape = new Product("Скотч", "шт.", 20.0, 70.0);
        Product paint = new Product("Краска", "кг.", 7.0, 100.0);
        Product antifreeze = new Product("Антифриз", "л.", 5.0, 220.0);
        Product monitor = new Product("Монитор", "шт.", 1.0, 11300.0);

        // Создаём накладные, и добавим в них товары

        ConsignmentNote number_1 = new ConsignmentNote(14, "Шпак Н.С.", "Петров Д.А.",
                "Для нужд отдела");
        ConsignmentNote number_2 = new ConsignmentNote(20, "Иванов А.С.", "Королев П.А.",
                "Распоряжение директора");
        ConsignmentNote number_3 = new ConsignmentNote(32, "Абрамов А.С.", "Никулин Ю.А.",
                "Для служебного автомобиля");

        //Пустой бланк накладной
        ConsignmentNote number_4 = new ConsignmentNote();

        ConsignmentNote number_5 = new ConsignmentNote(32, " Дудкин Д.Д.", "Цветкова И.М",
                "Черновик, накладная непонадобилась");

        //создаём доверенность на накладную №14
        PowerOfAttorney data_1 = new PowerOfAttorney(15, 30, 3, 2022);

        //создаём доверенность на накладную №20
        PowerOfAttorney data_2 = new PowerOfAttorney(3, 10, 4, 2022);

        //создаём доверенность на накладную №32
        PowerOfAttorney data_3 = new PowerOfAttorney(25, 17, 5, 2022);
        //вывод накладной на экран

        //создаём доверенность на пустую накладную №1
        PowerOfAttorney data_4 = new PowerOfAttorney();

        //добавляем товары в накладные
        try {
            //добавление товаров в накладную №14
            number_1.addProduct(screw);
            number_1.addProduct(nails);
            number_1.addProduct(paper);
            number_1.addProduct(pencil);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            //добавление товаров в накладную №20
            number_2.addProduct(ductTape);
            number_2.addProduct(paint);
            number_2.addProduct(monitor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            //добавление товаров в накладную №32
            number_3.addProduct(antifreeze);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Меню
        while (true) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println("1 - Довавить товар и накладные на склад и вывести на экран ");
            System.out.println("2 - Выбрать накладную и изменить товар в накладной ");
            System.out.println("3 - Инфррмация о товаре на складе ");
            System.out.println("4 - Удалить товар из накладной ");
            System.out.println("5 - Удалить накладную со склада ");
            System.out.println("6 - Изменить накладную");
            System.out.println("7 - Поиск накладной по номеру");
            System.out.println("8 - Поиск товара по имени");
            System.out.println("9 - выход ");
            menu = in.nextLine();

            if ("1".equals(menu)) {
                System.out.println("Накладные на складе: ");
                try {
                    stock.addConsignmentNote(number_2);
                    stock.addConsignmentNote(number_3);
                    stock.addConsignmentNote(number_1);
                    stock.addConsignmentNote(number_4);
                    stock.addConsignmentNote(number_5);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                //Добавление товара на складе:
                try {
                    stock.addProductInStock(screw);
                    stock.addProductInStock(nails);
                    stock.addProductInStock(paint);
                    stock.addProductInStock(pencil);
                    stock.addProductInStock(ductTape);
                    stock.addProductInStock(paint);
                    stock.addProductInStock(monitor);
                    stock.addProductInStock(antifreeze);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(stock);
                System.out.println();
                while (true) {
                    System.out.println("1 - Сортировать накладные по номеру? ");
                    System.out.println("2 - Сортировать накладные по ФИО \"От кого\"? ");
                    System.out.println("3 - Назад? ");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        Collections.sort(stock.getDocument());
                        System.out.println(stock);
                        System.out.println();
                        break;
                    }
                    if ("2".equals(menu)) {
                        stock.getDocument().sort(new ComparatorConsignmentNote());
                        System.out.println();
                        break;
                    }
                    if ("3".equals(menu)) {
                        break;
                    }
                }
            }
            if ("2".equals(menu)) {
                System.out.println(stock);
                System.out.println();
                while (true) {
                    System.out.println("1 - Накладная № " + number_4.getNumberDocument());
                    System.out.println("2 - Накладная № " + number_1.getNumberDocument());
                    System.out.println("3 - Накладная № " + number_2.getNumberDocument());
                    System.out.println("4 - Накладная № " + number_3.getNumberDocument());
                    System.out.println("0 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        showConsignmentNote(number_4, data_4);

                    }
                    if ("2".equals(menu)) {
                        //сортировка товаров в накладной по количеству товаров
                        Collections.sort(number_1.getProducts());
                        showConsignmentNote(number_1, data_1);
                        while (true) {
                            System.out.println("Используется сортировка товара по количеству ");
                            System.out.println("1 -Изменить товар? ");
                            System.out.println("2 - Возврат в меню");
                            menu = in.nextLine();
                            if ("1".equals(menu)) {

                                number_1.changeProduct();
                                showConsignmentNote(number_1, data_1);
                            }
                            if ("2".equals(menu)) {
                                break;
                            }
                        }
                    }

                    if ("3".equals(menu)) {
                        new ComparatorProduct();
                        showConsignmentNote(number_2, data_2);
                        while (true) {
                            System.out.println("Используется сортировка товара по цене от меньшей к большей ");
                            System.out.println("1 -Изменить товар? ");
                            System.out.println("2 - Возврат в меню");
                            menu = in.nextLine();
                            if ("1".equals(menu)) {
                                number_2.changeProduct();
                                showConsignmentNote(number_2, data_2);
                            }
                            if ("2".equals(menu)) {
                                break;
                            }
                        }
                    }
                    if ("4".equals(menu)) {
                        showConsignmentNote(number_3, data_3);
                        while (true) {
                            System.out.println("1 -Изменить товар? ");
                            System.out.println("2 - Возврат в меню");
                            menu = in.nextLine();
                            if ("1".equals(menu)) {
                                number_3.changeProduct();
                                showConsignmentNote(number_3, data_3);
                            }
                            if ("2".equals(menu)) {
                                break;
                            }
                        }
                    }
                    if ("0".equals(menu)) {
                        break;
                    }
                }//while
            }//2

            if ("3".equals(menu)) {
                System.out.println("Товары на складе : ");
                try {
                    number_1.printProductOfConsignment();
                    number_2.printProductOfConsignment();
                    number_3.printProductOfConsignment();
                    number_4.printProductOfConsignment();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println();
                while (true) {
                    System.out.println("1 - Информация о товаре: " + screw.getTitleProduct());
                    System.out.println("2 - Информация о товаре: " + nails.getTitleProduct());
                    System.out.println("3 - Информация о товаре: " + paper.getTitleProduct());
                    System.out.println("4 - Информация о товаре: " + pencil.getTitleProduct());
                    System.out.println("5 - Информация о товаре: " + ductTape.getTitleProduct());
                    System.out.println("6 - Информация о товаре: " + paint.getTitleProduct());
                    System.out.println("7 - Информация о товаре: " + monitor.getTitleProduct());
                    System.out.println("8 - Информация о товаре: " + antifreeze.getTitleProduct());
                    System.out.println("0 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        System.out.println(screw);

                    }
                    if ("2".equals(menu)) {
                        System.out.println(nails);

                    }
                    if ("3".equals(menu)) {
                        System.out.println(paper);

                    }
                    if ("4".equals(menu)) {
                        System.out.println(pencil);

                    }
                    if ("5".equals(menu)) {
                        System.out.println(ductTape);

                    }
                    if ("6".equals(menu)) {
                        System.out.println(paint);

                    }
                    if ("7".equals(menu)) {
                        System.out.println(monitor);

                    }
                    if ("8".equals(menu)) {
                        System.out.println(antifreeze);

                    }
                    if ("0".equals(menu)) {
                        break;
                    }
                }
            }

            if ("4".equals(menu)) {
                System.out.println(stock);
                System.out.println();
                while (true) {
                    System.out.println("Выбирете накладную:  ");
                    System.out.println("1 - Накладная № " + number_1.getNumberDocument());
                    System.out.println("2 - Накладная № " + number_2.getNumberDocument());
                    System.out.println("3 - Накладная № " + number_3.getNumberDocument());
                    System.out.println("4 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        while (true) {
                            System.out.println("1 - Удалить " + screw.getTitleProduct());
                            System.out.println("2 - Удалить " + nails.getTitleProduct());
                            System.out.println("3 - Удалить " + paper.getTitleProduct());
                            System.out.println("4 - Удалить " + pencil.getTitleProduct());
                            System.out.println("5 - Назад ");
                            menu = in.nextLine();
                            if ("1".equals(menu)) {
                                number_1.removeProduct(screw);
                                showConsignmentNote(number_1, data_1);

                            }

                            if ("2".equals(menu)) {
                                number_1.removeProduct(nails);
                                showConsignmentNote(number_1, data_1);

                            }
                            if ("3".equals(menu)) {
                                number_1.removeProduct(paper);
                                showConsignmentNote(number_1, data_1);

                            }
                            if ("4".equals(menu)) {
                                number_1.removeProduct(pencil);
                                showConsignmentNote(number_1, data_1);
                            }
                            if ("5".equals(menu)) {
                                break;
                            }
                        }//while
                    }

                    if ("2".equals(menu)) {
                        while (true) {
                            System.out.println("1 - Удалить " + ductTape.getTitleProduct());
                            System.out.println("2 - Удалить " + paint.getTitleProduct());
                            System.out.println("3 - Удалить " + monitor.getTitleProduct());
                            System.out.println("4 - Назад ");
                            menu = in.nextLine();
                            if ("1".equals(menu)) {
                                number_2.removeProduct(ductTape);
                                showConsignmentNote(number_2, data_2);

                            }

                            if ("2".equals(menu)) {
                                number_2.removeProduct(paint);
                                showConsignmentNote(number_2, data_2);

                            }
                            if ("3".equals(menu)) {
                                number_2.removeProduct(monitor);
                                showConsignmentNote(number_2, data_2);

                            }
                            if ("4".equals(menu)) {
                                break;
                            }
                        }//while
                    }
                    if ("3".equals(menu)) {
                        while (true) {
                            System.out.println("1 - Удалить " + antifreeze.getTitleProduct());
                            System.out.println("2 - Назад ");
                            menu = in.nextLine();
                            if ("1".equals(menu)) {
                                number_3.removeProduct(antifreeze);
                                showConsignmentNote(number_3, data_3);
                            }
                            if ("2".equals(menu)) {
                                break;
                            }
                        }//while
                    }
                    if ("4".equals(menu)) {
                        break;
                    }
                }//while
            }
            if ("5".equals(menu)) {
                System.out.println(stock);
                System.out.println();
                while (true) {
                    System.out.println("1 -Удалить накладную? ");
                    System.out.println("2 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        stock.removeConsignmentNote();
                        System.out.println(stock);
                    }
                    if ("2".equals(menu)) {
                        break;
                    }
                }//while
            }
            if ("6".equals(menu)) {
                System.out.println(stock);
                System.out.println();
                while (true) {
                    System.out.println("1 -Изменить накладную? ");
                    System.out.println("2 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        stock.changeConsignmentNote();
                        System.out.println(stock);
                    }
                    if ("2".equals(menu)) {
                        break;
                    }
                }//while
            }

            if ("7".equals(menu)) {
                System.out.println();
                while (true) {
                    System.out.println("1 - Для поиска накладной по номеру ");
                    System.out.println("2 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        stock.searchConsignmentNote();
                    }
                    if ("2".equals(menu)) {
                        break;
                    }
                }//while
            }
            if ("8".equals(menu)) {
                System.out.println();
                while (true) {
                    System.out.println("1 - Для поиска товара по имени ");
                    System.out.println("2 - Возврат в меню");
                    menu = in.nextLine();
                    if ("1".equals(menu)) {
                        stock.searchProduct();
                    }
                    if ("2".equals(menu)) {
                        break;
                    }
                }//while
            }

            if ("9".equals(menu)) {
                System.out.println("Вы покинули склад ");
                break;
            }
        }//while 1

    }//main

}//class close
