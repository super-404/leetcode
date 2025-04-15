package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。  请你将两个数相加，并以相同形式返回一个表示和的链表。  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author: 饶嘉伟
 * @create: 2023-12-15 15:42
 **/
public class 两数相加2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode (0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {

                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;

                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode (sum);

                cur = cur.next;
                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode (carry);
            }
            return pre.next;


        }
    }

    @Test
    public void test() {
        MyLinkedList mll = new MyLinkedList ();
        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);

        MyLinkedList mll1 = new MyLinkedList ();
        mll1.addAtTail (1);
        mll1.addAtTail (2);
        mll1.addAtTail (7);
        ListNode h = new Solution ().addTwoNumbers (mll.head.next, mll1.head.next);

        System.out.println (mll.toString ());
    }
}
