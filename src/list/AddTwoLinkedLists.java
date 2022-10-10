package list;

public class AddTwoLinkedLists {
    public static void main(String[] args) {

    }

    private static ListNode addLinkedLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;
        int carrey = 0;
        while (node1 != null || node2 != null) {
            int val1 = 0;
            int val2 = 0;

            if (node1 != null) val1 = node1.val;
            if (node2 != null) val2 = node2.val;

            int sum = carrey + val1 + val2;
            carrey = sum / 10;

            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;


            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        if (carrey > 0) currentNode.next = new ListNode(carrey);

        return dummy.next;
    }
}
