package example.persistent;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLinkedList {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.value + "->");
            head = head.next;
        }
    }

    public static void removeDuplicate(ListNode head) {
        Set<Integer> unique = new HashSet<>();
        ListNode previous = null;
        while (head != null) {
            if (unique.contains(head.value)) {
                previous.next = head.next;
            } else {
                unique.add(head.value);
                previous = head;
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original list: ");
        printNode(head);

        removeDuplicate(head);
        System.out.println("Unique list: ");
        printNode(head);
    }
}
