package DataStructure.树.day_2020_11_26;

/**
 * @program: leetcode
 * @description: 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author: 饶嘉伟
 * @create: 2020-11-26 20:41
 **/
/*
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import DataStructure.树.TreeNode;

import java.util.*;

public class day_2020_11_26 {
    List<Integer> li = new ArrayList ();

    public List<Integer> rightSideView(TreeNode root) {
        dfs (root, 0);
        return li;
    }

    //层序遍历的解法
    public List<Integer> solution(TreeNode root) {
        List<Integer> li = new ArrayList ();
        if (root == null)
            return li;
        Queue<TreeNode> integerList = new LinkedList<> ();
        integerList.add (root);
        int right = 0;
        int size = 1;
        while (!integerList.isEmpty ()) {
            TreeNode t = ((LinkedList<TreeNode>) integerList).pop ();
            size--;
            right = t.val;//因为是先左后右的遍历，所以当一层遍历完之后，最后的那个节点的值就是一层的最右的值
            if (t.left != null) {
                integerList.add (t.left);
            }
            if (t.right != null) {
                integerList.add (t.right);
            }
            if (size == 0) {
                //size
                size = integerList.size ();
                li.add (right);
            }
        }
        return li;
    }

    //递归的解法
    public void dfs(TreeNode root, int depth) {

        if (root == null)
            return;
        //因为每一层只有最右边的节点才能看到
        //一层一个，所以li的大小和树的高度对应
        // 如果当前节点所在深度还没有出现在li里，
        // 说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
        if (depth == li.size ()) {
            li.add (root.val);
        }
        dfs (root.right, depth + 1);
        dfs (root.left, depth + 1);
        return;
    }
}
