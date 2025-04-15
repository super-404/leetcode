package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给你一个单链表的头节点 head，
 * 请你判断该链表是否为回文链表。
 * 如果是，返回 true；
 * 否则，返回 false。
 * @author: 饶嘉伟
 * @create: 2023-12-13 23:31
 **/
public class 回文链表234 {
    class Solution {
        ListNode next = null;

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            next = head;
            return decide (head);
        }

        boolean decide(ListNode head) {
            if (head == null) {
                return true;
            }
            boolean res = decide (head.next);

            if (next.val == head.val) {
                next = next.next;
                return true && res;
            } else {
                return false;
            }
        }
    }

    @Test
    public void test() {

        MyLinkedList mll = new MyLinkedList ();

        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);
        mll.addAtTail (3);
        mll.addAtTail (3);
        mll.addAtTail (1);

        boolean bool = new Solution ().isPalindrome (mll.head.next);

        System.out.println (bool);
    }
}
