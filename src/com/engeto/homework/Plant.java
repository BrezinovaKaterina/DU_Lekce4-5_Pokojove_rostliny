package com.engeto.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate planted;  //datum zasazení
    private LocalDate watering; //datum poslední zálivky
    private int frequencyOfWatering; //frekvence zálivky

    public Plant() {
        this.name = name;
        this.notes = notes;
        this.frequencyOfWatering = frequencyOfWatering;
        this.planted = planted;
        this.watering = watering;

    }

    public Plant(String name, int frequencyOfWatering, LocalDate planted) {
        this.name = name;
        this.notes = "";
        this.frequencyOfWatering = frequencyOfWatering;
        this.planted = planted;
        this.watering = LocalDate.now();

    }

    public Plant(String name) {
        this.name = name;
        this.notes = "";
        this.frequencyOfWatering = 7;
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    // Ošetření zadávání datumu zálivky vs. datum zasazení)
    public void setWatering(LocalDate watering) throws PlantException {
        if(getWatering().compareTo(getPlanted()) <0) {
            throw new PlantException("Datum zálivky, které jste zadali: "+ getWatering() + "nesmí být starší než datum zasazení rostliny, tj.: "+getPlanted()+".");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    // Ošetření zadávání frekvence zálivky (0 nebo záporné číslo)
    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if(frequencyOfWatering <=0){
            throw new PlantException("Frekvence zálivky musí být větší než 0. Zadaná hodnota je "+frequencyOfWatering+".");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }



//    public String getWateringInfo(){
//        LocalDate getWateringInfo=
//        System.out.println(getName()+ ";" +getWatering()+ ";"+getFrequencyOfWatering());
//        return getWateringInfo();
//    }

    //Načtení souboru a ošetření chyb
    public static Plant loadFromFile (String filename) throws PlantException {
        Plant result = new Plant();
        int line = 1;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){
            while (scanner.hasNextLine()) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            throw new PlantException("Nepodařilo se nalézt soubor "+filename+": "+e.getLocalizedMessage());
        }
        return result;
    }


    @Override
    public int compareTo(Plant o) {
        return name.compareTo(getName());
    }
}
