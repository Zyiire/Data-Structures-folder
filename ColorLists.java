import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ColorLists {
    public static void main (String[] args){

        List<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        
        ListIterator<String> itColors = colors.listIterator();
        System.out.println("\nForward Color List");
        while(itColors.hasNext()){
            System.out.println(itColors.next());
        }

        colors.add("Purple");
        
        // moves the iterator to the beginning
        itColors = colors.listIterator();

        System.out.println("\nAdded Purple Color List");
        while(itColors.hasNext()){
            System.out.println(itColors.next());
        }

        // moves the iterator to the beginning
        itColors = colors.listIterator();

        // Modifies the list to replace new colors with green and blue to cyan and navy
        System.out.println("\nModifying List");
        while(itColors.hasNext()){
            String color = itColors.next();
            if(color.equals("Green")){
                itColors.set("Cyan");
            } else if(color.equals("Blue")){
                itColors.set("Navy");
            }
         }

         System.out.println("\nModified List");
        for(String color : colors){
        System.out.println(color);
        }
    }
}
