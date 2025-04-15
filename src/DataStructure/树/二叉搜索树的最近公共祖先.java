package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-13 19:10
 **/
public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.val < p.val && root.val < q.val) {
            left = lowestCommonAncestor (root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            right = lowestCommonAncestor (root.left, p, q);
        }
        return left == null ? right : left;
    }
}
