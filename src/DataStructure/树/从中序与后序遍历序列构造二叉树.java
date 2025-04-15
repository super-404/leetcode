package DataStructure.树;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-12 09:08
 **/
public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<> ();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put (inorder[i], i);
        }
        return solution (inorderMap, postorder, postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode solution(HashMap<Integer, Integer> inorderMap, int[] postorder, int rootIndex, int left, int right) {
        if (left > right || right < 0) {
            return null;
        }
        int rootValue = postorder[rootIndex];

        TreeNode root = new TreeNode (rootValue);
        int index = inorderMap.get (rootValue);
        int leftTreeNum = index - left;
        int rightTreeNum = right - index;
        //定位到根节点索引
        TreeNode leftNode = solution (inorderMap, postorder, rootIndex - rightTreeNum - 1, left, index - 1);
        TreeNode rightNode = solution (inorderMap, postorder, rootIndex - 1, index + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        new 从中序与后序遍历序列构造二叉树 ().buildTree (postorder, inorder);
    }
}
