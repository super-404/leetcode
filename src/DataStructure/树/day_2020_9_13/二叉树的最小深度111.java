package DataStructure.树.day_2020_9_13;

import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: 饶嘉伟
 * @create: 2020-09-13 21:23
 **/

//Definition for DataStructure.a binary tree node.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    TreeNode node;
    int depth;

    Node(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Node> queueNode = new LinkedList<> ();
        int depth = 0;
        queueNode.add (new Node (root, ++depth));
        while (!queueNode.isEmpty ()) {
            Node r = queueNode.poll ();

            if (r.node.left == null && r.node.right == null) {
                return r.depth;
            }
            if (r.node.left != null) {
                queueNode.add (new Node (r.node.left, r.depth + 1));
            }
            if (r.node.right != null) {
                queueNode.add (new Node (r.node.right, r.depth + 1));
            }
        }
        return depth;
    }
}

public class 二叉树的最小深度111 {

}
