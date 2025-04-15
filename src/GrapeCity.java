

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-28 18:25
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class GrapeCity {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }


        ListNode first = head, second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            second.next = first;
            first.next = tmp2;
            second = tmp2;
            first = tmp1;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        // Print the reordered list
        ListNode current = head;
        String res = "";
        while (current != null) {
            System.out.print (current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println ();
    }

    public static void test(int k) {
        // Create the linked list 1 -> 2 -> 3 -> 4
        ListNode head = null;
        if (k != 0) {
            head = new ListNode (1);
        }
        //int k = 0;
        int i = 2;
        ListNode temp = head;
        if (temp != null) {
            while (temp != null && i <= k) {
                temp.next = new ListNode (i);
                temp = temp.next;
                i++;
            }
            temp.next = null;
        }
        // Reorder the list
        GrapeCity solution = new GrapeCity ();
        System.out.print ("反转之前：");
        printList (head);
        head = solution.reorderList (head);
        System.out.print ("反转之后：");
        printList (head);
    }

    public static void testFourNum() {
        test (4);
    }

    public static void testZeroNum() {
        test (0);
    }

    public static void testTwoNum() {
        test (2);
    }

    public static void testOneNum() {
        test (1);
    }

    public static void testThreeNum() {
        test (3);
    }

    public static void main(String[] args) {
        testFourNum ();
        testOneNum ();
        testZeroNum ();
        testThreeNum ();
        testTwoNum ();
    }
}

