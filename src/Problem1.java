import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem1 {
    public static void deleteDups(LinkedListNode head) {
        while(head != null && head.next != null) {
            LinkedListNode headholder = head;
            while(headholder.next != null) {
                if(headholder.next.data == head.data) {
                    headholder.next = headholder.next.next;
                }
                else{
                    headholder = headholder.next;
                }
            }
            head = head.next;
        }
    }

    //Without using extra memory, the algorithm will take O(n*n) time
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        LinkedListNode clone = head.clone();
        deleteDups(head);
        System.out.println(head.printForward());
    }
}
