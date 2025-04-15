package DataStructure.树;

import org.junit.Test;

import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-12 10:17
 **/
public class Validate_Binary_Search_Tree98 {
    public boolean isValidBST(TreeNode root) {
        return getAnswer (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean getAnswer(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val > max || root.val < min) {
            return false;
        }
        boolean left = getAnswer (root.left, min, root.val);
        boolean right = getAnswer (root.right, root.val, max);
        return left && right;
    }

    @Test
    public void test() {
        TreeNode tree = new TreeNode ();
        Integer a[] = {2, 1, 3};
        TreeNode root = TreeNode.getLeetCodeTree (a);
        TreeNode.preprint (root);
        isValidBST (root);
    }
}
