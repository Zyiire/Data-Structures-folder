import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveNegatives{
    public static void main(String[] args) {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(new ArrayList<>(List.of(3, -1, 4))); // List.of(3, -1, 4)Cerates immutable list (Can't be changed)
        numbers.add(new ArrayList<>(List.of(5, -9, 0)));// ArrayList<>() makes the list changeable
        numbers.add(new ArrayList<>(List.of(7, 5, -8)));

        for(List<Integer> innerList : numbers){
            Iterator<Integer> inerIt = innerList.iterator();
            while(inerIt.hasNext()){
                int num = inerIt.next();
                if(num < 0){
                    inerIt.remove();
                }

            }
        }
            System.out.println("Modidifed List of lists: " + numbers);
    }
}