package example.persistent;

public class A10LinkedListPalindrome {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null, next = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static boolean isPalindrome(ListNode head) {
        // Base cases: empty or single node is a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the list using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        boolean isPalin = true;

        // Compare the first half with the reversed second half
        while (secondHalf != null) {
            if (firstHalf.value != secondHalf.value) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Restore the original list (optional, if needed)
        reverseList(slow); // Reverses back to original second half

        return isPalin;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        printLinkedList(head);
        System.out.println("List is palindrome: " + isPalindrome(head));
        printLinkedList(head); // Show original list is restored
    }
}