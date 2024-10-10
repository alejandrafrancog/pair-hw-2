public class Tiger extends AbstractAnimal {
    private static int numOfTigers = 0;
    public Tiger(String specie,String breed,String name,int birthYear) {
        super(specie,breed,name,birthYear);
        numOfTigers++;
    }
    public static int getNumOfTigers(){
        return numOfTigers;
    }

}
