import DataStructure.深度优先搜索.ListNode.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-14 14:47
 **/
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//将它们合并到一个有序链表中得到。
//        1->1->2->3->4->4->5->6
public class byteDance {
    public ListNode solution(ListNode[] list, int left, int right) {
        if (left >= right) {
            return list[left];
        }
//        if(left>right){
//            return null;
//        }
        int mid = (left + right) / 2;
        ListNode l = solution (list, left, mid);
        ListNode r = solution (list, mid + 1, right);
        return two (l, r);
    }

    public ListNode two(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode p = new ListNode (-1);
        ListNode tail = p;
        ListNode tempa = a;
        ListNode tempb = b;
        while (tempa != null && tempb != null) {
            if (tempa.val > tempb.val) {
                tail.next = tempb;
                tempb = tempb.next;
            } else {
                tail.next = tempa;
                tempa = tempa.next;
            }
            tail = tail.next;
        }
        if (tempa != null) {
            tail.next = tempa;
        } else {
            tail.next = tempb;
        }
        return p.next;
    }

    @Test
    public void test() {

        ListNode[] l = new ListNode[3];
        int a[] = {1, 4, 5};
        int b[] = {1, 3, 4};
        int c[] = {2, 6};
        ListNode l1 = new ListNode (-1);
        ListNode l2 = new ListNode (-1);
        ListNode l3 = new ListNode (-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = l3;
        //[1,4,5],[1,3,4],[2,6]

        for (int i = 0; i < a.length; i++) {
            p1.next = new ListNode (a[i]);

            p1 = p1.next;
        }
        p1.next = null;
        for (int i = 0; i < b.length; i++) {
            p2.next = new ListNode (b[i]);
            p2 = p2.next;
        }
        p2.next = null;
        for (int i = 0; i < c.length; i++) {
            p3.next = new ListNode (c[i]);
            p3 = p3.next;
        }
        p3.next = null;
        l[0] = l1;
        l[1] = l2;
        l[2] = l3;
        ListNode p = solution (l, 0, l.length - 1);
        while (p != null) {
            System.out.println (p.val);
            p = p.next;
        }
    }
}

