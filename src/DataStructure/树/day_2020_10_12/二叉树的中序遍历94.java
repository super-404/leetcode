package DataStructure.树.day_2020_10_12;

import DataStructure.树.TreeNode;

import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个二叉树，返回它的中序 遍历。
 * 示例:  输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3  输出: [1,3,2]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-10-12 18:23
 **/
public class 二叉树的中序遍历94 {
    public static void main(String[] args) {

        ArrayList<Integer> ai = new ArrayList ();
        ai.add (1);
        ai.add (2);
        ai.add (3);
        TreeNode root = TreeNode.getTree (ai);
        new Solution ().inorderTraversal (root);
    }
}

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> si = new Stack ();
        List<Integer> li = new LinkedList<> ();
        if (root == null)
            return li;
        si.push (root);
        TreeNode current = si.peek ();
        while (!si.isEmpty ()) {
            while (current != null) {
                si.push (current);
                current = current.left;
            }
            if (!si.empty ()) {
                current = si.pop ();
                li.add (current.val);
                current = current.right;
            }
        }
        return li;
    }

    public void inorder(TreeNode root, List<Integer> li) {

    }

    public void midTraverse(TreeNode root) {
        /**
         * @Author: 饶嘉伟
         * @Description:
         *          * 根据中序遍历的顺序，对于任一结点，优先访问其左孩子，
         *          * 而左孩子结点又可以看做一根结点，然后继续访问其左孩子结点，
         *          * 直到遇到左孩子结点为空的结点才进行访问，然后按相同的规则访问其右子树。
         *          * 因此其处理过程如下：
         *          *
         *          *    对于任一结点P，
         *
         *   1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，
         *   然后对当前结点P再进行相同的处理；
         *
         *   2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，
         *   然后将当前的P置为栈顶结点的右孩子；
         *
         *   3)直到P为NULL并且栈为空则遍历结束
         * @Date: 2019/6/15 17:16
         * @Param: [root]
         * @return: void
         **/

        Stack<TreeNode> st = new Stack<> ();
        if (root == null) {
            System.out.println ("空树");
            return;
        }
        st.push (root);
        TreeNode p = root;
        while (!st.empty ()) {
            while (p != null) {
                st.push (p);
                p = p.left;
            }
            if (!st.empty ()) {
                p = st.pop ();
                System.out.println (p.val);
                p = p.right;
            }
        }
    }
}
