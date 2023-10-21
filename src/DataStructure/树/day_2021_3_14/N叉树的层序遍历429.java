package DataStructure.树.day_2021_3_14;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2021-03-14 10:47
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Definition for DataStructure.a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queueNode = new LinkedList<> ();
        queueNode.add (root);
        List<List<Integer>> lli = new ArrayList<> ();
        ArrayList<Integer> objects = new ArrayList<> ();

        int size = 1;
        while (!queueNode.isEmpty ()) {
            Node n = queueNode.poll ();
            objects.add (root.val);
            size--;
            if (n.children != null) {
                for (Node node : n.children) {
                    if (node != null) {
                        queueNode.add (node);
                    }
                }
            }
            if (size == 0) {
                lli.add (new ArrayList<> (objects));
                objects.clear ();
                size = queueNode.size ();
            }
        }
        return lli;
    }

    List<List<Integer>> result = new ArrayList<> ();

    //递归解法
    // 只要知道层数也是一样的
    public List<List<Integer>> solution2(Node root) {
        if (root == null) {
            return null;
        }
        return result;
    }

    public void fun(Node root, int level) {
        if (result.size () >= level) {
            result.add (new ArrayList<> ());
        }
        result.get (level).add (root.val);
        for (Node children :
                root.children) {
            fun (children, level + 1);
        }
    }
}

public class N叉树的层序遍历429 {

}
