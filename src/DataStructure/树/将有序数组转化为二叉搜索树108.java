package DataStructure.树;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * @author: 饶嘉伟
 * @create: 2024-03-27 21:28
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 **/
public class 将有序数组转化为二叉搜索树108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree (nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode (nums[mid]);
        root.left = buildTree (nums, left, mid - 1);
        root.right = buildTree (nums, mid + 1, right);
        return root;
    }
}
