package com.engeto.homework;

import java.time.LocalDate;
import java.util.Comparator;

public class PlantsComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant o1, Plant o2) {
        return o1.getWatering().compareTo(o2.getPlanted());
    }
}
