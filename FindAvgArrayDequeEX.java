import java.util.ArrayDeque;

public class FindAvgArrayDequeEX {
    public static void main(String[] args) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(34);
        stack.push(75);
        stack.push(15);

        double avg = findAverage(stack);
        System.out.println("Average of the elements in the stack is: " + avg);
    }

    public static double findAverage(ArrayDeque<Integer> stack){
        double sum = 0;
        int count = 0;

        for(int num : stack){
            sum += num;
            count++;
        }

        if(count == 0){
            return 0;
        }
        return sum / count;
    }
}
