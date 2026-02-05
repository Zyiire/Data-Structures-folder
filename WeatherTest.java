public class WeatherTest{

    public static void main(String[] args){
        Weather today = new Weather("Edison", 15);
        Weather tomorrow = new Weather("East Brunswick", 22);

        WeatherHolder<Weather> holder= new WeatherHolder<>(today);

        Weather warmer = holder.warmerOf(tomorrow);
        System.out.println("Warmer day:" + warmer);

        //use private helper method
        Weather warmest= warmerOf(today, tomorrow);
        System.out.println("Warmer Overall:" + warmest);
    }
        //private helper generic hmethod
        private static <T extends Comparable<T>> T warmerOf(T a, T b){
            return (a.compareTo(b) > 0) ? a : b;
        }


    }

class Weather implements Comparable<Weather>{
        private String city;
        private int temperature;

    public Weather(String city, int temperature){
        this.city = city;
        this.temperature = temperature;
    }

    // override
    @Override
    public int compareTo(Weather other) {
        return Integer.compare(this.temperature, other.temperature);
    }

    //override
    @Override
    public String toString(){
        return city + ": " + temperature + " degrees ";
    }
}

    // generic class
class WeatherHolder<T extends Comparable<T>>{

    private T data;

    public WeatherHolder(T data){
            this.data = data;
    }

    public T warmerOf(T other){
           return (data.compareTo(other) > 0)? data : other;
    }
}
