// iterator

import java.util.ArrayList;
import java.util.Iterator;

class Employee{
    private int id;
    private String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId()
{
    return id;
}
    public String getName(){
        return name;
    }

    public String toString(){
        return "Employee [ " + id + ", Name: " + name + " ]";
    }

}

public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "John Doe"));
        employeeList.add(new Employee(2, "James Bond"));
        employeeList.add(new Employee(3, "Dinah Mont"));
        employeeList.add(new Employee(4, "Lois Griffen"));

        Iterator<Employee> iterE = employeeList.iterator();     // Iterator to iterate through the Employee List
        System.out.println("This is the Employee List: ");
        while(iterE.hasNext()){
            Employee employee = iterE.next();
            System.out.println(employee);
        }
    }
}
