package com.engeto.homework;

import java.io.*;
import java.time.LocalDate;

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

    public LocalDate getWateringInfo(){
        System.out.print(getName()+";"+getWatering()+";"+getWatering().plusDays(getFrequencyOfWatering()));
        return (LocalDate) getWateringInfo();
    }

      private Plant newPlant() {
          return newPlant();
      }


    // Ošetření zadávání datumu zálivky vs. datum zasazení)
    public void setWatering(LocalDate watering) throws PlantException {
        if(getWatering().compareTo(getPlanted()) <0) {
            throw new PlantException("Datum zálivky, které jste zadali: "+ getWatering() +
                    "nesmí být starší než datum zasazení rostliny, tj.: "+getPlanted()+".");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    // Ošetření zadávání frekvence zálivky (0 nebo záporné číslo)
    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if(frequencyOfWatering <=0){
            throw new PlantException("Frekvence zálivky musí být větší než 1 den. Zadaná hodnota je "
                    +frequencyOfWatering+".");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }


    //Uložení aktualizovaného seznamu květin
    public static void saveToFile (String filename, Plant plant) throws PlantException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
        } catch (IOException e) {
            throw new PlantException("Chyba při zápisu do souboru: "+filename+e.getLocalizedMessage());
        }
    }

    @Override
    public int compareTo(Plant o) {
        return name.compareTo(getName());
    }

    @Override
    public String toString() {
        return "Plant:" + name +
                ", notes:" + notes +
                ", zasazena dne: " + planted +
                ", datum poslední zálivky: " + watering +
                ", frekvence zálivky: " + frequencyOfWatering +" dní.";
    }
}
