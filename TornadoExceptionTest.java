class TornadoException extends Exception{
    public TornadoException(){
        super("Tornado: Take cover immediatly!");
    }
    public TornadoException(int m){
        super("Tornado: " + m + " miles away, and approaching");
    }
}

public class TornadoExceptionTest {
    public static void main(String[] args) {
        int distance = 8;

        try{
            if(distance < 5){
        throw new TornadoException();
    }
    else {
        throw new TornadoException(distance);
    }

        } catch(TornadoException e) {
            System.out.println(e.getMessage());
        }

    }
}
