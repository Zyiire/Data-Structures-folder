import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Birds{
    private String name;
    private String species;

    public Birds(String name, String species){
        this.name = name;
        this.species = species;
    }

    public String getName(){
        return name;
    }

    public String getSpecies(){
        return species;
    }

    public String toString(){
        return name + "( " + species + ")" ;
    }

}

public class BirdsExample{
    public static void main (String[] args){
        //list of Birds
        ArrayList<Birds>birds = new ArrayList<>();
        birds.add(new Birds("Robin", "SongBird"));
        birds.add(new Birds("Eagle", "Raptor"));
        birds.add(new Birds("Parrot", "Parrakete"));
        birds.add(new Birds("Ostrich", "Flightless"));

        System.out.println("Birds in ArrayList Before the sort: " + birds);

        Comparator<Birds> nameComparator = Comparator.comparing(Birds::getName);
        Collections.sort(birds, nameComparator);

        System.out.println("Birds in the ArrayList after the sort: " + birds);


    }
}