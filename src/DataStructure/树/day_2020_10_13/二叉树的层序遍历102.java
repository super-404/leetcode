package DataStructure.树.day_2020_10_13;

import DataStructure.树.TreeNode;

import java.util.*;

/**
 * @program: leetcode
 * @description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * （即逐层地，从左到右访问所有节点）。   
 * 示例： 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-10-13 22:12
 **/
public class 二叉树的层序遍历102 {

}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<> ();
        }
        Queue<TreeNode> qi = new LinkedList<> ();
        qi.add (root);
        List<Integer> li = new ArrayList<> ();
        List<List<Integer>> lli = new ArrayList<> ();
        int size = 1;
        while (!qi.isEmpty ()) {
            TreeNode node = qi.remove ();
            li.add (node.val);
            size--;
            if (node.left != null) {
                qi.add (node.left);
            }
            if (node.right != null) {
                qi.add (node.right);
            }
            if (size == 0) {
                lli.add (new ArrayList<> (li));
                li.clear ();
                size = qi.size ();
            }
        }
        return lli;
    }
}
