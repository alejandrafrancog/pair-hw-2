package zoo;

import animals.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<ZooArea> zooAreas = new ArrayList<>();
        ArrayList<AbstractAnimal> animals = new ArrayList<>();
        File areasFile  = new File("/home/ale01000110/Documents/qe_mentormate/pair-hw-2/Pair_Tarea_2/src/files/areas.csv");
        File animalsFile = new File ("/home/ale01000110/Documents/qe_mentormate/pair-hw-2/Pair_Tarea_2/src/files/animals.csv");

        zooAreas = ZooArea.readAreasFromCSV(areasFile);
        animals = AbstractAnimal.readAnimalsFromCSV(animalsFile);

        ZooArea.assignAnimalsToRandomAreas(animals,zooAreas);
        ZooArea.printAnimalsPerArea(zooAreas);

        Zoo zoo = new Zoo("ZooperZoo",zooAreas);

        zoo.getAreas().stream()
                .filter(zooArea -> zooArea.getAnimals().size() > 2) // Filter zooAreas with more than 2 animals
                .forEach(zooArea -> {
                    System.out.println("zoo.Zoo Area: " + zooArea.getName());

                    zooArea.getAnimals().forEach(animal -> {
                        System.out.println("Name: " + animal.getName());
                        System.out.println("Species: " + animal.getSpecie());
                        System.out.println("Breed: " + animal.getBreed());
                        System.out.println("Age: " + animal.getAge());
                        System.out.println("----------------------");
                    });
                });

        //ExportTxt.exportZooTxt(zoo, "zoo_report.txt");

    }
}