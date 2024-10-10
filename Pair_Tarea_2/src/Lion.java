public class Lion extends AbstractAnimal{
    private static int numOfLions = 0;
    public Lion(String specie,String breed,String name,int birthYear) {
        super(specie,breed,name,birthYear);
        numOfLions++;
    }
    public static int getNumOfLions() {
        return numOfLions;
    }
}
