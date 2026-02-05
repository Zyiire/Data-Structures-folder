import java.util.ArrayList;
import java.util.Arrays;

// ADT inter - defines what operations can be performed
 interface ThemeParkRides {
    void addRide(String rideName, int thrillLevel);
    void showNextRide();
    void sortRideByThrill();
}

//Ride class(data element) - reps. a single ride in park
//stored in the imp. class
class Ride{
    String name; 
    int thrillLevel; // rating from 0 - 10

    public Ride(String name, int thrillLevel){
        this.name = name;
        this.thrillLevel = thrillLevel;
    }

    public String toString(){
        return name + "Thirll: " + thrillLevel;
    }
}

/*Implementation class: ThemePark
 D.S. here is ArrayList<Ride> rides stores all rides
 data element: Ride
 */
class ThemePark implements ThemeParkRides{
    ArrayList<Ride>rides = new ArrayList<>(); // internal sorage 
    int currentIndex = 0; //tracks next ride

    public void addRide( String rideName, int thrillLevel){
        if(rideName != null && thrillLevel >= 0){
            rides.add(new Ride(rideName, thrillLevel));
            System.out.println(rideName + " added with thrill level " + thrillLevel);
        }else {
            System.out.println("Invalid Ride Information");
        }
    }

    public void showNextRide(){
        if(rides.isEmpty()){
            System.out.println(" Ride Currently Not In Service ");
            return;
        }
            System.out.println(" Next Ride: " + rides.get(currentIndex));

            currentIndex++;
            if(currentIndex >= rides.size()){  //loop back to start
                currentIndex = 0;
            }
    }

    // sort the ride by thrill level
    public void sortRidesByThrill(){
        if(rides.isEmpty()) return;

        Ride[] rideArray = rides.toArray(new Ride[0]);

        Arrays.sort(rideArray, ThemePark:: compareByThrill);

        //put assorted rides back into list
        rides.clear();
        rides.addAll(Arrays.asList(rideArray)); // asList converts Array to list
        System.out.println("Rides Sorted By Thrill Level ");
        currentIndex = 0; // reset index after sort
    }

    //compare in descending order
private static int compareByThrill(Ride r1, Ride r2){
    return r2.thrillLevel - r1.thrillLevel; //higher thrill first
}
}

public class ThemeParkTest{
    public static void main(String[] args) {
        // ADT ref
        ThemeParkRides park = new ThemePark();

        park.addRide( " Darkknight ", 10);
        park.addRide( " SuperMan ", 8);
        park.addRide( " Green Lantern ", 5);
        park.addRide( " El Toro ", 9);
        park.addRide( " Nitro ", 10);

        // show rides in order
        System.out.println("\n Next Rides In Order ");
        park.showNextRide();
        park.showNextRide();

        System.out.println("\n Sotred Rides By Thrill Level ");
        park.sortRideByThrill();

        //after sorting
        System.out.println("\n The Next Rides After Sorting");
            park.showNextRide();
            park.showNextRide();
            park.showNextRide();
            park.showNextRide();
            park.showNextRide();
    }
}