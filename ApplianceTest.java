import java.util.ArrayList;
import java.util.Collections;  // Class not Interface
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Appliance {
    private String name;
    private double price;

    public Appliance(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    public String toString(){
        return "Appliance [name = " + name + ", price = " + price + " ]";
    }

}

public class ApplianceTest{
    public static void main(String [] args){
        List<Appliance> apps = new ArrayList<>();

        apps.add((new Appliance("Refidgerator", 799.99)));
        apps.add((new Appliance("Air Frier", 487.99)));
        apps.add((new Appliance("Dish Washer", 578.99)));
        apps.add((new Appliance("Microwave", 250.99)));

        Comparator<Appliance> priceComparator = Comparator.comparing(Appliance::getPrice);
        Collections.sort(apps, priceComparator);

        System.out.println("Sorted Appliances by price (Acending Order:)");

        //use iteratior to treverse and remove appliances price < 500.00

        Iterator<Appliance> iterApp = apps.iterator();
        while(iterApp.hasNext()){
            Appliance appliance = iterApp.next();

            if(appliance.getPrice() < 500){
                System.out.println("Removing: " + apps);
                iterApp.remove();
            }
        }

        System.out.println("\nRemaining Appliances: ");
        for(Appliance appliance : apps){ 
        System.out.println(appliance);
        }
    }
}