import java.util.Stack;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return str.equals(reversed.toString());
    }

    public static void main(String[] args) {
        String test1 = "bob";
        String test2 = "hello";

        System.out.println("\"" + test1 + "\" is palindrome: " + isPalindrome(test1));
        System.out.println("\"" + test2 + "\" is palindrome: " + isPalindrome(test2));
    }
}
