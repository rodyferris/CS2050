/* Rhodes Ferris
   Program 4
   CS 2050
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program4 {
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c== '%';
    }

    // Function to determine the precedence of an operator
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        MyLinkedStack<Character> stack = new MyLinkedStack<Character>(infix.length());

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == ' ' || c == '.') {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(c)) {
                while (!stack.empty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.empty()) {
            if (stack.peek() == '(') {
                return "bad parens";
            }
            postfix.append(' ');
            postfix.append(stack.pop());

        }

        return postfix.toString();
    }
    public static void main(String[] args) {
        MyLinkedStack<Character> x=new MyLinkedStack<Character>(32);
        try{
            BufferedReader reader=new BufferedReader(new FileReader("Program3.txt"));
            BufferedWriter writer=new BufferedWriter(new FileWriter("Program4.out"));
            String currentLine;
            writer.write("Rhodes Ferris" + '\n' + "CS 2050 Project 4");
            while((currentLine=reader.readLine()) !=null){
                writer.write('\n' +  currentLine + "  --->  " + infixToPostfix(currentLine));
            }
            reader.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}