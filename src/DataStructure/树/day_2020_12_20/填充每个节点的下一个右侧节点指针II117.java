package DataStructure.树.day_2020_12_20;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 给定一个二叉树
 * struct Node
 * {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，
 * 让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-12-20 16:24
 **/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


//利用队列遍历树的每一层的，
//在遍历的过程中填充next节点
//时间和空间复杂度都是O(N)
public class 填充每个节点的下一个右侧节点指针II117 {

    public Node connect(Node root) {
        if (root == null)
            return root;
        LinkedList<Node> queue = new LinkedList ();
        root.next = null;
        queue.add (root);
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            Node temp = null;
            for (int i = 0; i < size; i++) {
                Node first = queue.remove ();
                if (first.left != null) {
                    queue.add (first.left);
                }
                if (first.right != null) {
                    queue.add (first.right);
                }
                if (temp != null) {
                    temp.next = first;
                }
                temp = first;
            }
        }
        return root;
    }

    //空间复杂度只有O(1);
    //常数
    public Node other(Node root) {
        if (root == null)
            return root;
        //当前最左边的指针
        Node cur = root;
        while (cur != null) {
            Node head = new Node ();
            Node pre = head;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head.next;
        }
        return root;
    }
}
