package linkedList;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x){
        this.val=x;
    }

    public void print() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " —> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
