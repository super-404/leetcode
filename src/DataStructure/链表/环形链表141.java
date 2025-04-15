package DataStructure.链表;

/**
 * @program: leetcode
 * @description: 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false
 * @author: 饶嘉伟
 * @create: 2023-12-16 10:26
 **/
public class 环形链表141 {
    class Solution {

        /**
         * @Author: 饶嘉伟
         * @Description:
         * @Date: 2023/12/16 10:34
         * @Param head
         * @retur: boolean
         **/

        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
