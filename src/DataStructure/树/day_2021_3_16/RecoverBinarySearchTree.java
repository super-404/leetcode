package DataStructure.树.day_2021_3_16;

import DataStructure.树.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: You are given the root of DataStructure.a binary search tree (BST),
 * where exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 * <p>
 * Follow up: A solution using O(n) space is pretty straight forward.
 * Could you devise DataStructure.a constant space solution?
 * <p>
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * <p>
 * Explanation: 3 cannot be DataStructure.a left child of 1 because 3 > 1.
 * Swapping 1 and 3 makes the BST valid.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2021-03-16 19:24
 **/
public class RecoverBinarySearchTree {
    @Test
    public void test() {
        Integer a[][] = {{1, 3, -100, -100, 2}, {}};
        ArrayList<Integer> ai = new ArrayList<> ();
        Collections.addAll (ai, a[0]);
        TreeNode root = TreeNode.getLeetCodeTree (ai);
        recoverTree (root);
        print (root);
    }

    public void print(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<> ();
        LinkedList<TreeNode> inOrderList = new LinkedList<> ();
//        inOrderList.add(root);
        TreeNode node = root;
        while (node != null || !inOrderList.isEmpty ()) {
            while (node != null) {
                inOrderList.push (node);
                node = node.left;
            }
            if (!inOrderList.isEmpty ()) {
                TreeNode temp = inOrderList.pop ();
                arrayList.add (temp.val);
                node = temp.right;
            }
        }
        System.out.println (arrayList.toString ());
    }

    /*
    *   解法1：
    *       具体思路
    *           1.找到二叉搜索树中序遍历得到值序列的不满足条件的位置。
    *           2.如果有两个，我们记为 i 和  j（i<j 且 ai>ai+1 && aj>aj+1​)，
    *           那么对应被错误交换的节点即为 ai​ 对应的节点
    *           和 aj+1​ 对应的节点，我们分别记为 x 和 y。
    *           3.如果有一个，我们记为 i，
    *           那么对应被错误交换的节点即为 ai​ 对应的节点和 ai+1​ 对应的节点，
    *           我们分别记为 x 和 y
                4. 交换x和y即可
    * */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> arrayList = new ArrayList<> ();
        LinkedList<TreeNode> inOrderList = new LinkedList<> ();
        TreeNode node = root;
        while (node != null || !inOrderList.isEmpty ()) {
            while (node != null) {
                inOrderList.push (node);
                node = node.left;
            }
            if (!inOrderList.isEmpty ()) {
                TreeNode temp = inOrderList.pop ();
                arrayList.add (temp.val);
                node = temp.right;
            }
        }
        System.out.println (arrayList.toString ());

        //找到不满足升序排列的位置
        Integer[] a = arrayList.toArray (new Integer[arrayList.size ()]);
        int first = -1;
        int second = -1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                if (first == -1) {
                    first = i;
                    second = i + 1;
                } else {
                    second = i + 1;
                }
            }
        }

        //找到错误的节点
        TreeNode wrongNode1 = null;
        TreeNode wrongNode2 = null;
        wrongNode1 = getWrongNodes (root, a[first]);
        wrongNode2 = getWrongNodes (root, a[second]);

        //交换值
        Integer temp = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = temp;
    }

    private TreeNode getWrongNodes(TreeNode root, Integer wrongValue) {
        if (root == null) {
            return null;
        }
        if (root.val == wrongValue) {
            return root;
        }
        TreeNode left = getWrongNodes (root.left, wrongValue);
        TreeNode right = getWrongNodes (root.right, wrongValue);
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}
