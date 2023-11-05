package com.engeto.homework;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsList {
    private List<Plant> listOfPlants = new ArrayList<>();
    public PlantsList(){}
    public PlantsList(List<Plant> listOfPlants){
        this.listOfPlants.addAll(listOfPlants);
    }

    //Gettery a Settery

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
