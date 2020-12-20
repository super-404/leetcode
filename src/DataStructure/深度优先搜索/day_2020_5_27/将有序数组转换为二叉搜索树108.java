package DataStructure.深度优先搜索.day_2020_5_27;


/**
 * @Author: 饶嘉伟
 * @Description: 这个题目主要是让我们利用一个有序的数组实现一个高度平衡的二叉树
 * 目前看这个序列是递增的
 * <p>
 * 二叉搜索树的一个重要特点就是它的中序遍历得到的数列也是递增的
 * 所以这道题目实际上是想让我们实现一个
 * 二叉树逆中序
 * @Date: 2020/5/27 17:12
 * @Param a
 * @retur: a
 **/

public class 将有序数组转换为二叉搜索树108 {
    public static void main(String[] args) {
        int nums[] = {-10, -3, 0, 5, 9};
        Solution s = new Solution ();
        s.sortedArrayToBST (nums);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return change (0, nums.length - 1, nums);
    }

    public TreeNode change(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        //对这里很重要的一个点就是数列递增
        //因此我们完全不用像普通数列写的那样，需要做节点上值的的判断

        TreeNode root = new TreeNode (nums[mid]);
        //递归实现左子树
        root.left = change (left, mid - 1, nums);
        //递归实现右子树
        root.right = change (mid + 1, right, nums);
        //返回构建好的树
        return root;
    }
}
