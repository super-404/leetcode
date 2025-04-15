package DataStructure.链表;

/**
 * @program: leetcode
 * @description: 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。
 * <p>
 * 返回 已排序的链表 。
 * @author: 饶嘉伟
 * @create: 2023-12-13 10:11
 **/

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class 删除排序链表中的重复元素83 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = fast;
                }
                fast = fast.next;
            }
            slow.next = null;
            return head;
        }
    }

    @Test
    public void test() {
        MyLinkedList mll = new MyLinkedList ();
        mll.addAtTail (1);
        mll.addAtTail (1);
        mll.addAtTail (2);
//        mll.addAtTail ();
//        mll.addAtTail ();
        ListNode h = new Solution ().deleteDuplicates (mll.head);

        System.out.println (mll.toString ());
    }
}
