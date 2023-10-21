package DataStructure.树.day_2022_9_3;

import DataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2022-09-03 14:45
 **/
public class 不同的二叉搜索树2_95 {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode> ();
        if (n == 0) {
            return ans;
        }
        return getAns (1, n);
    }

    private static List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode> ();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            ans.add (null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode (start);
            ans.add (tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = getAns (start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = getAns (i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode (i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add (root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        generateTrees (3);
    }
}
