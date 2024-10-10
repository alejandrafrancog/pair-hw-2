import java.util.ArrayList;

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

    public void addAnimal(AbstractAnimal animal) {
        if( animals.size() == maxCapacity) {
            System.out.printf("Sorry, '%s' has reached its maximum capacity\n", name);
        }else{
            animals.add(animal);
            //System.out.println("Successfully added "+animal.getName()+"!");
        }
    }
}
