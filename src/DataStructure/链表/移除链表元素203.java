package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，
 * <p>
 * 并返回 新的头节点
 * @author: 饶嘉伟
 * @create: 2023-12-13 22:13
 **/
public class 移除链表元素203 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode dummyNode = new ListNode (-1);
            dummyNode.next = null;
            ListNode iter = dummyNode;
            while (head != null) {
                if (head.val != val) {
                    iter.next = head;
                    iter = head;
                }
                head = head.next;
            }
            head = dummyNode.next;
            return dummyNode.next;
        }
    }

    @Test
    public void test() {
        MyLinkedList mll = new MyLinkedList ();
        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);
        mll.addAtTail (3);
        mll.addAtTail (6);
        mll.addAtTail (3);
        mll.addAtTail (4);
        mll.addAtTail (5);
        mll.addAtTail (6);
        ListNode h = new Solution ().removeElements (mll.head.next, 1);

        System.out.println (mll.toString ());
    }
}
