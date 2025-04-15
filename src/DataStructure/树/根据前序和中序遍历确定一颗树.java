package DataStructure.树;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-11 10:50
 **/


public class 根据前序和中序遍历确定一颗树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<> ();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put (inorder[i], i);
        }
        return solution (inorderMap, preorder, 0, 0, preorder.length);
    }

    private TreeNode solution(HashMap<Integer, Integer> inorderMap, int[] preorder, int rootIndex, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[rootIndex];

        TreeNode root = new TreeNode (rootValue);
        int index = inorderMap.get (rootValue);
        int leftTreeNum = index - left;
        int rightTreeNum = right - index;
        //定位到根节点索引
        TreeNode leftNode = solution (inorderMap, preorder, rootIndex + 1, left, index - 1);
        TreeNode rightNode = solution (inorderMap, preorder, rootIndex + leftTreeNum + 1, index + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    @Test
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new 根据前序和中序遍历确定一颗树 ().buildTree (preorder, inorder);
    }
}
