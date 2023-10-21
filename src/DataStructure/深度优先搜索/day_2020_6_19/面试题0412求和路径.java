package DataStructure.深度优先搜索.day_2020_6_19;


/**
 * @Author: 饶嘉伟
 * @Description: 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，
 * 路径不一定非得从二叉树的根节点或叶节点开始或结束，
 * 但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/19 16:27
 * @Param DataStructure.a
 * @retur: DataStructure.a
 **/

public class 面试题0412求和路径 {
}

//Definition for DataStructure.a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
    sum=22
    对于这棵树而言，执行经过是这样的

层级：0
路径：[5, 0, 0, 0]
结果：0

层级：1
路径：[5, 4, 0, 0]
结果：0

层级：2
路径：[5, 4, 11, 0]
结果：0

层级：3
路径：[5, 4, 11, 7]
结果：1

层级：3
路径：[5, 4, 11, 2]
结果：2

层级：1
路径：[5, 8, 11, 2]
结果：2

层级：2
路径：[5, 8, 13, 2]
结果：2

层级：2
路径：[5, 8, 4, 2]
结果：2

层级：3
路径：[5, 8, 4, 5]
结果：3

层级：3
路径：[5, 8, 4, 1]
结果：3

 */
class Solution1 {
    public int pathSum(TreeNode root, int sum) {
        int dep = depth (root);
        int[] paths = new int[dep];
        pathSum (root, sum, 0, paths);
        return res;
    }

    int res = 0;

    public void pathSum(TreeNode root, int sum, int level, int[] paths) {
        if (root == null) {
            return;
        }
        //保存遍历过程中得到节点数据
        paths[level] = root.val;
        int t = 0;

        //从树的叶子节点开始到树的根节点
        //不会错过任何一条可能的路径

        //反之则不行
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                res += 1;
            }
        }
        pathSum (root.left, sum, level + 1, paths);
        pathSum (root.right, sum, level + 1, paths);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max (depth (root.left), depth (root.right)) + 1;
    }
}
