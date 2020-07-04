package DataStructure.深度优先搜索.day_2020_5_26;


public class 是否是一颗平衡树 {

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        test (root);
        return flag;
    }

    //在求解每个节点的高度的时候比较左子树与右子树的高度差
    //就是对每个节点都比较一下他们的子树的差
    public int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = test (root.left);
        int rightHeight = test (root.right);
        if (Math.abs (leftHeight - rightHeight) > 1) {
            flag = false;
        }
        return Math.max (leftHeight, rightHeight) + 1;
    }

}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
