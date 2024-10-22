package animals;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractAnimal implements Animal {
    private final String specie,breed,name;
    private final int birthYear;
    public AbstractAnimal(String specie, String breed, String name, int birthYear) {
        this.specie = specie;
        this.breed = breed;
        this.name = name;
        this.birthYear = birthYear;
    }
    public String getSpecie() {
        return specie;
    }
    public String getBreed() {
        return breed;
    }
    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }

    public int getAge(){
        int currentYear = 2024;
        return currentYear - birthYear;
    }
    public static ArrayList<AbstractAnimal> readAnimalsFromCSV(File animalsFile) {
        ArrayList<AbstractAnimal> animals = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(animalsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");

                String animal = data[0]; // saves which animal is it : e.g: Tiger, Lion, etc
                String breed = data[1];
                String name = data[2];
                int birthYear = Integer.parseInt(data[3]);

                try {
                    AbstractAnimal animal_object = instantiateAnimal(animal,breed,name,birthYear);
                    animals.add(animal_object);
                }catch (Exception e){
                    System.out.println("For some weird reason the animal couldn't be instantiated");
                }

            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return animals;
    }
    private static AbstractAnimal instantiateAnimal(String animal, String breed, String name, int birthYear) {
        switch (animal) {
            case "Tiger":
                return new Tiger(animal,breed,name,birthYear);
            case "Lion":
                return new Lion(animal,breed,name,birthYear);
            case "Hedgehog":
                return new Hedgehog(animal,breed,name,birthYear);
            case "Bear":
                return new Bear(animal,breed,name,birthYear);
            default:
                System.err.println("Unknown animal: " + animal);
                return null;
        }

    }

    @Override
    public String toString() {
        return "\nName: %s\n Specie: %s\n Breed: %s\n Birth Year: %s\n".formatted(name, specie, breed, birthYear);
    }
}
