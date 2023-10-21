package DataStructure.深度优先搜索.day_2020_5_31;

public class 二叉树中的最大路径和124 {


}

class Solution3 {
    int a[] = new int[1000];
    int k = 0;

    public int maxPathSum(TreeNode root) {
        getVal (root);
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int s = a[i];
            for (int j = i + 1; j < a.length; j++) {
                int sum = s + a[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public void getVal(TreeNode root) {
        if (root == null) {
            return;
        }
        getVal (root.left);
        a[k++] = root.val;
        getVal (root.right);
    }
}
