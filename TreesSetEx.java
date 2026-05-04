import java.util.Comparator;
import java.util.TreeSet;

public class TreesSetEx {
    public static void main(String[] args) {
        
        TreeSet<String> stringSet = new TreeSet<>(new LengthComaparator());

        stringSet.add("Watermelon");
        stringSet.add("Banana");
        stringSet.add("Cherry");
        stringSet.add("Strawberry");
        stringSet.add("Tart");

        System.out.println("Sorted set of strings: ");

        for(String str : stringSet){
            System.out.println(str);
        }
    }

    static class LengthComaparator implements Comparator<String>{ 
        public int compare(String str1, String str2){
            int lengthDif = str1.length() - str2.length();

            if(lengthDif == 0){
                return str1.compareTo(str2);
            }
            return lengthDif;
        }
    }
}
