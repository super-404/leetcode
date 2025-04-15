package DataStructure.链表;

/**
 * @program: leetcode
 * @description: 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，
 * <p>
 * 请查找并返回倒数第 cnt 个训练项目编号。
 * @author: 饶嘉伟
 * @create: 2023-12-15 19:38
 **/
public class 训练计划IILCR140 {

    class Solution {
        public ListNode trainingPlan(ListNode head, int cnt) {
            ListNode fast = head;
            ListNode slow = head;
            while (cnt > 0) {
                fast = fast.next;
                cnt--;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.next;
        }
    }
}
