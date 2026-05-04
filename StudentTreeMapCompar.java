import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//Student grades TreeMap example
public class StudentTreeMapCompar{
    public static void main(String[] args) {
        TreeMap<String, Double> studentGrades = new TreeMap<>(new NameLengthComparator());

        //add Data
        studentGrades.put("Tom", 45.7);
        studentGrades.put("Alice", 85.0);
        studentGrades.put("Bob", 92.5);
        studentGrades.put("Charlie", 73.3);
        studentGrades.put("David", 88.9);
        studentGrades.put("Eve", 95.6);

        //display the sorted list of names and grades
        for(Map.Entry<String, Double> entry : studentGrades.entrySet()){
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
//custom comparator to sort by the names length
    static class NameLengthComparator implements Comparator<String>{
        public int compare(String nam1, String nam2){
            //compare the length first
            int result = Integer.compare(nam1.length(), nam2.length());
            if(result == 0){
                return nam1.compareTo(nam2);
            }
            return result;
        }
    }
}
