package example.persistent;

public class A12ReverseLinkedListInGroup {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void printLinkedList(ListNode head) {
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException("Head cannot be null and k must be positive");
        }

        ListNode dummy = new ListNode(0); // Dummy node to handle head changes
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            ListNode kthNode = prevGroup;
            // Find the kth node of the current group
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }
            // If kth node is null, break (not enough nodes for a full group)
            if (kthNode == null) break;

            ListNode curr = prevGroup.next;
            ListNode next = curr.next;
            // Reverse k nodes
            for (int i = 0; i < k - 1 && next != null; i++) {
                curr.next = next.next;
                next.next = prevGroup.next;
                prevGroup.next = next;
                next = curr.next;
            }

            // Move prevGroup to the end of the reversed group
            prevGroup = curr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Original list:");
        printLinkedList(head);

        int k = 2;
        try {
            ListNode newHead = reverseKGroup(head, k);
            System.out.println("Reversed in groups of " + k + ":");
            printLinkedList(newHead);

            // Test with k > list length
            ListNode head2 = new ListNode(1);
            head2.next = new ListNode(2);
            head2.next.next = new ListNode(3);
            System.out.println("\nOriginal list (k=3):");
            printLinkedList(head2);
            newHead = reverseKGroup(head2, 3);
            System.out.println("Reversed in groups of 3:");
            printLinkedList(newHead);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}