package DataStructure.树.day_2021_3_5;

import DataStructure.树.TreeNode;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2021-03-06 19:31
 **/
public class 二叉搜索树的最近公共祖先235 {
    //这个是之前的一个解法，比较蠢的

    /**
     * 主要思路
     * 利用两个list,list1和list2 分别记录从根节点到p,q，路过的所有节点，因为是二叉搜索树
     * 所以只要存在，一定可以通过一条路径找到，且速度较快
     * 从后往前比较list1 和 list2 ，如果有节点相同，则一定是最近公共祖先
     */
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> nodeList1 = new ArrayList<TreeNode> ();
        ArrayList<TreeNode> nodeList2 = new ArrayList<TreeNode> ();
        getAncestors (nodeList1, root, p);
        getAncestors (nodeList2, root, q);
        int size1 = nodeList1.size ();
        int size2 = nodeList2.size ();
        int min = size1 > size2 ? size2 : size1;
        while (min >= 0) {
            if (nodeList1.get (min - 1) == nodeList2.get (min - 1)) {
                return nodeList1.get (min - 1);
            }
            min--;
        }
        return null;
    }

    public void getAncestors(ArrayList<TreeNode> nodeList, TreeNode root, TreeNode g) {
        while (root != null) {
            nodeList.add (root);
            if (root.val == g.val) {
                return;
            } else if (root.val > g.val) {
                root = root.left;
            } else if (root.val < g.val) {
                root = root.right;
            }
        }
    }

    // 利用二叉搜索树以及最近公共祖先的性质
    //首先一个节点要是另外两个节点的最近公共祖先，这两个节点一定分布在它的左子树和右子树中
    //思路如下

    /**
     * 1 检查 p,q节点与当前节点的值大小，
     * 如果p<root&&q<root,说明最近公共祖先在root.left
     * 如果p>root&&q>root,说明最近公共祖先在root.right
     * 同一侧的情况都已经检查完了，那么剩下的情况p,q肯定分布在root的两侧
     * 当前的root肯定是最近公共祖先
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        return solution (root, p, q);
    }

    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > root.val && q.val > root.val) {
            return solution (root.right, p, q);
        } else {
            if (p.val < root.val && q.val < root.val) {
                return solution (root.left, p, q);
            } else {
                return root;
            }
        }
    }
}
