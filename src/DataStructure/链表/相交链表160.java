package DataStructure.链表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-16 14:47
 **/
public class 相交链表160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            HashSet<ListNode> hsl = new HashSet<> ();
            ListNode iterA = headA;
            while (iterA != null) {
                hsl.add (iterA);
                iterA = iterA.next;
            }

            ListNode iterB = headB;
            while (iterB != null) {
                if (hsl.contains (iterB))
                    return iterB;
                iterB = iterB.next;
            }
            return null;
        }
    }

}
