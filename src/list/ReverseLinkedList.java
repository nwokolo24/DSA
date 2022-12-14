package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;

//        ListNode temp = head;
//        while (temp != null) {
//            System.out.print(temp.val + " -> ");
//            temp = temp.next;
//        }
//
//        System.out.println();
//        System.out.println("After reversing Lineked List");
//        ListNode newHead = reverse(head);
//        temp = newHead;
//        while (temp != null) {
//            System.out.print(temp.val + " -> ");
//            temp = temp.next;
//        }
        List<Integer> v = new ArrayList<>();
        v.add(7);
        v.add(8);
        List<Integer> val = new ArrayList(v);

        System.out.println(val);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }
}
