import java.util.ArrayDeque;

public class ArrayDequeTest{
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        //add elements
        queue.offerFirst("Apple");
        queue.offerLast("Banana");
        queue.offerLast("Orange");

        System.out.println("\nDequed elements: ");
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollLast());

        System.out.println("The first element is: " + queue.peekFirst());
        
        queue.offerLast("Grapes");
        queue.offerLast("Mango");

        System.out.println("Queue size is: " + queue.size());

        System.out.println("Dequeued all elements");
        while(!queue.isEmpty()){
            System.out.println(queue.pollFirst());
        }

        // try to dequeue from an empty queue
        try{
            queue.removeFirst(); // this will not throw an exception
        } catch(java.util.NoSuchElementException e){
            System.out.println("Exception is caught: " + e.getMessage());
        }
    }
}