import java.util.ArrayDeque;

public class MinMaxStackArrayDQEX {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;
    private ArrayDeque<Integer> maxStack;

    public MinMaxStackArrayDQEX(){
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int num){
        stack.push(num);

        if(minStack.isEmpty() || num <= minStack.peek()){
            minStack.push(num);
        }

        if(maxStack.isEmpty() || num >= maxStack.peek()){
            maxStack.push(num);
        }
    }

    public int pop( ){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }

        int num = stack.pop();

        if(num == minStack.peek()){
            minStack.pop();
        }
        if(num == maxStack.peek()){
            maxStack.pop();
        }
        
        return num;
    }

    public int getMin(){
        if(isEmpty()){
            throw new IllegalStateException("The Stack is Empty");
        }

        return minStack.peek();
    }

    public int getMax(){
        if(isEmpty()){
            throw new IllegalStateException("The Stack is Empty");
        }

        return maxStack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MinMaxStackArrayDQEX stack = new MinMaxStackArrayDQEX();
        stack.push(40);
        stack.push(23);
        stack.push(56);

        System.out.println("Min value: "+ stack.getMin());
        System.out.println("Max value: "+ stack.getMax());

        stack.pop();
        System.out.println("\nAfter the pop: " );

        System.out.println("Min value: " + stack.getMin());
        System.out.println("Max value: "+ stack.getMax());
    }
}

