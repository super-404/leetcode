package DataStructure.链表;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-14 07:34
 **/


public class 随机链表的复制138 {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node dummyHead = new Node (0);
            Node iter = head;
            Node newList = dummyHead;

            HashMap<Node, Node> hnn = new HashMap<> ();

            while (iter != null) {
                hnn.put (iter, new Node (iter.val));
                iter = iter.next;
            }
            iter = head;
            while (iter != null) {
                hnn.get (iter).next = hnn.get (iter.next);
                hnn.get (iter).random = hnn.get (iter.random);
                iter = iter.next;
            }
            return hnn.get (head);
        }
    }
}
