import java.util.ArrayList;
import java.util.Scanner;

public class FunWithLists {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a list type: String, Integer, or Double");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("String")) {
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                list.add("item" + i);
            }

            System.out.println("String list created with " + list.size() + " elements.");

        } else if (choice.equalsIgnoreCase("Integer")) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                list.add(i);
            }

            System.out.println("Integer list created with " + list.size() + " elements.");

        } else if (choice.equalsIgnoreCase("Double")) {
            ArrayList<Double> list = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                list.add(i * 1.0);
            }

            System.out.println("Double list created with " + list.size() + " elements.");

        } else {
            System.out.println("Invalid list type.");
        }

        input.close();
    }
}