package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 * @author: 饶嘉伟
 * @create: 2023-12-14 07:58
 **/
public class 旋转链表61 {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            //如果没有数据或者只有1个数据，没必要移动
            if (head == null || head.next == null) {
                return head;
            }
            // 计算链表长度
            int len = 0;
            ListNode iter = head;
            // 并得到最后一个节点
            ListNode last = null;

            while (iter != null) {
                len++;
                last = iter;
                iter = iter.next;

            }
            int realK = k % len;
            if (realK == 0) {
                return head;
            }
            //realK = Math.max (realK,len-realK);
            int i = 0;
            iter = head;
            ListNode newHead = head;
            while (i < len - realK - 1) {
                iter = iter.next;
                i++;
            }

            newHead = iter.next;
            iter.next = null;
            last.next = head;
            System.out.println (MyLinkedList.toString (newHead));
            return newHead;
        }
    }

    @Test
    public void test() {
        MyLinkedList mll = new MyLinkedList ();
        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);
        mll.addAtTail (4);

        ListNode h = new Solution ().rotateRight (mll.head.next, 3);

        System.out.println (mll.toString ());
    }
}
