class HurricaneExce extends Exception{
    public HurricaneExce(String message){
        super(message);
    }
}

class WeatherService{
    //message the may throw exception
    public void checkWeatherCon(boolean isHurricane)throws HurricaneExce{
    if(isHurricane){
        throw new HurricaneExce("Daner! Hurricane conditons deteced ");
    }
    else {
        System.out.println("Weather is clear, No hurricans deteced");
    }
}
}

public class HurricaneExceptionExample{
    public static void main(String[] args){
       WeatherService weatherService = new WeatherService();
       
       try{

        weatherService.checkWeatherCon(true);
       } catch(HurricaneExce e){
        System.err.println("HurricaneException caught: " + e.getMessage());
       }finally{
        System.out.println("This code always executes");
       }
    }
}