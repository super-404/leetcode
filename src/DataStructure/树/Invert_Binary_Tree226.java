package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-09 14:17
 **/
public class Invert_Binary_Tree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }


        TreeNode left = invertTree (root.left);
        TreeNode right = invertTree (root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
