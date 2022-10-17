package hashtable;

public class MyHashTable {
    private HashNode[] bucket;
    private int capacity;
    private int size;

    public MyHashTable() {
        this(10);
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.bucket = new HashNode[capacity];
        this.size = 0;
    }

    // Hash function
    private int getBucketIndex(Integer key) {
        return key % this.capacity;
    }

    private class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Put method inserts value into the beginning of each index of the
     * bucket after checking for collision.
     * @param key
     * @param value
     */
    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or Value cannot be null!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = bucket[bucketIndex];
        while (head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucket[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        bucket[bucketIndex] = node;
        size++;
    }

    /**
     * Return a value if found or return null
     * @param key
     * @return
     */
    public String get(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be an Integer!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = bucket[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * This function removes and returns a value from the hashNodes or turns null if absent.
     * @param key
     * @return
     */
    public String remove(Integer key) {
        if (key == null || !Character.isDigit(key)) {
            throw new IllegalArgumentException("Key must be an Integer!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = bucket[bucketIndex];
        HashNode prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        if (prev == null) {
            bucket[bucketIndex] = head.next;
        } else {
            prev.next = head.next;
        }
        size--;
        return head.value;
    }
}
