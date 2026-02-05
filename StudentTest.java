import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    private String name;
    private int grade;
    
    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }

    public String toString(){
        return "Student ( " + name + " grade " + grade + " ) ";
    }
}

public class StudentTest{
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 90));
        students.add(new Student("Bob", 85));
        students.add(new Student("Charlie", 95));
        students.add(new Student("Dave", 88));

        System.out.println("Student in the List before sorting: " + students);
        Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGrade);
        Collections.sort(students, gradeComparator);

        System.out.println("Student in the List after sorting: " + students);
    }
}
