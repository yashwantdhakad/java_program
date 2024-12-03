package example.persistent;

public class ReverseLinkedListInGroup {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode previous = null;
        ListNode next = null;
        ListNode current = head;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverse(next, k);
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        printLinkedList(head);
        int k = 2;
        ListNode newHead = reverse(head, k);
        printLinkedList(newHead);
    }
}
