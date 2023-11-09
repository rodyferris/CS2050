/* Rhodes Ferris
   CS2050 Program 3
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.EmptyStackException;

public class Program3 {
    public static String InfixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        ArrayStackClass operatorStack = new ArrayStackClass(infix.length());
        char[] infixArray = infix.toCharArray();

        for (char c : infixArray) {
            if (isOperand(c)) {
                postfix.append(c);
                postfix.append(' ');
            } else if (isOperator(c)) {
                while (!operatorStack.empty() && hasHigherPrecedence(operatorStack.peek(), c)) {
                    postfix.append(operatorStack.pop());
                    postfix.append(' ');
                }
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                try {
                    while (!operatorStack.empty() && operatorStack.peek() != '(') {
                        postfix.append(operatorStack.pop());
                        postfix.append(' ');
                    }
                    operatorStack.pop(); // Pop the '('
                } catch (EmptyStackException e) {
                    return "unmatched parens";
                }
            } else {
                return "invalid character";
            }
        }

        while (!operatorStack.empty()) {
            if (operatorStack.peek() == '(') {
                return "unmatched parens";
            }
            postfix.append(operatorStack.pop());
            postfix.append(' ');
        }

        return postfix.toString().trim();
    }

    private static boolean isOperand(char c) {
        return Character.isDigit(c) || c == '.';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private static int getPrecedence(char operator) {
        if (operator == '+' || operator == '-')
            return 1;
        if (operator == '*' || operator == '/' || operator == '%')
            return 2;
        return 0;
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Program3.txt"));
            FileWriter writer = new FileWriter("Program3.out");

            String line;
            while ((line = reader.readLine()) != null) {
                String infix = line.trim();
                String postfix = InfixToPostfix(infix);
                writer.write(infix + " -> " + postfix + "\n");
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
