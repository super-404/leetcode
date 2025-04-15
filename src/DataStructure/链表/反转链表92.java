package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-13 12:05
 **/
public class 反转链表92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {


        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null) {
                return head;
            }
            // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
            ListNode dummyNode = new ListNode (-1);
            dummyNode.next = head;
            ListNode preLeft = dummyNode;
            //求解到left的前一个节点
            for (int i = 0; i < left - 1 && preLeft != null; i++) {
                preLeft = preLeft.next;
            }
            // System.out.println (preLeft.val);
            //求解到right的后一个节点
            ListNode lastOneRight = dummyNode;
            for (int i = 0; i < right + 1 && lastOneRight != null; i++) {
                lastOneRight = lastOneRight.next;
            }
            ListNode cur = reverseList (lastOneRight, preLeft.next, right - left);
            preLeft.next = cur;

            //System.out.println (lastOneRight.val);
            return dummyNode.next;
        }

        public ListNode reverseList(ListNode p, ListNode head, int count) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = p;

            ListNode cur = head;

            ListNode next = cur.next;
            int i = 0;
            while (next != null && i < count) {
                cur.next = pre;
                pre = cur;
                cur = next;
                next = cur.next;
                i++;
            }
            cur.next = pre;

            return cur;
        }
    }

    @Test
    public void test() {
        MyLinkedList mll = new MyLinkedList ();
        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);
        mll.addAtTail (4);
        mll.addAtTail (5);
        mll.addAtTail (6);
        ListNode h = new 反转链表92.Solution ().reverseBetween (mll.head.next, 1, 6);

        System.out.println (mll.toString ());
    }
}
