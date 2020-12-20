package DataStructure.动态规划.day_2020_8_01;

/**
 * @program: leetcode
 * @description: 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * @author: 饶嘉伟
 * @create: 2020-08-01 11:49
 **/

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class 不同的二叉搜索树II95 {
    public static void main(String[] args) {
        List<TreeNode> lt = new Solution2 ().generateTrees (3);
        lt.stream ().forEach ((x) -> System.out.println (x.toString (x)));
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString(TreeNode tn) {
        String s = " ";
        if (tn == null) {
            return "null";
        }
        s = String.valueOf (tn.val);
        s = s + "," + toString (tn.left);
        s = s + "," + toString (tn.right);
        return s;
    }
}

class Solution2 {
    ArrayList<TreeNode> at = new ArrayList<> ();

    public List<TreeNode> generateTrees(int n) {
        return build (1, n);
    }

    public List<TreeNode> build(int start, int end) {
        List<TreeNode> lt = new ArrayList<> ();
        if (start > end) {
            //这里是需要添加null值的
            //否则的话下面的双重循环进不去
            lt.add (null);
            return lt;
        }
        if (start == end) {
            lt.add (new TreeNode (start));
            return lt;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = build (start, i - 1);
            List<TreeNode> rightTree = build (i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode (i);
                    root.left = left;
                    root.right = right;
                    lt.add (root);
                }
            }
        }
        return lt;
    }
}
