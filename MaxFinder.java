import java.util.Random;

public class MaxFinder {

    public static <T extends Comparable> T findMax ( T[] array){
        if(array == null || array.length == 0){
            return null;
        }
    

    T max = array[0];
    for(T element : array){
        if(element != null && element.compareTo(max) > 0){
            max = element;
        }
    }
    return max;
}

public static void main(String[] args){
    Random random = new Random();

    Integer[] intArray = {random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100) };

    Double[] doubleArray = {random.nextDouble()*100, random.nextDouble()*100, random.nextDouble()*100, random.nextDouble()*100, random.nextDouble()*100};

    String[] stringArray = {"apple", "banana", "cherry", "date"};

    Character[] charArray = {'c', 'A', 'B', 'E', 'D'};

    Integer maxInt = findMax(intArray);

    Double maxDouble = findMax(doubleArray);

    String maxString = findMax(stringArray);

    Character maxChar = findMax(charArray);


    System.out.println("Maximum in intArray " + maxInt);
    System.out.println("Maximum in doubleArray " + maxDouble);
    System.out.println("Maximum in stringArray " + maxString);
    System.out.println("Maximum in charArray " + maxChar);

}

}
    


