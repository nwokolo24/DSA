package list;

public class RemoveDuplicate {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;

        // Use temporary variable to avoid modifying the original list
        ListNode temp = head;
        System.out.println("Before removing duplicates");
        while (temp != null) {
            System.out.print(String.valueOf(temp.val) + " -> ");
            temp = temp.next;
        }
        System.out.println();

        // Remove duplicates
        removeDup(head);


        temp = head;
        System.out.println("After removing duplicates");
        while (temp != null) {
            System.out.print(String.valueOf(temp.val) + " -> ");
            temp = temp.next;
        }
    }

    private static void removeDup(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
