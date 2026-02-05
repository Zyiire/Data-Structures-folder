import java.util.Arrays;
import java.util.Comparator; 

abstract class Plumber {
    protected String name; 
    protected String companyName;

    public static int numPlumbers;
    public static String[] companyNames;

    public Plumber(String name, String companyName){
        this.name = name;
        this.companyName = companyName;
        numPlumbers++;
    }

    public abstract void fixLeak();

    public static void sortPlumbers(Plumber[] plumbers){
        Arrays.sort(plumbers, Comparator.comparing(Plumber:: getCompanyName));
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getname(){
        return name;
    }

    public String toString(){
        return "Name " + name + "Company: " + companyName;
    }
}

class ResPlumber extends Plumber implements PerformService{
    public ResPlumber(String name, String companyName){
        super(name, companyName);
    }

    public void fixLeak(){
        System.out.println("Residential plumber fixing a leak");
    }

    public void performService(){
        System.out.println("residential plumber performing a service");
    }
}

class CommercialPlumber extends Plumber implements PerformService{
    public CommercialPlumber(String name, String companyName){
        super(name, companyName);
    }

    public void fixLeak(){
        System.out.println("Commercial plumber fixing a leak");
    }

    public void performService(){
        System.out.println("commercial plumber performing a service");
    }
}

interface PerformService{
    void performService();
}

public class PlumberTest{

    public static void main(String [] args){
        Plumber[] plumbers = new Plumber[3];

        plumbers[0] = new ResPlumber("John Doe ", "ABC Plumbing ");
        plumbers[1] = new CommercialPlumber("John Smith ", "XYZ Plumbing " );
        plumbers[2] = new ResPlumber("Mike Wiz ", "DEF Plumbing ");

        System.out.println("Plumbers before sorting");
        for(Plumber plumber : plumbers){
            System.out.println(plumber);
        }
        System.out.println("\n Sorting plumbers by company name");
        Plumber.sortPlumbers(plumbers);

         for(Plumber plumber : plumbers){
            System.out.println(plumber);
        }
    }
}

    