package set;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyHashSet {
   static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) {
        Map<Character, Integer> map = Map.of(
                'b', 1,
                'a', 1,
                'l', 2,
                'o', 2,
                'n', 1
        );
    }
}

//class MyHashSet {
//    private Bucket[] bucketArray;
//    private int keyRange;
//
//    public MyHashSet() {
//        this.keyRange = 769;
//        this.bucketArray = new Bucket[this.keyRange];
//        for (int i = 0; i < this.keyRange; i++) {
//            this.bucketArray[i] = new Bucket();
//        }
//    }
//
//    protected int _hash(Integer key) {
//        return (key % this.keyRange);
//    }
//
//    public void add(int key) {
//        int bucketIndex = this._hash(key);
//
//        this.bucketArray[bucketIndex].insert(key);
//    }
//
//    public void remove(int key) {
//        int bucketIndex = this._hash(key);
//
//        this.bucketArray[bucketIndex].delete(key);
//    }
//
//    public boolean contains(int key) {
//        int bucketIndex = this._hash(key);
//
//        return this.bucketArray[bucketIndex].exists(key);
//    }
//}
//
//class Bucket {
//    private LinkedList<Integer> container;
//
//    public Bucket() {
//        container = new LinkedList<Integer>();
//    }
//
//    public void insert(Integer key) {
//        if (this.container.indexOf(key) == -1) {
//            this.container.addFirst(key);
//        }
//    }
//
//    public void delete(Integer key) {
//        this.container.remove(key);
//    }
//
//    public boolean exists(Integer key) {
//        return (this.container.indexOf(key) != -1);
//    }
//}
