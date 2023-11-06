import com.engeto.homework.Plant;
import com.engeto.homework.PlantException;
import com.engeto.homework.PlantsList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILENAME = "kvetiny.txt";
    public static void main(String[] args) {



        Plant plantsFromFile;
        try {
            plantsFromFile = Plant.loadFromFile(FILENAME);
            System.out.println(plantsFromFile.getName());
        } catch (PlantException e) {
            System.err.println("Chyba při čtení souboru: "+e.getLocalizedMessage());
        }
    }
}