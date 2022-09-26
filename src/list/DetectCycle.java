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

//        System.out.println(detectCycle(head));
        System.out.println(returnStartOfCycle(head).val);
    }

    private static boolean detectCycle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) return true;
        }
        return false;
    }

    private static ListNode returnStartOfCycle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return detectStart(slowPtr, head);
            }
        }
        return null;
    }

    // a function to find the start of the loop
    private static ListNode detectStart(ListNode slowPtr, ListNode head) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }
}
