import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CityArrayExample {
    public static void main(String[] args) {
        ArrayList<String>cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Paris");
        cities.add("London");

        System.out.println("These are the cities in the ArrayList: " + cities);

        String firstCity = findFirstCity(cities);
        System.out.println("This is the first city in dictionary order: " + firstCity);

        System.out.println("Iterate through the ArrayList using a for-each ");
        for(String city : cities){
            System.out.println(city);
        }

        //check if the list has a city starting with an L
        for(String city : cities){
            if(city.startsWith("L")){
                System.out.println(city);
            }
        }
    }
    private static String findFirstCity(ArrayList<String> cities){
        if(cities.isEmpty()){
            return null;
        }
        Comparator<String> cityComparator = Comparator.naturalOrder();
        //sort the list
        Collections.sort(cities, cityComparator);

        return cities.get(0);
        }
    }
    

