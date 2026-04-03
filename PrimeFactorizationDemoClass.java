interface ArrayStackADT<T> {
    void initializeStack();
    boolean isEmptyStack();
    boolean isFullStack();
    void push(T item) throws StackOverflowException;
    T peek() throws StackUnderflowException;
    void pop() throws StackException;
}


class StackException extends Exception{
    public StackException(String message){
        super(message);
    }
}

class StackOverflowException extends Exception{
    public StackOverflowException(String message){
        super(message);
    }
}

class StackUnderflowException extends Exception{
    public StackUnderflowException(String message){
        super(message);
    }
}

class ArrayStackDS<T>{
    private int maxSize;
    private int top;
    private T[] list;

    public ArrayStackDS() {
        maxSize = 100;
        top = -1;
        list = (T[]) new Object[maxSize];
    }

    public ArrayStackDS(int size){
        maxSize = size;
        top = -1;
        list = (T[]) new Object[maxSize];
    }

    public ArrayStackDS(ArrayStackDS<T> other) {
    this.maxSize = other.maxSize;
    this.top = other.top;
    this.list = (T[]) new Object[maxSize];

    for (int i = 0; i <= top; i++) {
        this.list[i] = other.list[i];
    }
}

public void initializeStack(){
    top = -1;
}

public boolean isEmptyStack(){
    return top == -1;
}

public boolean isFullStack(){
    return top == maxSize -1;
}

public void push(T item) throws StackOverflowException{
    if(isFullStack()){
        throw new StackOverflowException("Stack is full");
    }
    top++;
    list[top] = item;
}

public T peek() throws StackUnderflowException {
    if (isEmptyStack()) {
        throw new StackUnderflowException("Stack is empty");
    }
    return list[top];
}

public void pop() throws StackUnderflowException {
    if (isEmptyStack()) {
        throw new StackUnderflowException("Stack is empty");
    }
    top--;
}

}

public class PrimeFactorizationDemoClass {
    
    public static void primeFactors(int num){
        try{
            ArrayStackDS<Integer> stack = new ArrayStackDS<>(50);

            int n = num;

            for(int i = 2; i<= n; i++){
                while(n % i == 0){
                    stack.push(i);
                    n = n / i;
                }
            }

            System.out.println("Prime factorization of " + num + ": ");

            while(!stack.isEmptyStack()){
                System.out.println(stack.peek() + " ");
                stack.pop();
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        primeFactors(3960);
        primeFactors(1234);
        primeFactors(222222);
        primeFactors(1378);
    }

}
