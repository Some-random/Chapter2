import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem5 {
    public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        int carrier = 0, result = 0;
        LinkedListNode l3 = new LinkedListNode(-1, null, null);
        LinkedListNode returnl3 = l3;
        while(l1 != null && l2 != null) {
            result = (l1.data + l2.data + carrier) % 10;
            carrier = (l1.data + l2.data + carrier) / 10;
            LinkedListNode temp = new LinkedListNode(result, null, null);
            l3.next = temp;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            result = (l1.data + carrier) % 10;
            carrier = (l1.data + carrier) / 10;
            LinkedListNode temp = new LinkedListNode(result, null, null);
            l3.next = temp;
            l3 = l3.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            result = (l2.data + carrier) % 10;
            carrier = (l2.data + carrier) / 10;
            LinkedListNode temp = new LinkedListNode(result, null, null);
            l3.next = temp;
            l3 = l3.next;
            l2 = l2.next;
        }
        if(carrier != 0) {
            LinkedListNode temp = new LinkedListNode(carrier, null, null);
            l3.next = temp;
        }
        return returnl3.next;
    }

    //The program here only works if the numbers are reversed, if numbers are not reversed, just reverse it and call the
    //same function...
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(9, null, null);
        LinkedListNode h2 = new LinkedListNode(1, null, null);
        LinkedListNode h3 = new LinkedListNode(6, null, null);
        LinkedListNode head2 = new LinkedListNode(0, null, null);
        head1.next = h2;
        h2.next = h3;
        LinkedListNode head3 = addTwoNumbers(head1, head2);
        System.out.println(head1.printForward());
        System.out.println(head2.printForward());
        System.out.println(head3.printForward());
    }
}
