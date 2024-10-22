package zoo;

import animals.AbstractAnimal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Random;
public class ZooArea {
    private int maxCapacity;
    private String name;
    private ArrayList<AbstractAnimal> animals = new ArrayList<>();

    public ZooArea(int maxCapacity, String name) {
        this.maxCapacity = maxCapacity;
        this.name = name;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public String getName() {
        return name;
    }
    public ArrayList<AbstractAnimal> getAnimals() {
        return animals;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addAnimal(AbstractAnimal animal) {
        boolean wasAdded = true;
        if( animals.size() == maxCapacity) {
            System.out.printf("Sorry, '%s' has reached its maximum capacity\n", name);
            return !wasAdded;
        }else{
            animals.add(animal);
            return wasAdded;
        }
    }

    public static ArrayList<ZooArea> readAreasFromCSV(File areasFile) {
        ArrayList<ZooArea> zooAreas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(areasFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int maxCapacity = Integer.parseInt(data[1]);
                String name = data[0];

                ZooArea area = new ZooArea(maxCapacity, name);
                zooAreas.add(area);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return zooAreas;
    }
    public static void assignAnimalsToRandomAreas(ArrayList<AbstractAnimal> animals, ArrayList<ZooArea> areas){
        for(AbstractAnimal animal : animals) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(areas.size());
            try {
                while( ! areas.get(randomIndex).addAnimal(animal) ){
                    randomIndex = rand.nextInt(areas.size());
                }

            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static void printAnimalsPerArea(ArrayList<ZooArea> areas){
        for(ZooArea area : areas) {
            System.out.printf("%s (%d / %d)\n", area.getName(),area.getAnimals().size(),area.getMaxCapacity());
            System.out.println(area.getAnimals());
        }

    }

    @Override
    public String toString() {
        return "\nName: %s\nMaximum Capacity: %d".formatted(name,maxCapacity);
    }
}
