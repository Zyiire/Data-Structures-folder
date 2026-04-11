import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class StackQueueDemo {
  public static void main(String[] args) {
    // Stack (LIFO)
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i <= 5; i++) stack.push(i);
    while (!stack.isEmpty())
      System.out.println(stack.pop()); // 5, 4, 3, 2, 1

    // Queue (FIFO)
    Queue<String> queue = new LinkedList<>();
    queue.offer("A"); queue.offer("B"); queue.offer("C");
    while (!queue.isEmpty())
      System.out.println(queue.poll()); // A, B, C
  }

}