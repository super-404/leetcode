package DataStructure.树;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-07 10:15
 **/
public class _Maximum_Depth_of_Binary_Tree104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return depth (root, 1);
        }

        public int depth(TreeNode root, int count) {
            if (root == null) {
                return count;
            }
            return Math.max (
                    depth (root.left, count + 1),
                    depth (root.right, count + 1));
        }
    }
}
