package heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(3);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(9);
        maxHeap.insert(9);
        maxHeap.insert(9);
        maxHeap.insert(9);
        maxHeap.insert(9);
        maxHeap.insert(9);
        maxHeap.insert(9);
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.deleteMax());

        System.out.println(maxHeap.size());

        System.out.println(maxHeap);

    }
}
