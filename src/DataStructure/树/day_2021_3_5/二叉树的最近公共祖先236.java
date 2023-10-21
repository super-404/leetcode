package DataStructure.树.day_2021_3_5;

import DataStructure.树.TreeNode;

/**
 * @program: leetcode
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @author: 饶嘉伟
 * @create: 2021-03-07 19:48
 **/
public class 二叉树的最近公共祖先236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = lowestCommonAncestor (root.left, p, q);
        TreeNode right = lowestCommonAncestor (root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}
