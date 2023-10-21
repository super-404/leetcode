package DataStructure.深度优先搜索.day_2020_6_10;


/**
 * @Author: 饶嘉伟
 * @Description: 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，
 * 并且总共有 N 枚硬币。
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * <p>
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-coins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/10 15:58
 * @Param DataStructure.a
 * @retur: DataStructure.a
 **/


//这道题目问的是移动次数

//但是实际上移动次数和官方题解给出的一个概念叫做负载量实际上是等同的

//一开始我是考虑说如果该节点已经只有一个硬币就不动它，
// 然后只考虑2和0的那些节点

//真的开始来计算路径
//确实不会
//例如这样一个例子
/*
    2
   / \
  1   0
 / \
0   2

*/
//官方给出负载量的解释，确实可以
//因为每次的移动都是从子节点到父节点，或者从父节点到子节点，单位都是1

//负载量是指我们当前节点的需要的硬币，负数代表少了，正数代表多了

//首先我们需要知道左子树的负载，和右子树的负载，才能计算当前的节点的总负载量，
//因此使用后序遍历最合适
//对于左边的0 左右子树为空，负载量和为0，但是本身不满足要求因此负载量= 0-1=-1，因此移动次数加1
//右2  同理 负载量为 1 因此移动次数加1
//根节点1 负载量 = -1+1+1-1=0

//根据上面的分析可以得到下面的步骤
/*   1. 如果当前节点为空，返回 0，
     2  节点不为空的话，考虑左子树，递归直到遇到空节点
     3  考虑右子树  递归直到遇到空节点
     4   计算路径，也就是左右子树负载量之和
     5   该子树处理完毕，将当前节点的负载量返回给父节点，
*/
public class 在二叉树中分配硬币979 {

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

class Solution {
    int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs (root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs (root.left);

        int right = dfs (root.right);

        result += Math.abs (left) + Math.abs (right);

        //当前节点的负载量应该  自身拥有的硬币+左子树的负载量+右子树的负载量-1
        return root.val + left + right - 1;
    }
}
