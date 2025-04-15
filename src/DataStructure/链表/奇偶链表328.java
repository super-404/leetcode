package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-13 22:48
 **/
public class 奇偶链表328 {

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            //如果元素数量在0个，1个，2个没有必要链接
            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }
            //保存两个链表的头节点
            ListNode oddFirst = head;
            ListNode evenFirst = oddFirst.next;

            //保存需要链接的奇偶节点
            ListNode odd = head;
            ListNode even = head;

            ListNode oddList = oddFirst;
            ListNode evenList = evenFirst;

            while (odd != null && even != null) {

                odd = evenList.next;

                if (odd != null)
                    even = odd.next;
                else {
                    break;
                }

                oddList.next = odd;
                oddList = odd;

                evenList.next = even;
                evenList = even;
            }
            oddList.next = evenFirst;
            return oddFirst;
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
        mll.addAtTail (7);
        mll.addAtTail (8);
        mll.addAtTail (9);

        ListNode h = new Solution ().oddEvenList (mll.head.next);

        System.out.println (mll.toString ());
    }
}
