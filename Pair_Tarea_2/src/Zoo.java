import java.util.ArrayList;
public class Zoo {
    private String name;
    private ArrayList<ZooArea> areas;
    public Zoo(String name, ArrayList<ZooArea> areas) {
        this.name = name;
        this.areas = areas;
    }
    public String getName() {
        return name;
    }
    public ArrayList<ZooArea> getAreas() {
        return areas;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAreas(ArrayList<ZooArea> areas) {
        this.areas = areas;
    }
}
