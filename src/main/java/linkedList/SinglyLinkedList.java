package linkedList;

public class SinglyLinkedList {
    ListNode head;
    ListNode tail;

    public void add(ListNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void print() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " —> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
