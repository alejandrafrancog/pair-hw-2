import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ZooArea area = new ZooArea(5,"The Cool Area");
        ZooArea area_2 = new ZooArea(3,"Amazing Area");
        ZooArea area_3 = new ZooArea(6,"Random Area");
        ZooArea area_4 = new ZooArea(10,"The Great Area");

        // Adding areas to the ArrayList
        ArrayList<ZooArea> zooAreas = new ArrayList<>();
        zooAreas.add(area);
        zooAreas.add(area_2);
        zooAreas.add(area_3);
        zooAreas.add(area_4);

        Hedgehog hedgehog_1 = new Hedgehog("Desert","European","Sonic",1845);
        Hedgehog hedgehog_2 = new Hedgehog("Four-toed","European","Sonic",1745);
        Hedgehog hedgehog_3 = new Hedgehog("Four-toed","European","Sonic",1745);
        Hedgehog hedgehog_4 = new Hedgehog("Indian","European","Sonic",2024);

        Tiger tiger_1 = new Tiger("Siberian Tiger","Some breed","Pedro",2021);
        Tiger tiger_2 = new Tiger("Siberian Tiger","Some breed","Julio",1800);
        Tiger tiger_3 = new Tiger("Siberian Tiger","Some breed","Ernesto",2023);

        Bear bear_1 = new Bear("Sun","Some breed","Gus",1950);
        Bear bear_2 = new Bear("Panda","Some breed","Lucio",1950);
        Bear bear_3 = new Bear("Spectacled","Some breed","Mariano",1950);
        Bear bear_4 = new Bear("Panda","Some breed","Peter",2018);

        Lion lion_1 = new Lion("A","Some breed","Gus",1950);
        Lion lion_2 = new Lion("B","Some breed","Lucio",1950);
        Lion lion_3 = new Lion("C","Some breed","Carlos",1950);
        Lion lion_4 = new Lion("D","Some breed","Lolo",1537);
        Lion lion_5 = new Lion("E","Some breed","Lilo",2021);

        area.addAnimal(hedgehog_1);
        area.addAnimal(bear_1);
        area.addAnimal(hedgehog_2);
        area.addAnimal(bear_2);
        area.addAnimal(hedgehog_3);
        area.addAnimal(bear_3);

        area_2.addAnimal(tiger_1);
        area_2.addAnimal(tiger_2);
        area_2.addAnimal(tiger_3);

        area_3.addAnimal(lion_2);
        area_3.addAnimal(lion_3);
        area_3.addAnimal(lion_1);
        area_3.addAnimal(lion_4);

        area_4.addAnimal(lion_5);
        area_4.addAnimal(bear_4);
        area_4.addAnimal(bear_3);
        area_4.addAnimal(hedgehog_4);

        Zoo zoo = new Zoo("ZooperZoo",zooAreas);
        
        zoo.getAreas().stream()
                .filter(zooArea -> zooArea.getAnimals().size() > 2) // Filter zooAreas with more than 2 animals
                .forEach(zooArea -> {
                    System.out.println("Zoo Area: " + zooArea.getName());

                    zooArea.getAnimals().forEach(animal -> {
                        System.out.println("Animal Name: " + animal.getName());
                        System.out.println("Species: " + animal.getSpecie());
                        System.out.println("Breed: " + animal.getBreed());
                        System.out.println("Age: " + animal.getAge());
                        System.out.println("----------------------");
                    });
                });


        ExportTxt.exportZooTxt(zoo, "zoo_report.txt");

    }
}
