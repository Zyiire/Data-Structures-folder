import java.util.Scanner;

public class PalindromeDemoLLStack {

    public static void main(String[] args) {
        LinkedStackDS<Character> stack = new LinkedStackDS<>();
        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.print("Input a String for Palindrome Test: ");
            input = sc.nextLine();

            String testStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            stack = new LinkedStackDS<>();

            for (int i = 0; i < testStr.length(); i++) {
                stack.push(testStr.charAt(i));
            }

            String reversed = "";

            try {
                while (!stack.isEmptyStack()) {
                    reversed += stack.peek();
                    stack.pop();
                }
            } catch (StackUnderflowException e) {
                System.out.println(e.getMessage());
            }

            if (testStr.equals(reversed)) {
                System.out.println(input + " is a palindrome");
            } else {
                System.out.println(input + " is NOT a palindrome");
            }

            System.out.print("Continue? (y/n): ");
            input = sc.nextLine();

        } while (input.equalsIgnoreCase("y"));
    }
}

interface LinkedStackADT<T> {
    boolean isEmptyStack();
    void push(T item);
    T peek() throws StackUnderflowException;
    void pop() throws StackUnderflowException;
}

class StackException extends Exception {
    public StackException(String msg) {
        super(msg);
    }
}

class StackUnderflowException extends StackException {
    public StackUnderflowException(String msg) {
        super(msg);
    }
}

class StackOverflowException extends StackException {
    public StackOverflowException(String msg) {
        super(msg);
    }
}

class LinkedStackDS<T> implements LinkedStackADT<T> {

    private StackNode<T> top;

    public LinkedStackDS() {
        top = null;
    }

    public LinkedStackDS(T value) {
        top = new StackNode<T>(value);
    }

    public LinkedStackDS(LinkedStackDS<T> other) {
        top = null;
    }

    public boolean isEmptyStack() {
        return top == null;
    }

    public void push(T item) {
        StackNode<T> newNode = new StackNode<T>(item);
        newNode.next = top;
        top = newNode;
    }

    public T peek() throws StackUnderflowException {
        if (isEmptyStack()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return top.data;
    }

    public void pop() throws StackUnderflowException {
        if (isEmptyStack()) {
            throw new StackUnderflowException("Stack is empty");
        }
        top = top.next;
    }

    private class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode() {
            data = null;
            next = null;
        }

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return data + "";
        }
    }
}