package list;

public class MyDoublyLinkedList {

    MyDoublyLinkedList() {}

    public void addNode(Node node, Node nodeToBeAdded) {
        Node prevNode = node.prev;
        nodeToBeAdded.prev = prevNode;
        nodeToBeAdded.next = node.next;
        prevNode.next = nodeToBeAdded;
        node.prev = nodeToBeAdded;
    }
}
