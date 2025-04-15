package DataStructure.树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 二叉树的层序遍历，从后往前
 * @author: 饶嘉伟
 * @create: 2024-03-07 09:53
 **/
public class BinaryTreeLevelOrderTraversalII107 {

}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<> ();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> qt = new LinkedList<> ();
        int size = 1;
        qt.add (root);
        while (!qt.isEmpty ()) {
            List<Integer> li = new LinkedList<> ();
            int n = size;
            size = 0;
            for (int i = 0; i < n; i++) {
                TreeNode r = qt.remove ();
                li.add (r.val);
                if (r.left != null) {
                    size++;
                    qt.add (r.left);
                }
                if (r.right != null) {
                    size++;
                    qt.add (r.right);
                }
            }
            ans.add (0, li);
        }
        return ans;
    }
}
