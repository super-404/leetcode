package DataStructure.树.day_2020_10_18;

import DataStructure.树.TreeNode;

/**
 * @program: leetcode
 * @description: 给定一个二叉树，原地将它展开为一个单链表。
 *    例如，给定二叉树
 * 1
 * / \
 * 2   5
 * / \  \
 * 3  4  6
 * <p>
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * 来源：力扣（LeetCode）
 * + * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-10-18 23:26
 **/

public class 二叉树展开为链表114 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        flatten (root.left);
        flatten (root.right);

    }

    //解法1 利用后序遍历
    TreeNode pre = null;

    public void solution1(TreeNode root) {
        if (root == null)
            return;
        solution1 (root.left);
        solution1 (root.right);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
