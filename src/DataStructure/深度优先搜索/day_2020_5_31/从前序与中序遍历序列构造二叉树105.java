package DataStructure.深度优先搜索.day_2020_5_31;

import org.junit.Test;

import java.util.HashMap;

public class 从前序与中序遍历序列构造二叉树105 {
    @Test
    public void test() {
        new Solution ().buildTree (new int[]{1, 2, 5, 6, 7, 3, 4}, new int[]{5, 2, 6, 7, 1, 3, 4});
    }

}

//Definition for DataStructure.a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < inorder.length; i++) {
            map.put (inorder[i], i);
        }
        //注意这里有个小细节就是
        //数组长度应当减一
        //否则可能会下标越界
        return myBuildTree (preorder, inorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, HashMap<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int val = map.get (preorder[preLeft]);
        //利用根节点的值新建一棵树根节点的值
        TreeNode root = new TreeNode (preorder[preLeft]);

        root.left = myBuildTree (
                preorder,//前序队列的数组
                inorder, //后序队列的数组
                preLeft + 1, //前序队列的左子树开始下标
                preLeft + val - inLeft, //前序队列的左子树结束位置
                map,//哈希表用来去下标的
                inLeft, //中序队列左子树开始位置

                val - 1 //中序队列左子树结束位置
        );
        root.right = myBuildTree (
                preorder,
                inorder,
                preLeft + val - inLeft + 1,
                preRight,
                map,
                val + 1,
                inRight
        );

        return root;
    }
}
