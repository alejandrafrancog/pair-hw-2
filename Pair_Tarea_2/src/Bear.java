public class Bear extends AbstractAnimal {
    private static int numOfBears;
    public Bear(String specie,String breed,String name,int birthYear) {
        super(specie,breed,name,birthYear);
        numOfBears++;
    }
    public static int getNumOfBears(){
        return numOfBears;
    }
}
