package linkedList;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode a = new ListNode(7);
        a.next = new ListNode(8);
        a.next.next = new ListNode(9);
        a.next.next.next = new ListNode(8);
        a.next.next.next.next = new ListNode(7);

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);

        ListNode c = new ListNode(1);
        c.next = new ListNode(2);

        a.print();
//        System.out.println(checkPalindromeWithTwoPointer(a));
        System.out.println(isPalindromeWithStack(a));

        b.print();
        System.out.println(checkPalindromeWithTwoPointer(b));
//        System.out.println(isPalindromeWithStack(b));

        c.print();
        System.out.println(checkPalindromeWithTwoPointer(c));

        System.out.println(checkPalindromeWithTwoPointer(null));

    }

    // Time complexity: O(n) Space complexity: O(1)
    private static boolean checkPalindromeWithTwoPointer(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // for reverse

        while (fast != null && fast.next !=null) {
            fast = fast.next.next; // move fast pointer two times
            ListNode temp = slow; // before slow pointer moves, take the value of slow
            slow = slow.next;
            temp.next = prev; // break the connection
            prev = temp;
        }
        // if the length of linkedList is odd
        if (fast != null) {
            slow = slow.next;
        }
        // check numbers are equal in both side
        while (prev != null && slow !=null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    // Time complexity: O(n) Space complexity: O(n)
    public static boolean isPalindromeWithStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        // I don't want to change the head value, created current variable
        ListNode current = head;
        // put all the elements into stack with current variable
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        // compare popped element and head value are equal
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) { // if the values are not equal, it's not palindrome
                return false;
            }
            head = head.next;
        }
        // if stack is empty, means that all nodes matched, it is palindrome
        return true;
    }

}
/*
Write a method that accepts the head of a singly linked list as parameter
Return true if it is a palindrome or false otherwise.
 */
