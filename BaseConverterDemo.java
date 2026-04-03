public class BaseConverterDemo {
    public static void main(String[] args) {
        BaseConverter bc = new BaseConverter();
        bc.processAndPrint();
    }
}

interface ListStackADT<T>{
    boolean isEmpty();
    void ifEmpty() throws EmptyStackException;
    void push(T item);
    T peek() throws EmptyStackException;
    void pop() throws EmptyStackException;
}

class StackException extends Exception {
    public StackException(String msg) {
        super(msg);
    }
}

class EmptyStackException extends Exception {
    public EmptyStackException(String msg) {
        super(msg);
    }
}

class FullStackException extends Exception {
    public FullStackException(String msg) {
        super(msg);
    }
}

class ListStackDS<T> implements ListStackADT<T>{
    private StackNode<T> top;
    public ListStackDS(){
        top = null;
    }

    public ListStackDS(ListStackDS<T> other){
        if(other.top == null){
            top = null;
        } else {
            top = new StackNode<>(other.top);
         }
    }

    public StackNode<T> getTop() {
        return top;
    }

    public void setTop(StackNode<T> top) {
        this.top = top;
    }

    // methods
    public boolean isEmpty() {
        return top == null;
    }

    public void ifEmpty() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
    }

    public void push(T item) {
        StackNode<T> newNode = new StackNode<>(item);
        newNode.setNext(top);
        top = newNode;
    }

    public T peek() throws EmptyStackException {
        ifEmpty();
        return top.getValue();
    }

    public void pop() throws EmptyStackException {
        ifEmpty();
        top = top.getNext();
    }

    public String toString() {
        String result = "";
        StackNode<T> current = top;

        while (current != null) {
            result += current.getValue() + " ";
            current = current.getNext();
        }
        return result;
    }

    private class StackNode<T> {
        private T value;
        private StackNode<T> next;

        public StackNode() {
            value = null;
            next = null;
        }

        public StackNode(T value) {
            this.value = value;
            this.next = null;
        }

        public StackNode(StackNode<T> other) {
            this.value = other.value;
            this.next = (other.next != null) ? new StackNode<>(other.next) : null;
        }

        public T getValue() {
            return value;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(StackNode<T> next) {
            this.next = next;
        }
    }
}

class BaseConverter{
    private ListStackDS<String> stack;

    public BaseConverter(){
        stack = new ListStackDS<>();
    }

    public void inputPrompt(){
        System.out.println("Base conversion: ");
    }

    public String convert(long number, int base){
        stack = new ListStackDS<>();

        long n = number;

        while(n > 0 ){
            long remainder = n % base;
            stack.push(String.valueOf(remainder));
            n = n / base;
        }

        String result = " ";

        try {
            while (!stack.isEmpty()) {
                result += stack.peek();
                stack.pop();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public String convertAll() {
        String output = "";

        output += "72 (base 4): " + convert(72, 4);
        output += "28 (base 8): " + convert(28, 8);
        output += "53 (base 2): " + convert(53, 2);
        output += "3553 (base 8): " + convert(3553, 8);

        return output;
    }

    public String toString() {
        return convertAll();
    }

    public void processAndPrint() {
        inputPrompt();
        System.out.println(toString());
    }

    // 🔹 INNER CLASS
    private class BaseNumber {
        private Long number;
        private Long base;

        public BaseNumber() {
            number = 0L;
            base = 2L;
        }

        public BaseNumber(Long number, Long base) {
            this.number = number;
            this.base = base;
        }

        public Long getNumber() {
            return number;
        }

        public Long getBase() {
            return base;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public void setBase(Long base) {
            this.base = base;
        }
    }
}


