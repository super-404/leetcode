package DataStructure.树.day_2021_3_27;

import DataStructure.树.TreeNode;

/**
 * @program: leetcode
 * @description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree）
 * ，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2021-03-27 15:44
 **/
public class 把二叉搜索树转换为累加树538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        convertBST (root.right);
        sum += root.val;
        root.val = sum;
        convertBST (root.left);
        return root;
    }
}
