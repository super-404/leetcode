package DataStructure.深度优先搜索.day_2020_6_23;

import DataStructure.深度优先搜索.Tree.TreeNode;


/**
 * @Author: 饶嘉伟
 * @Description:
 *  给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/23 17:31
 * @Param a
 * @retur: a
 **/

public class 求根到叶子节点数字之和129 {

}

//一开始的解法比较直接
class Solution4 {
    int num=0;
    public int sumNumbers(TreeNode root) {
        sumDfs(root,0);
        return num;
    }
    public void sumDfs(TreeNode root,int sum){
        if(root==null){
            return ;
        }
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            num+=sum;
        }
        sumDfs(root.left,sum);
        sumDfs(root.right,sum);
    }
}

//优化以后的解法
//因为树的每个节点的值
//root=left+right;
//例如
/*       1
        / \
        2  3
*/
//题目其实已经很明显的告诉我们数字总和=12+13
//
class Solution5{
    int num=0;
    public int sumNumbers(TreeNode root) {

        return sumDfs(root,0);
    }
    public int sumDfs(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        return  sumDfs(root.left,sum)+sumDfs(root.right,sum);
    }
}
