import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportTxt {

    public static void exportZooTxt(Zoo zoo, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println("Zoo: " + zoo.getName());
            printWriter.println("----------------------");

            for (ZooArea zooArea : zoo.getAreas()) {
                printWriter.println("Zoo Area: " + zooArea.getName());
                printWriter.println("Capacity: " + zooArea.getMaxCapacity());
                printWriter.println("Animals:");

                for (AbstractAnimal animal : zooArea.getAnimals()) {
                    printWriter.println("    Animal Name: " + animal.getName());
                    printWriter.println("    Species: " + animal.getSpecie());
                    printWriter.println("    Breed: " + animal.getBreed());
                    printWriter.println("    Age: " + animal.getAge());
                    printWriter.println("    ----------------------");
                }
            }

            System.out.println("Datos del zoo exportados correctamente a " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
