package DataStructure.树.day_2020_9_25;

/**
 * @program: leetcode
 * @description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。  说明: 叶子节点是指没有子节点的节点。
 * @author: 饶嘉伟
 * @create: 2020-09-25 20:13
 **/

import java.util.*;

public class 路径总和II113 {

    List<List<Integer>> lli = new ArrayList<> ();
    List<Integer> li = new ArrayList<> ();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getResult (root, sum);
        return lli;
    }

    public void getResult(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                lli.add (new ArrayList<> (li));
                System.out.println (Arrays.toString (li.toArray ()));
            }
        }
        li.add (root.val);
        pathSum (root.left, sum);
        pathSum (root.right, sum);
        li.remove (li.size () - 1);
    }
}

//Definition for DataStructure.a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
