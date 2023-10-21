package DataStructure.树.day_2021_3_10;

import DataStructure.树.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * @program: leetcode
 * @description: 计算给定二叉树的所有左叶子之和。
 * @author: 饶嘉伟
 * @create: 2021-03-13 19:41
 **/


public class 左叶子之和404 {

    public int sumOfLeftLeaves(TreeNode root) {
        //因为根节点不算左叶子，所以传入false
//        solution1 (root,false);
//        return res;
        return solution2 (root);

    }

    /*
     * 解法1：
     *   因为需要计算的只是左叶子之和
     *   第一步找到左叶子，
     *   第二步求和
     *
     *   叶子好找，但是怎么知道它是左叶子呢，
     *   需要利用另一个辅助的参数，isLeft，
     *   这个参数可以帮我们判定是否是左叶子
     *   遍历左节点时，传入true,
     *   遍历右节点时，传入false.
     * */
    int res = 0;

    public void solution1(TreeNode root, boolean isLeft) {
        if (root == null)
            return;
        //判断是不是叶子节点，然后判断是不是左叶子节点
        if ((root.right == null && root.left == null) && isLeft) {
            res += root.val;
        }
        solution1 (root.left, true);
        solution1 (root.right, false);
    }
    /*
     * 解法2：
     *   不同于上面那种解法，类似于标记左节点的做法
     *   为什么不直接找到每个节点的左节点呢,
     *   第一步如果root.left存在，判断是否是左叶子节点，
     *   第二步求和
     *
     *
     * */

    public int solution2(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res = root.left.val;
        }
        int left = solution2 (root.left);
        int right = solution2 (root.right);
        return res + right + left;
    }

    @Test
    public void test() {
        Integer a[][] = {
                {3, 9, 20, 10, 11, 15, 7, -100, -100, 12},
                {0, 2, 4, 1, -100, 3, -1, 5, 1, -100, 6, -100, 8}};
        ArrayList<Integer> ai = new ArrayList<> ();
        Collections.addAll (ai, a[0]);
        TreeNode root = TreeNode.getLeetCodeTree (ai);
        System.out.println (sumOfLeftLeaves (root));
    }
}
