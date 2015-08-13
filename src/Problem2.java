import CtCILibrary.CtCILibrary.AssortedMethods;
import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem2 {
    public static LinkedListNode removeNth(LinkedListNode head, int nth) {
        LinkedListNode returnhead = head;
        LinkedListNode runner = head;
        int i, j;
        for(i = 0; i < nth && runner != null; i++) {
            runner = runner.next;
        }
        if(runner == null && i == nth) {
            return head.next;
        }

        while(runner.next != null) {
            head = head.next;
            runner = runner.next;
        }
        head.next = head.next.next;
        return returnhead;
    }

    //The program here assumes n is valid
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        int nth = 3;
        LinkedListNode n = removeNth(head, nth);
        System.out.println(n.printForward());
    }

}
