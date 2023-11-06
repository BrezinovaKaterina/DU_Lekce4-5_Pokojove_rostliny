import com.engeto.homework.Plant;
import com.engeto.homework.PlantException;
import com.engeto.homework.PlantsList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILENAME = "kvetiny.txt";
    public static void main(String[] args) {

            // Testovací kytka pro fungování metod
            System.out.println("Testovací kytka pro fungování metod");
            Plant plant1 = new Plant("Testovací kytka",7,LocalDate.of(2023,11,1));
            List<Plant> listOfPlants = new ArrayList<>();
            listOfPlants.add(plant1);

            System.out.println(listOfPlants);
    }
}