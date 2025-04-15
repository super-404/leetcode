import DataStructure.树.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-30 14:14
 **/
public class tongcheng58 {
    public TreeNode solution(TreeNode root) {
        if (root == null)
            return root;
        solution (root.left);
        solution (root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
