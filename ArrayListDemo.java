import java.util.ArrayList;
import java.util.Collections; //class = Collections; Collection = Interface

public class ArrayListDemo{
    public static void main(String [] args){
        ArrayList<String> roster = new ArrayList<>();

        roster.add(" Alice ");
        roster.add(" Bob ");
        roster.add("Charlie");
        roster.add("Dave");
        roster.add("Eva");

        roster.add(2, "Frank");

        roster.set(0, "Alicia");

        roster.remove(3);

        roster.remove("Eva");

        //Query
        boolean hasBob = roster.contains("Bob");
        int indexCharlie  = roster.indexOf("Charlie");
        int lastIndexBob = roster.lastIndexOf("Bob");
        int size = roster.size();
        boolean empty = roster.isEmpty();

        // sort
        Collections.sort(roster);

        System.out.println("Roster " + roster);
        System.out.println("Contains Bob? " + hasBob);
        System.out.println("The Index of Charlie? " + indexCharlie);
        System.out.println("Last index Of Bob: " + lastIndexBob);
        System.out.println("Size Is: " + size);
        System.out.println("Is Empty: " + empty);

        roster.clear();
        System.out.println("Roster after the clear " + roster);
        System.out.println("Size after the clear: " + roster.size());


    }
}
