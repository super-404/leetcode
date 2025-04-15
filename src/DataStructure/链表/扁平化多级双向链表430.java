package DataStructure.链表;

/**
 * @program: leetcode
 * @description: 你会得到一个双链表，其中包含的节点有一个下一个指针、
 * 一个前一个指针和一个额外的 子指针 。
 * 这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。
 * 这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。
 * 给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。
 * 让 curr 是一个带有子列表的节点。
 * 子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。  返回 扁平列表的 head 。列表中的节点必须将其 所有 子指针设置为 null
 * @author: 饶嘉伟
 * @create: 2023-12-13 23:59
 **/

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class 扁平化多级双向链表430 {
    class Solution {
        Node n;

        public Node flatten(Node head) {
            if (head == null)
                return null;

            n = head;
            iter (head);
            return n.next;
        }

        public void iter(Node head) {
            if (head == null) {
                return;
            }
            n.next = head;
            n = head;
            iter (head.next);
            iter (head.child);
        }
    }
}
