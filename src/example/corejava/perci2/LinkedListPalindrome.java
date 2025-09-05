package example.corejava.perci2;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListPalindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast=head, slow=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node firstHalf = head;
        Node secondHalf = reverseList(slow);
        boolean isPalin = true;

        while (secondHalf != null) {
            if (secondHalf.value != firstHalf.value) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return isPalin;
    }
    public static Node reverseList(Node head) {
        Node previous=null, next=null, current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.println("List :" + head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        printList(head);
//        printList(reverseList(head));
        System.out.println("List is palindrome: " + isPalindrome(head));
    }
}
