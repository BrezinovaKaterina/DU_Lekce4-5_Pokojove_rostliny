package com.engeto.homework;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlants {
    private List<Plant> listOfPlants = new ArrayList<>();
    public ListOfPlants(){}

    public void addPlant(Plant newPlant){
        listOfPlants.add(newPlant);
    }

    public Plant getPlant(int index){
        return listOfPlants.get(index);
    }

    public void removePlant(int index){
        listOfPlants.remove(index);
    }

    public void addAllPlants(List<Plant> ListOfNewPlants){
        this.listOfPlants = new ArrayList<>(ListOfNewPlants);
    }
}
