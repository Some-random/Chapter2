import CtCILibrary.CtCILibrary.AssortedMethods;
import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem3 {
    public static void deleteNode(LinkedListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    //The algorithm here assumes the node to be deleted is not the tail
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}

