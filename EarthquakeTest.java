public class EarthquakeTest {
    public static void main(String[] args){
        Earthquake quake1 = new Earthquake("California", 5.2);
        Earthquake quake2 = new Earthquake("Alaska", 6.7);

    // generic class
    QuakeHolder<Earthquake> holder = new QuakeHolder<>(quake1);

    Earthquake stronger = holder.strongerOf(quake1);
    System.out.println("Stronger quake: " + stronger);

    //private helper method
    Earthquake strongest = strongerOf(quake1, quake2);
    System.out.println("Stronger Overall: " + strongest);
    }

//private generic helper
private static <T extends Comparable<T>> T strongerOf(T a, T b){
    return (a.compareTo(b) > 0)? a : b;
    }
}

class Earthquake implements Comparable<Earthquake>{
    private String location;
    private double magnitude;

    public Earthquake(String location, double magnitude){
        this.location = location;
        this.magnitude = magnitude;
    }
    public double magnitude(){
        return magnitude;
    }

    //override
    public int compareTo(Earthquake other){
        //by magnitude
        return Double.compare(this.magnitude, other.magnitude);
    }

    public String toString(){
        return location + ": " + magnitude + "Richter";
    }
}

class QuakeHolder<T extends Comparable<T>>{
    private T data;

    public QuakeHolder(T data){
        this.data = data;
    }

    public T strongerOf(T other){
        return (data.compareTo(other) > 0)? data : other;
    }
}
