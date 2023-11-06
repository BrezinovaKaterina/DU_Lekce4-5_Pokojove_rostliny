package com.engeto.homework;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate planted;  //datum zasazení
    private LocalDate watering; //datum poslední zálivky
    private int frequencyOfWatering; //frekvence zálivky

    public Plant(String name, String notes, int frequencyOfWatering, LocalDate planted, LocalDate watering) {
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


    //Načtení souboru (chybný soubor)
    public static Plant loadFromFile (String filename) throws PlantException {
        Plant result = new Plant(filename);
        int lineNumber = 1;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){  // otevření souboru
            while (scanner.hasNextLine()) {  // načtení řádku dokud je k dispozici
               String line = scanner.nextLine();
               parsePlant(line, result, lineNumber);
               lineNumber++;
            }
        } catch (FileNotFoundException e){
            throw new PlantException("Nepodařilo se nalézt soubor "+filename+": "+e.getLocalizedMessage());
        }
        return result.newPlant();
    }

    private static Plant parsePlant(String line, Plant plant, int LineNumber) throws PlantException {
        String[] blocks = line.split("\t");
        int numberOfBlocks = blocks.length;
        if (numberOfBlocks !=5) {
            throw new PlantException(
                    "Nesprávný počet položek na řádku č: "+line+"! Počet položek v souboru: "+
                            numberOfBlocks+".");
        }
        String name = blocks[0].trim();
        String notes = blocks[1].trim();
        int frequencyOfWatering;
        try {
            frequencyOfWatering = Integer.parseInt(blocks[2].trim());
        } catch (NumberFormatException e) {
            throw new PlantException("Chybně zadané číslo "+blocks[2]+"na řádku číslo: "+line+"!");
        }
        LocalDate planted;
        try {
            planted = LocalDate.parse(blocks[3].trim());
        } catch (NumberFormatException e){
            throw new PlantException("Chybný formát datumu: "+blocks[3]+"na řádku číslo: "+line+"!");
        }
        LocalDate watering;
        try {
            watering = LocalDate.parse(blocks[4].trim());
        } catch (NumberFormatException e){
            throw new PlantException("Chybný formát datumu poslední zálivky: "+blocks[4]+"na řádku číslo: "+line+"!");
        }
        Plant newPlant = new Plant(name, notes, frequencyOfWatering,planted, watering);
        return newPlant;
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
