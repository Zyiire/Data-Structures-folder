class QueueOverflowException extends Exception {
    public QueueOverflowException(String message) {
        super(message);
    }
}

class QueueUnderflowException extends Exception {
    public QueueUnderflowException(String message) {
        super(message);
    }
}

class Queue {
    private char[] data;
    private int front;
    private int back;
    private int size;
    private int capacity;

    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        data = new char[capacity];
        front = 0;
        back = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(char c) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Queue is full. Cannot enqueue '" + c + "'.");
        }
        back = (back + 1) % capacity;
        data[back] = c;
        size++;
    }

    public char dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. Cannot dequeue.");
        }
        char c = data[front];
        front = (front + 1) % capacity;
        size--;
        return c;
    }
}

public class VowelConstantsQueueEX {

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String input = "Hello World";

        Queue vowelQueue = new Queue(input.length());
        Queue consonantQueue = new Queue(input.length());

        for (char c : input.toCharArray()) {
            if (c == ' ') continue;
            try {
                if (isVowel(c)) {
                    vowelQueue.enqueue(c);
                } else {
                    consonantQueue.enqueue(c);
                }
            } catch (QueueOverflowException e) {
                System.out.println("Overflow: " + e.getMessage());
            }
        }

        System.out.print("Vowels:     ");
        while (!vowelQueue.isEmpty()) {
            try {
                System.out.print(vowelQueue.dequeue() + " ");
            } catch (QueueUnderflowException e) {
                System.out.println("Underflow: " + e.getMessage());
            }
        }
        System.out.println();

        System.out.print("Consonants: ");
        while (!consonantQueue.isEmpty()) {
            try {
                System.out.print(consonantQueue.dequeue() + " ");
            } catch (QueueUnderflowException e) {
                System.out.println("Underflow: " + e.getMessage());
            }
        }
        System.out.println();

        System.out.println("\nUnderflow Demo");
        try {
            vowelQueue.dequeue();
        } catch (QueueUnderflowException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\nOverflow Demo");
        Queue tinyQueue = new Queue(2);
        try {
            tinyQueue.enqueue('A');
            tinyQueue.enqueue('B');
            tinyQueue.enqueue('C');
        } catch (QueueOverflowException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
