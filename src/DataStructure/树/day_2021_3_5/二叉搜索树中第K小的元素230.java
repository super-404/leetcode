package DataStructure.树.day_2021_3_5;

import DataStructure.树.TreeNode;

import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @author: 饶嘉伟
 * @create: 2021-03-05 18:26
 **/
public class 二叉搜索树中第K小的元素230 {
    /**
     * 主要思路
     * 利用二叉搜索树左边小于根节点，右边大于根节点的思路
     * <p>
     * 1.根节点左子树的节点个数就是根节点的排名,记作t
     * 如果t小于k，说明要找的节点比根节点大，到root.right中找
     * 如果t==k 直接返回
     * 如果 t> k ,说明要找的节点比根节点小，到root.left中找
     **/
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -100;
        int t = size (root.left) + 1;
        if (t == k) {
            return root.val;
        } else {
            if (t > k && root.left != null) {
                return kthSmallest (root.left, k);
            } else {
                if (t < k && root.right != null)
                    return kthSmallest (root.right, k - t);
            }
        }
        return -100;
    }

    //解法2 利用二叉搜索树的中序遍历是一个有序列表的特点
    //我们只需要中序遍历就好了，这里用了迭代法的中序遍历
    public int solution2(TreeNode root, int k) {
        if (root == null)
            return -100;
        LinkedList<TreeNode> nodeStacks = new LinkedList<> ();
        while (true) {
            //一直往左走，知道左子节点为空
            while (root != null) {
                nodeStacks.push (root);
                root = root.left;
            }
            System.out.println (nodeStacks.toString ());
            TreeNode curNode = nodeStacks.pop ();
            //如果这个节点刚好排名为k
            if (--k == 0) {
                return curNode.val;
            }
            root = curNode.right;
        }
    }

    public int size(TreeNode root) {
        if (root == null)
            return 0;
        return size (root.left) + size (root.right) + 1;
    }
}
