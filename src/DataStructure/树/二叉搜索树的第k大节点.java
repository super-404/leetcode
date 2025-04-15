package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-23 10:18
 **/
public class 二叉搜索树的第k大节点 {
    int k = 0;
    int ans = 0;

    public int findTargetNode(TreeNode root, int cnt) {
        k = cnt - 1;
        solution (root);
        return ans;
    }

    public void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        solution (root.right);
        if (k == 0) {
            ans = root.val;
        }
        k--;
        solution (root.left);
    }
}
