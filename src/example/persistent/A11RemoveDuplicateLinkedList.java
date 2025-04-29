package example.persistent;

import java.util.HashSet;
import java.util.Set;

public class A11RemoveDuplicateLinkedList {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void printNode(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
            if (current != null) {
                System.out.print("->");
            }
        }
        System.out.println("->null");
    }

    public static ListNode removeDuplicates(ListNode head) {
        // Handle empty or single node list
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> unique = new HashSet<>();
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            if (unique.contains(current.value)) {
                // Skip the duplicate by updating the previous node's next pointer
                previous.next = current.next;
            } else {
                // Add the value to the set and update previous
                unique.add(current.value);
                previous = current;
            }
            current = current.next;
        }

        return head;
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

        System.out.println("Original list:");
        printNode(head);

        head = removeDuplicates(head);
        System.out.println("Unique list:");
        printNode(head);

        // Test with all duplicates
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        System.out.println("\nAll duplicates list:");
        printNode(head2);
        head2 = removeDuplicates(head2);
        System.out.println("Unique list:");
        printNode(head2);
    }
}