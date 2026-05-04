import java.util.HashMap;
// Element counter
public class HashMapEX {
    
    public static HashMap<Integer, Integer> countElements(int[] arr){
        HashMap<Integer, Integer> elCount = new HashMap<>();

        //Count occurances of each elem

        for(int num : arr){
            if(elCount.containsKey(num)){
                //if elem is already present. increment count
                elCount.put(num, elCount.get(num) + 1);
            }else {
                //if elem is not present, add 1 with count
                elCount.put(num, 1);
            }
        }
        return elCount;
    }

    public static void main(String[] args) {
        int[] arr = {1 ,2, 3, 4, 5, 1, 2, 3, 4, 1};

        HashMap<Integer, Integer> elCount = countElements(arr);

        //print counts of each elem
        for(int key : elCount.keySet()){
            System.out.println(" Element " + key +" Occurs " + elCount.get(key) +" times ");
        }
    }
}
