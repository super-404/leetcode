package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-13 21:47
 **/
public class K个一组翻转链表25 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
            ListNode dummyNode = new ListNode (-1);
            dummyNode.next = head;
            ListNode iter = head.next;
            //求解长度
            int len = 0;
            while (iter != null) {
                iter = iter.next;
                len++;
            }
            int count = 1;
            ListNode l = head.next;
            while (len >= k + count - 1) {
                l = reverseBetween (l, count, count + k - 1);
                count += k;
            }
            head.next = l;
            return l;
        }

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
//        mll.addAtTail (3);
//        mll.addAtTail (4);
//        mll.addAtTail (5);
//        mll.addAtTail (6);
        ListNode h = new Solution ().reverseKGroup (mll.head, 2);

        System.out.println (mll.toString ());
    }
}

