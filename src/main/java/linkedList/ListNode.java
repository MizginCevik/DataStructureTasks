package linkedList;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x){
        val=x;
        next=null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode current = this;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
