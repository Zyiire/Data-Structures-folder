import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorWithComparator{
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("Elephent");
        animals.add("Tiger");
        animals.add("Lion");
        animals.add("Zebra");

        animals.sort(Comparator.naturalOrder());

        Comparator<String> comparator = String::compareToIgnoreCase;

        animals.sort(comparator);

        ListIterator<String> itAni = animals.listIterator();

        String newAnimal = "Monkey";
        while(itAni.hasNext()){
            String currentAni = itAni.next();
            if(comparator.compare(newAnimal, currentAni) < 0){
                itAni.previous();
                itAni.add(newAnimal);
                break;
            }
        }

        System.out.println("\nList After Inserting New Animal: " + newAnimal + " :");
        for(String animal : animals){
            System.out.println(animal);
        }
    }
}