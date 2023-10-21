package DataStructure.树.day_2021_3_17;

import DataStructure.树.TreeNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description: 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。  给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * @author: 饶嘉伟
 * @create: 2021-03-17 19:25
 **/
public class 二叉树中的最大路径和124 {
    @Test
    public void test() {
        Integer a[][] = {{5, -100, -10, 9, 20, -100, -100, 15, 7}};
        TreeNode root = TreeNode.getLeetCodeTree (a[0]);
        solution (root);
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        solution (root);
        return max;
    }

    private int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solution (root.left);
        int right = solution (root.right);
        int sum = root.val;
        //负数只会导致sum更小,没有加上的必要
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }

        //每个节点的都有可能是最大值，比较一下啊
        sum = sum + left + right;

        if (sum > max) {
            max = sum;
        }
        //返回的时候注意，因为只能是有一条路径，所以比较左右子树的最大最小值。
        return root.val + Math.max (left, right);
    }
}
