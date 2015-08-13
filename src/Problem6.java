import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem6 {
    public static LinkedListNode detectCycle(LinkedListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        LinkedListNode slow = head, fast = head.next;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow == null || fast == null || fast.next == null) {
            return null;
        }
        int count = 1;
        if(fast.next.next == slow) {
            count = 2;
        }
        else {
            while(fast.next != slow) {
                count++;
                fast = fast.next;
            }
        }
        slow = fast = head;
        for(int i = 0; i < count; i++) {
            fast = fast.next;
        }
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //Two steps: first find the length of the cycle l then make a runner l steps ahead of head
    //return when two runners meet. Notice the use of fast = head.next here
    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = detectCycle(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }
}
