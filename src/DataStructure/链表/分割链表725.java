package DataStructure.链表;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-15 23:52
 **/

//给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
//
//        每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
//
//        这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
//
//        返回一个由上述 k 部分组成的数组。
//输入：head = [1,2,3], k = 5
//        输出：[[1],[2],[3],[],[]]
//        解释：
//        第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//        最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
public class 分割链表725 {
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode p = head;
            int len = 0;
            while (p != null) {
                len += 1;
                p = p.next;
            }
            int remainder = len % k;
            int di = len / k;
            int maxPart = remainder == 0 ? di : di + 1;
            ListNode[] lns = new ListNode[k];
            p = head;
            //首先是maxpart部分
            int j = 0;
            for (; j < remainder; j++) {
                int i = 0;
                lns[j] = p;
                while (i < maxPart - 1) {
                    p = p.next;
                    i++;
                }
                ListNode tmp = p.next;
                p.next = null;
                p = tmp;

            }
            //然后是剩下的较短部分
            for (; j < k; j++) {
                int i = 0;
                lns[j] = p;
                while (i < di - 1 && p != null) {
                    p = p.next;
                    i++;
                }
                if (p != null) {
                    ListNode tmp = p.next;
                    p.next = null;
                    p = tmp;
                }
            }
            return lns;
        }
    }

    @Test
    public void test() {
        MyLinkedList mll = new MyLinkedList ();
        mll.addAtTail (1);
        mll.addAtTail (2);
        mll.addAtTail (3);
        mll.addAtTail (4);

        ListNode[] h = new Solution ().splitListToParts (mll.head.next, 3);

        System.out.println (h);
    }
}
