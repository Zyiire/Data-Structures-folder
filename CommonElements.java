/* This is to learn Iterators while using nested loops. */

import java.util.ArrayList;
import java.util.Iterator;

public class CommonElements {
    public static void main(String[] args) {
        
        ArrayList<String> aList = new ArrayList<>();
        ArrayList<String> bList = new ArrayList<>();

        aList.add("USA");
        aList.add("Canada");
        aList.add("Mexico");
        aList.add("France");

        bList.add("Canada");
        bList.add("Mexico");
        bList.add("Germany");
        bList.add("Italy");

        System.out.println("Common elements using Iterators:\n");
        Iterator<String> iterA = aList.iterator();
        while(iterA.hasNext()){
            String elementA = iterA.next();
            
         Iterator<String> iterB = bList.iterator();
            boolean found = false;
            while(iterB.hasNext()){
                if(elementA.equals(iterB.next())){
                    found = true;
                }
        }
        if(found){
            System.out.println(elementA);
        }
    }
    
    }
}
