package DataStructure.树.day_2020_10_14;

import DataStructure.树.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-10-14 23:00
 **/
public class 二叉树的锯齿形层次遍历103 {
    public static void main(String[] args) {
        ArrayList<Integer> ai = new ArrayList ();
        ai.add (1);
        ai.add (2);
        ai.add (3);
        ai.add (4);
        ai.add (5);
        ai.add (6);
        TreeNode root = TreeNode.getTree (ai);
        new Solution ().zigzagLevelOrder (root).stream ().forEach ((x) -> System.out.println (x));
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<> ();
        }
        Queue<TreeNode> qt = new LinkedList<> ();
        qt.add (root);
        List<List<Integer>> lli = new ArrayList<> ();
        List<Integer> li = new ArrayList<> ();
        int size = 1;

        //用来表示需要移除几位
        int count = size;

        //用来获得前面几位
        int num = 0;
        boolean flag = true;
        while (!qt.isEmpty ()) {

            TreeNode node = ((LinkedList<TreeNode>) qt).get (num++);

            TreeNode node1 = null;

            if (flag) {
                li.add (node.val);
            } else {
                node1 = ((LinkedList<TreeNode>) qt).get (size - 1);
                li.add (node1.val);
            }
            size--;
            if (node.left != null) {
                qt.add (node.left);
            }
            if (node.right != null) {
                qt.add (node.right);
            }
            if (size == 0) {
                for (int i = 0; i < count; i++) {
                    qt.remove ();
                }
                num = 0;
                size = qt.size ();
                count = size;
                flag = !flag;
                lli.add (new ArrayList<> (li));
                li.clear ();
            }
        }
        return lli;
    }
}
