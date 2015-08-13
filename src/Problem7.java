import CtCILibrary.CtCILibrary.LinkedListNode;

/**
 * Created by Bob_JIANG on 8/13/2015.
 */
public class Problem7 {
    public static LinkedListNode reverse(LinkedListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedListNode pre = head, cur = head.next, post = cur.next;
        while(post != null) {
            cur.next = pre;
            pre = cur;
            cur = post;
            post = post.next;
        }
        cur.next = pre;
        head.next = null;
        return cur;
    }

    public static boolean isPalindrome(LinkedListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        LinkedListNode slow = head, fast = head.next;
        LinkedListNode returnhead;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //means an odd number of total nodes
        if(fast == null) {
            LinkedListNode tempslow = slow.next;
            slow.next = null;
            returnhead = reverse(head);
            returnhead = returnhead.next;
            slow = tempslow;
        }
        //means an even number of total nodes
        else {
            LinkedListNode tempslow = slow.next;
            slow.next = null;
            returnhead = reverse(head);
            slow = tempslow;
        }


        while(slow != null && returnhead != null) {
            if(slow.data != returnhead.data) {
                return false;
            }
            slow = slow.next;
            returnhead = returnhead.next;
        }
        if(slow != null || returnhead != null) {
            return false;
        }
        return true;
    }

    //To achieve O(n) time complexity and O(1) space complexity, we reverse half the list and then compare if both half
    // are the same
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(0, null, null);
        LinkedListNode tail = new LinkedListNode(0, null, null);
        head1.next = tail;
        System.out.println(isPalindrome(head1));
        int length = 10;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());

        System.out.println(isPalindrome(head));
    }
}
