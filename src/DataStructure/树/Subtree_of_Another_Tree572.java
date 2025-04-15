package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-09 14:23
 **/
public class Subtree_of_Another_Tree572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        return findSameNode (root, subRoot);
    }

    public boolean verify(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else if (root.val != subRoot.val) {
            return false;
        }
        boolean left = verify (root.left, subRoot.left);
        boolean right = verify (root.right, subRoot.right);
        return left && right;
    }

    public boolean findSameNode(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean left = findSameNode (root.left, subRoot);
        boolean right = findSameNode (root.right, subRoot);

        return verify (root, subRoot) && left && right;
    }
}
