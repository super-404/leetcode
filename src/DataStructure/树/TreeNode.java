package DataStructure.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 树的一般性定义
 * @author: 饶嘉伟
 * @create: 2020-10-12 18:24
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;

    public TreeNode() {

    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int x) {
        val = x;
    }

    public void buildTree(TreeNode treeNode, ArrayList<Integer> at) {
        for (Integer i :
                at) {
            getBinaryTree (treeNode, i);
        }

    }

    public void getBinaryTree(TreeNode treeNode, Integer data) {
        if (data == null || treeNode == null)
            return;
        else {
            if (treeNode.val > data) {
                if (treeNode.left == null) {
                    treeNode.left = new TreeNode (data);
                } else {
                    getBinaryTree (treeNode.left, data);
                }
            } else {
                if (treeNode.right == null) {
                    treeNode.right = new TreeNode (data);
                } else {
                    getBinaryTree (treeNode.right, data);
                }
            }
        }
    }

    public static TreeNode getTree(ArrayList<Integer> list) {
        LinkedList<TreeNode> qt = new LinkedList<> ();
        TreeNode q = new TreeNode ();
        TreeNode root = new TreeNode (list.get (0));
        qt.add (root);
        int i = 1;
        while (i < list.size ()) {
            TreeNode p = qt.poll ();
            if (i < list.size ()) {
                p.left = new TreeNode (list.get (i++));
                qt.add (p.left);
            }
            if (i < list.size ()) {
                p.right = new TreeNode (list.get (i++));
                qt.add (p.right);
            }
        }
        return root;
    }

    public static TreeNode getLeetCodeTree(Integer[] list) {
        //Integer DataStructure.a[][]={{1,3,-100,-100,2},{}};
        ArrayList<Integer> ai = new ArrayList<> ();
        Collections.addAll (ai, list);
        TreeNode root = TreeNode.getLeetCodeTree (ai);
        return root;
    }

    public static TreeNode getLeetCodeTree(ArrayList<Integer> list) {
        LinkedList<TreeNode> qt = new LinkedList<> ();
        TreeNode q = new TreeNode ();
        TreeNode root = new TreeNode (list.get (0));
        qt.add (root);
        int i = 1;
        while (i < list.size ()) {
            TreeNode p = qt.poll ();
            if (i < list.size ()) {
                Integer v = list.get (i);
                if (v != -100) {
                    p.left = new TreeNode (list.get (i));
                    qt.add (p.left);
                }
                i++;
            }
            if (i < list.size ()) {
                Integer v = list.get (i);
                if (v != -100) {
                    p.right = new TreeNode (list.get (i));
                    qt.add (p.right);
                }
                i++;
            }
        }
        return root;
    }

    //
    public static void preprint(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println (treeNode.val);
            preprint (treeNode.left);
            preprint (treeNode.right);
        }
    }

}

