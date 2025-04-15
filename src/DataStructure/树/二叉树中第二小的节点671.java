package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-08-26 12:47
 **/
public class 二叉树中第二小的节点671 {
    int ans = -1;
    int val;

    public int findSecondMinimumValue(TreeNode root) {
        val = root.val;
        dfs (root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (ans != -1 && root.val >= ans) {
            return;
        }
        if (root.val > val) {
            ans = root.val;
        }
        dfs (root.left);
        dfs (root.right);
    }
}
