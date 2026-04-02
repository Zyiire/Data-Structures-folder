/* (1 + 2)*(3 + 4)
    Infix -> Postfix 
    Postfix -> Infix
    Infix -> Prefix
    Prefix -> Infix
    Prefix -> Postfix
    Postfix -> Prefix
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackConversionEX {
    public static int prece(String operator){
        return switch (operator){
            case "+", "-" -> 1;
            case "/", "*" -> 2;
            case "%" -> 3;
            default -> 4;
        };
    }

    public static boolean hasLowPrece(String op1, String op2){
        return prece(op1) <= prece(op2);
    }

    public static boolean isOp(String operator){
        return List.of("+","-","*","/","%").contains(operator);
    }
     
    public static String infixToPostfix(String infix){
        Stack<String> operators = new Stack<>();
        List<String> postfix = new ArrayList<>();
        for(String current : infix.split(" ")){
            if(current.equals("(")){
                operators.push(current);
            } else if(current.equals(")")){
                while(!operators.empty() && !operators.peek().equals("(")){
                    postfix.add(operators.pop());
                }
                operators.pop();
            } else if(isOp(current)){
                while(!operators.empty() && !operators.peek().equals("(") && hasLowPrece(current, operators.peek())){
                    postfix.add(operators.pop());
                }
                operators.push(current);
            } else{
                postfix.add(current);
            }
        }
        while(!operators.empty()){
            postfix.add(operators.pop());
        }
        return String.join(" ", postfix);
    }

    public static String infixToPrefix(String infix){
    String[] tokens = infix.split(" ");
    List<String> reversed = new ArrayList<>();
    for(int i = tokens.length - 1; i >= 0; i--){
        if(tokens[i].equals("("))       reversed.add(")");
        else if(tokens[i].equals(")"))  reversed.add("(");
        else                            reversed.add(tokens[i]);
    }
    Stack<String> operators = new Stack<>();
    List<String> output = new ArrayList<>();
    for(String current : reversed){
        if(current.equals("(")){
            operators.push(current);
        } else if(current.equals(")")){
            while(!operators.empty() && !operators.peek().equals("(")){
                output.add(operators.pop());
            }
            operators.pop();
        } else if(isOp(current)){
            while(!operators.empty() && !operators.peek().equals("(") && prece(operators.peek()) > prece(current)){
                output.add(operators.pop());
            }
            operators.push(current);
        } else {
            output.add(current);
        }
    }
    while(!operators.empty()){
        output.add(operators.pop());
    }
    // reverse the output
    List<String> prefix = new ArrayList<>();
    for(int i = output.size() - 1; i >= 0; i--){
        prefix.add(output.get(i));
    }
    return String.join(" ", prefix);
}

public static String postToInfix(String postfix){
    Stack<String> stack = new Stack<>();
    for(String current : postfix.split(" ")){
        if(isOp(current)){
            String right = stack.pop();
            String left = stack.pop();
            stack.push(" ( " + left + " " + current + " " + right + " ) ");
        } else {
            stack.push(current);
        }
    }
    return stack.pop();
}

public static String prefixToInfix(String prefix){
    Stack<String> stack = new Stack<>();
    String[] token = prefix.split(" ");
    for(int i = token.length - 1; i >= 0; i--){
        String current = token[i];
        if(isOp(current)){
            String left =  stack.pop();
            String right = stack.pop();
            stack.push(" ( " + left + " " + current + " " + right + " ) ");
        } else {
            stack.push(current);
        }
    }
    return stack.pop();
}
   
public static String postfixToPrefix(String postfix){
    Stack<String> stack = new Stack<>();
    for(String current : postfix.split(" ")){
        if(isOp(current)){
            String right = stack.pop();
            String left  = stack.pop();
            stack.push(current + " " + left + " " + right);
        } else {
            stack.push(current);
        }
    }
    return stack.pop();
}

public static String prefixToPost(String prefix){
    Stack<String> stack = new Stack<>();
    String[] tokens = prefix.split(" ");
    for(int i = tokens.length - 1; i >= 0; i--){
        String current = tokens[i];
        if(isOp(current)){
            String left  = stack.pop();
            String right = stack.pop();
            stack.push(left + " " + right + " " + current);
        } else {
            stack.push(current);
        }
    }
    return stack.pop();
}

    public static void main(String[] args) {
    String infix = "( 1 + 2 ) * ( 3 + 4 )";
    String postfix = infixToPostfix(infix);
    String prefix  = infixToPrefix(infix);

    System.out.println("Postfix  : " + postfix);
    System.out.println("Prefix   : " + prefix);
    System.out.println("Post→Inf : " + postToInfix(postfix));
    System.out.println("Pre→Inf  : " + prefixToInfix(prefix));
    System.out.println("Post→Pre : " + postfixToPrefix(postfix));
    System.out.println("Pre→Post : " + prefixToPost(prefix));
    }
}
