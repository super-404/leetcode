package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-09 13:56
 **/
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor (root.left, p, q);

        TreeNode right = lowestCommonAncestor (root.right, p, q);
        //如果左边是空的，说明节点在右边
        if (left == null)
            return right;
        //同理
        if (right == null)
            return left;
        //如果左右两边都不为空，说明左右两边都有，那么root是祖先节点
        return root;
    }
}
