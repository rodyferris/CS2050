/* Rhodes Ferris
   CS2050 Program 3
 */
import java.util.EmptyStackException;

public class ArrayStackClass {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public ArrayStackClass(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full. Cannot push.");
        }
    }

    public char pop() {
        if (!empty()) {
            return stackArray[top--];
        } else {
            throw new EmptyStackException();
        }
    }

    public char peek() {
        if (!empty()) {
            return stackArray[top];
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean empty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

