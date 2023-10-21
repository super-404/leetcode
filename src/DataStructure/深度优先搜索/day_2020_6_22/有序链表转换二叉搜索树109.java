package DataStructure.深度优先搜索.day_2020_6_22;

import DataStructure.深度优先搜索.Tree.TreeNode;

public class 有序链表转换二叉搜索树109 {
    public static void main(String[] args) {
        ListNode head = new ListNode ();
        for (int i = 0; i < 10; i++) {
            head.add (i);
        }
        while (true) {

        }
        //System.out.println (getMid (head).val);
    }

    public static ListNode getMid(ListNode node) {
        if (node == null)
            return null;
        ListNode slow = node;
        ListNode quick = node;
        ListNode temp = null;
        while (quick != null && quick.next != null) {
            temp = slow;
            quick = quick.next.next;
            slow = slow.next;

        }
        if (temp != null) {
            temp.next = null;
        }
        return slow;
    }

}

//一开始的方法感觉有点脑瘫
class Solution1 {
    int count = 0;
    int paths[];

    public int goodNodes(TreeNode root) {
        paths = new int[1000];
        ans (root, 0);
        return count;
    }

    public void ans(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        paths[level] = root.val;
        int max = Integer.MIN_VALUE;
        for (int i = level; i >= 0; i--) {
            if (paths[i] >= max) {
                max = paths[i];
            }
        }
        if (paths[level] >= max) {
            count++;
        }
        ans (root.left, level + 1);
        ans (root.right, level + 1);
    }
}

//这个方法更好一些
class Solution2 {
    private int nodeNum = 0; // 统计好节点的个数

    public int goodNodes(TreeNode root) {
        recur (root, Integer.MIN_VALUE);
        return nodeNum;
    }

    // max用于记录从顶层递归到本层的最大节点值，
    // 若节点大于max说明该结点不小于该结点到根节点路径上所有节点
    public void recur(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            nodeNum++;
            max = node.val;
        }
        recur (node.left, max);
        recur (node.right, max);
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode head;
    ListNode tail;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
        this.head = this;
        this.tail = this;
    }

    public void add(int i) {
        ListNode node = new ListNode (i);
        this.tail.next = node;
        this.tail = node;
    }

}
