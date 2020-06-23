package DataStructure.深度优先搜索.day_2020_6_14;


/**
 * @Author: 饶嘉伟
 * @Description:
 * 题目还是比较简单的
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/14 14:52
 * @Param:
 * @return:a
 **/

public class 祖父节点值为偶数的节点和1315 {

}

//Definition for a binary tree node.

//这题直接判断然后，
//把可能的值都判断一遍就好了
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        //注意这里
        //我之前写的是%2
        //2ms
        //改成这个以后，就是1ms了
        //细节啊
        if((root.val&1)==0){
            getSum(root);
        }
        dfs(root.left);
        dfs(root.right);
    }
    public void getSum(TreeNode root){
        if(root.left!=null){
            if(root.left.left!=null){
                sum+=root.left.left.val;
            }
            if(root.left.right!=null){
                sum+=root.left.right.val;
            }
        }

        if(root.right!=null){
            if(root.right.left!=null){
                sum+=root.right.left.val;
            }
            if(root.right.right!=null){
                sum+=root.right.right.val;
            }
        }
    }
}
