/*
Rhodes Ferris
Program 4
CS 2050
 */
public class MyLinkedStack<T> {

    private Node<T> top;
    private int size;

    private int maxSize;

    public MyLinkedStack(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("size must be greater than 0");
        }
        this.maxSize = maxSize;
        this.top = null;
        this.size = 0;
    }

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(T x) {
        Node<T> nextNode = new Node<>(x);
        if (empty()) {
            top = nextNode;
        } else {
            nextNode.next = top;
            top = nextNode;
        }
        size++;
    }

    public T pop() {
        if (empty()) {
            throw new IllegalStateException("empty stack");
        }
        T poppedItem = top.data;
        top = top.next;
        size--;
        return poppedItem;
    }

    public T peek() {
        if (empty()) {
            throw new IllegalStateException("empty stack");
        }
        return top.data;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}


