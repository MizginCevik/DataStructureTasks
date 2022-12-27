package linkedList;

public class DeleteNNodesAfterMNodes {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < 16; i++) {
            linkedList.add(new ListNode(i));
        }
        linkedList.print();

        deleteNodes(linkedList.head, 2, 3);
        linkedList.print();

        SinglyLinkedList list = new SinglyLinkedList();
        list.add(new ListNode(1));
        list.add(new ListNode(2));
        list.add(new ListNode(3));
        list.add(new ListNode(4));
        list.add(new ListNode(5));
        list.add(new ListNode(6));
        list.print();

        deleteNodesWithRecursion(list.head, 1, 1);
        list.print();
    }

    public static ListNode deleteNodes(ListNode head, int m, int n) { // O(n) Time, O(1) Space
        if (head == null || head.next == null) { // base check
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        // check it, if one element left after removing n times elements (slow.next == null)
        // check it, it there is no element left after removing
        while (slow != null && slow.next != null) {
            for (int i = 0; i < m - 1; i++) { // m elements will be kept
                slow = slow.next;
                fast = fast.next;
            }
            for (int i = 0; i <= n && fast != null; i++) { // n elements that needs to be removed will be skipped
                fast = fast.next;
            }
            slow.next = fast; // link remaining nodes with the last node
            slow = fast;
        }
        return head;
    }

    public static ListNode deleteNodesWithRecursion(ListNode head, int m, int n) { // O(n) Time, O(n) Space
        if (head == null || head.next == null) { // base check
            return head;
        }
        ListNode current = head;
        ListNode prev = head;

        for (int i = 1; i <= m && current != null; i++) { // skip m nodes
            prev = current;
            current = current.next;
        }
        for (int i = 1; i <= n && current != null; i++) { // delete next n nodes
            current = current.next;
        }

        prev.next = current; // link remaining nodes with the last node

        // recursion for remaining nodes
        deleteNodes(current, m, n);

        return head;
    }

    public static ListNode deleteNodes2(ListNode head, int m, int n) { // O(n) Time, O(1) Space
        ListNode currentNode = head;
        ListNode lastMNode = head;

        while (currentNode != null) {
            int mCount = m;
            int nCount = n;
            while (currentNode != null && mCount != 0) {
                lastMNode = currentNode; // keeps the last element for linking
                currentNode = currentNode.next; // m times move the current pointer
                mCount--;
            }
            while (currentNode != null && nCount != 0) { // n times move only current pointer
                currentNode = currentNode.next;
                nCount--;
            }
            lastMNode.next = currentNode; // delete nodes
        }
        return head;
    }

}
