import java.util.Stack;

public class SearchClass {
public static void main(String[] args) {

    
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nPositon of 20: "+ stack.search(20));
        System.out.println("\nPostion of 10: "+ stack.search(10));
        System.out.println("\nPostion of 40: "+ stack.search(40));

    }
}
