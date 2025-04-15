package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-11 10:14
 **/

// Definition for a Node.
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
};


public class Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node cur = root;
        Node dummy = new Node (-1);
//        while (root == null) {
//            if (root.left != null) {
//                next.next =
//            }
//        }
        return null;

    }
}
