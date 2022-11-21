package list;

public class MyLinkedList {
    Node head;
    public MyLinkedList() {}

    public MyLinkedList(Node head) {
        this.head = head;
    }

   public void addHead(int data) {
        Node node = new Node(data);
        if (head != null) {
            node.next = this.head;
            this.head = node;
            return;
        }
       head = node;
   }

   public void addTail(Node nodeTobeAdded) {

   }
}
