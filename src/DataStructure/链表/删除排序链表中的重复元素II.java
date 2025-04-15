package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给定一个已排序的链表的头 head ，
 * 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表。
 * @author: 饶嘉伟
 * @create: 2023-12-16 09:46
 **/
public class 删除排序链表中的重复元素II {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode dummyNode = new ListNode (0);
            ListNode cur = dummyNode;
            cur.next = head;

            while (cur != null) {
//                ListNode tmp = cur;
                if (cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val) {
                    int x = cur.next.val;
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
//                    tmp.next = cur.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummyNode.next;
        }
    }

    @Test
    public void test() {

        MyLinkedList mll = new MyLinkedList ();

        mll.addAtTail (1);
        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);
        mll.addAtTail (3);
        mll.addAtTail (3);


        ListNode h = new Solution ().deleteDuplicates (mll.head.next);
        mll.head.next = h;
        System.out.println (mll.toString ());
    }
}
