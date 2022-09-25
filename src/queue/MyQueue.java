package queue;

public class MyQueue {
    private int[] store;
    private int head;
    private int tail;
    private int size;

    public MyQueue(int size) {
        this.size = size;
        store = new int[size];
        head = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty())
            head = 0;

        tail = (tail + 1) % size;

        store[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }

        head = (head + 1) % size;
        return true;
    }

    public int front() {
        if (isEmpty())
            return -1;

        return store[head];
    }

    public int rear() {
        if (isEmpty())
            return -1;

        return store[tail];
    }

    // To know if store is full
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    // To know if store is empty
    public boolean isEmpty() {
        return head == -1;
    }
}
