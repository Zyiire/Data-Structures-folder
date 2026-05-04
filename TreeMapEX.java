import java.util.Map;
import java.util.TreeMap;

//Student grades TreeMap example
public class TreeMapEX{
    public static void main(String[] args) {
        TreeMap<String, Double> studentGrades = new TreeMap<>();

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
}