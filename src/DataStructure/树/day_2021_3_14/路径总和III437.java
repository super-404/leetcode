package DataStructure.树.day_2021_3_14;

import DataStructure.树.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2021-03-14 13:27
 **/


/*
you are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf,
but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class 路径总和III437 {
    /*
    前缀和定义

    一个节点的前缀和就是该节点到根之间的路径和。

     拿下图解释：
      节点4的前缀和为：1 + 2 + 4 = 7
      节点8的前缀和：1 + 2 + 4 + 8 = 15
      节点9的前缀和：1 + 2 + 5 + 9 = 17
      1
     /  \
    2    3
   / \    \
  4   5    6
 / \   \
7   8   9

    题目要求的是找出路径和等于给定数值的路径总数, 而:

    两节点间的路径和 = 两节点的前缀和之差

    还是拿下图解释：

                     1
                    /
                   2
                  /
                 3
                /
               4

    假如题目给定数值为 5
    节点1的前缀和为: 1
    节点3的前缀和为: 1 + 2 + 3 = 6
    prefix(3) - prefix(1) == 5
    所以 节点1 到 节点3 之间有一条符合要求的路径( 2 --> 3 )

    恢复状态的意义

由于题目要求：路径方向必须是向下的（只能从父节点到子节点）

当我们讨论两个节点的前缀和差值时，有一个前提：

    一个节点必须是另一个节点的祖先节点

换句话说，当我们把一个节点的前缀和信息更新到map里时，它应当只对其子节点们有效。

举个例子，下图中有两个值为2的节点（A, B)。

      0
     /  \
    A:2  B:2
   / \    \
  4   5    6
 / \   \
7   8   9

    当我们遍历到最右方的节点6时，对于它来说，此时的前缀和为2的节点只该有B, 因为从A向下到不了节点6(A并不是节点6的祖先节点)。

    如果我们不做状态恢复，当遍历右子树时，左子树中A的信息仍会保留在map中，那此时节点6就会认为A, B都是可追溯到的节点，从而产生错误。

    状态恢复代码的作用就是： 在遍历完一个节点的所有子节点后，将其从map中除去。

*/


    /*
     * 解决思路
     *      1：记录从根节点到任意节点的所有值的和，记为totalValue;
     *      2. 计算totalValue - sum = target 如果target 出现在之前子节点的totalValue中,
     *           那么说明在这条路经上一定存在节点和等于sum，保存下来，
     *      3 递归计算其他子路径
     * */
    HashMap<Integer, Integer> prefixSum = new HashMap<> ();

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        //需要注意的就是，前缀和为零，一条路径
        prefixSum.put (0, 1);
        return solution (root, sum, 0);
    }

    private int solution(TreeNode root, int sum, int totalValue) {
        if (root == null)
            return 0;

        totalValue += root.val;
        //查找保存的前缀和当中是否有等于 totalValue - sum 的值
        int target = totalValue - sum;
        int res = 0;
        //如果有的话，说明又找到一条路径了，
        res += prefixSum.getOrDefault (target, 0);
        //保存当前的前缀和
        prefixSum.put (totalValue, prefixSum.getOrDefault (totalValue, 0) + 1);

        int left = solution (root.left, sum, totalValue);
        int right = solution (root.right, sum, totalValue);
        prefixSum.put (totalValue, prefixSum.getOrDefault (totalValue, 0) - 1);
        return res + left + right;
    }

    @Test
    public void test() {
        Integer a[][] = {{0, 0, 0, 0, 0, 0, 0}, {}};
        ArrayList<Integer> ai = new ArrayList<> ();
        Collections.addAll (ai, a[0]);
        TreeNode root = TreeNode.getLeetCodeTree (ai);
        System.out.println (pathSum (root, 0));
    }
}
