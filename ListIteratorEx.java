import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx{
    public static void main(String[] args) {
        
        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        ListIterator<String> itName = names.listIterator();
        //iterate foward
        System.out.println("Forward Iterating: " );
        while(itName.hasNext()) {
            System.out.println(itName.next());
        }

        System.out.println("\nBackward Iterating: ");
         while(itName.hasPrevious()) {
            System.out.println(itName.previous());
        }

        //modify
         System.out.println("\nModifying Elements in the list: ");
         while(itName.hasNext()){
            String name = itName.next();
            if(name.equals("Bob")){
            itName.set("Bobby");
            }else if(name.equals("Charlie")){
            itName.remove();
            }
         }
         System.out.println("\nModified List");
        for(String name : names){
        System.out.println(name);
        }

    }
   
}

