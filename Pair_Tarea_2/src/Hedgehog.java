public class Hedgehog extends AbstractAnimal {
    private static int numOfHedgehogs = 0;
    public Hedgehog(String specie,String breed,String name,int birthYear) {
        super(specie,breed,name,birthYear);
        numOfHedgehogs++;
    }

    public static int getNumOfHedgehogs() {
        return numOfHedgehogs;
    }
}
