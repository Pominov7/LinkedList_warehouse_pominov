package com.company.warehouse;

import java.util.Comparator;

//Класс- компаратор для "Накладной"
public class ComparatorConsignmentNote implements Comparator<ConsignmentNote> {

    //метод сравнения накладных по полю "От кого"
    @Override
    public int compare(ConsignmentNote o1, ConsignmentNote o2) {

        String fromWhom = o1.getFromWhom().toUpperCase();
        String fromWhom2 = o2.getFromWhom().toUpperCase();

        // в порядке возрастания
        return fromWhom.compareTo(fromWhom2);

        //в порядке убывания
        // вернуть fromWhom2.compareTo (fromWhom);
    }
}
