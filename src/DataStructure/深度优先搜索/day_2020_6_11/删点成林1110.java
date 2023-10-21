package DataStructure.深度优先搜索.day_2020_6_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: 饶嘉伟
 * @Description: 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，
 * 最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/13 13:40
 * @Param DataStructure.a
 * @retur: DataStructure.a
 **/

public class 删点成林1110 {
    public static void main(String[] args) {
        String t = "\\";
        if (t.charAt (0) == '\\') {
            System.out.println (t.charAt (0) + "---" + t.length ());
        }

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


//题目要求返回一个列表，列表中是每棵树的根节点

/*
  步骤：
     1.如果根节点不为空并且不是要删除的节点，加入列表
     2.开始dfs,传入根节点
     3.左子树递归
     4.右子树递归

     5.判断该节点是否是将要删除的节点，
            如果该节点的左节点不为空，将左节点加入列表
            如果该节点的右节点不为空，将右节点加入列表
            然后返回null。
            如果子节点被删除，父节点的left、right字段需要更新。
       返回该节点
  */

class Solution1 {
    ArrayList<TreeNode> treeNodeList = new ArrayList ();
    HashSet<Integer> hashSet = new HashSet ();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (Integer i : to_delete) {
            hashSet.add (i);
        }
        if (root != null && !hashSet.contains (root.val)) {
            treeNodeList.add (root);
        }
        del (root);
        return treeNodeList;
    }

    public TreeNode del(TreeNode root) {
        if (root == null) {
            return null;
        }
        //更新父节点的left、right字段
        root.left = del (root.left);
        root.right = del (root.right);

        if (hashSet.contains (root.val)) {
            if (root.left != null) {
                treeNodeList.add (root.left);
            }
            if (root.right != null) {
                treeNodeList.add (root.right);
            }
            //将要删除的节点设置为null
            return null;
        }
        //不是目标节点的原样返回
        return root;

    }
}
