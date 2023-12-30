package com.engeto.homework;

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

    //Načtení souboru (chybný soubor)
    public static PlantsList loadFromFile (String filename) throws PlantException {
        PlantsList result = new PlantsList();
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
        return result;
    }

    private static void parsePlant(String line, PlantsList plantsList, int LineNumber) throws PlantException {
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
        Plant newPlant = new Plant();
        plantsList.addPlant(newPlant);
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

    public List<Plant> getListOfPlants(){
        return new ArrayList<>(listOfPlants);
    }
    public void addAllPlants(List<Plant> ListOfNewPlants){
        this.listOfPlants.addAll(ListOfNewPlants);
    }
}
