public abstract class AbstractAnimal implements Animal {
    private String specie,breed,name;
    private int birthYear;
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
    public void setSpecie(String specie) {
        this.specie = specie;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
