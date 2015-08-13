import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem4 {
    public static LinkedListNode partition(LinkedListNode head, int x) {
        if(head == null) {
            return null;
        }
        LinkedListNode dummy = new LinkedListNode(-1, null, null);
        dummy.next = head;
        LinkedListNode smallerdummy = new LinkedListNode(-1, null, null);
        LinkedListNode returnsmallerdummy = smallerdummy;
        LinkedListNode runner = dummy;
        while(runner.next != null) {
            if(runner.next.data < x) {
                int temp = runner.next.data;
                runner.next = runner.next.next;
                LinkedListNode tempLinkedListNode = new LinkedListNode(temp, null, null);
                smallerdummy.next = tempLinkedListNode;
                smallerdummy = smallerdummy.next;
            }
            else {
                runner = runner.next;
            }
        }
        LinkedListNode smallerrunner = returnsmallerdummy;
        while(smallerrunner.next != null) {
            smallerrunner = smallerrunner.next;
        }
        smallerrunner.next = dummy.next;
        return returnsmallerdummy.next;
    }
    
    //The algorithm I'm using takes O(n) space but preserves the relative order. I don't think there is a in-place 
    // solution that preservers the relative order of elements in the list
    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {1, 3, 7, 5, 2, 9, 4};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

		/* Partition */
        LinkedListNode h = partition(head, 5);

		/* Print Result */
        System.out.println(h.printForward());
    }
}
