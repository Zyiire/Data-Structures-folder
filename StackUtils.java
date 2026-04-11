import java.util.Stack;

public class StackUtils {

    public static double findAndRemoveLargest(Stack<Double> myStack) {
        if (myStack.isEmpty()) {
            return -373.0; 
        }

        Stack<Double> tempStack = new Stack<>();
        double largestValue = myStack.pop();
        tempStack.push(largestValue);

        while (!myStack.isEmpty()) {
            double currentValue = myStack.pop();
            if (currentValue > largestValue) {
                largestValue = currentValue;
            }
            tempStack.push(currentValue);
        }

        while (!tempStack.isEmpty()) {
            double currentValue = tempStack.pop();
            if (currentValue != largestValue) {
                myStack.push(currentValue);
            }
        }

        return largestValue;
    }
}
