import com.engeto.homework.Plant;
import com.engeto.homework.PlantException;
import com.engeto.homework.PlantsList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.engeto.homework.PlantsList.loadFromFile;

public class Main {
    public static void main(String[] args) {

        PlantsList plantsFromFile;
        try {
            plantsFromFile = PlantsList.loadFromFile("kvetiny.txt");
            System.out.println(plantsFromFile.getListOfPlants());
        } catch (PlantException e) {
            System.err.println("Chyba při čtení souboru: "+e.getLocalizedMessage());
        }
    }
}