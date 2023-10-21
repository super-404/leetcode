package DataStructure.树.day_2020_12_21;

import DataStructure.树.TreeNode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * @author: 饶嘉伟
 * @create: 2020-12-21 19:03
 **/
public class 二叉搜索树迭代器173 {

}

class BSTIterator {

    Stack<TreeNode> si = new Stack<> ();

    public BSTIterator(TreeNode root) {
        getMin (root);
    }

    //首先找到最小的放在栈顶
    public void getMin(TreeNode root) {
        while (root != null) {
            si.push (root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = si.pop ();
        //然后向右边查找稍大一些的
        getMin (node.right);
        return node.val;
    }

    public boolean hasNext() {
        return si.size () > 0;
    }
}
