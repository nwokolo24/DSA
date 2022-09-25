package list;

import java.util.List;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;

        System.out.println(detect(head));
    }

    private static boolean detect(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) return true;
        }
        return false;
    }
}
