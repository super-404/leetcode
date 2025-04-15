import DataStructure.树.TreeNode;
//import edu.princeton.cs.algs4.Stack;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2021-03-27 11:09
 **/

public class Test {

    public void test1(Collection<?> collections) {
        // collections.add ();

    }

    ArrayList<Integer> res = new ArrayList<> ();

    public void addData(TreeNode root) {
        //如果是个空树；直接返回[]
        if (root == null)
            return;
        // 按照左根右的顺序

        addData (root.left);
        res.add (root.val);
        addData (root.right);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        addData (root);
        return res;

    }

    //非递归遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stree = new Stack<> ();
        if (root == null) {
            return res;
        }

        while (root != null || !stree.isEmpty ()) {
            while (root != null) {
                stree.push (root);
                root = root.left;
            }
            TreeNode topNode = stree.pop ();
            res.add (topNode.val);
            root = topNode.right;
        }
        return res;

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为空
        if (p == null && q == null) {
            return true;
        }
        //如果有一个不为空，一个为空
        else if (p == null || q == null) {
            return false;
        }
        //两个都不为空,但是不相等，直接返回false
        else if (p.val != q.val)
            return false;
        else
            //两个不为null,但是相等，分别检查左右子树
            return isSameTree (p.left, q.left) && isSameTree (p.right, q.right);


    }

    //轴对称
    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> qt = new LinkedList<> ();
        qt.add (root);
        while (!qt.isEmpty ()) {
            int size = qt.size ();
            int[] a = new int[1000];
            for (int i = 0; i < size; i++) {
                TreeNode node = ((LinkedList<TreeNode>) qt).get (i);
                if (node != null) {
                    a[i] = node.val;
                } else {
                    a[i] = -101;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = qt.remove ();
                if (node != null) {
                    qt.add (node.left);
                    qt.add (node.right);
                }
            }
            for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
                if (a[i] != a[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSymmetric (p.left, q.right) && isSymmetric (p.right, q.left);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return solution (nums, 0, nums.length - 1);
    }

    private TreeNode solution(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode (nums[mid]);
        root.left = solution (nums, lo, mid - 1);
        root.right = solution (nums, lo + 1, hi);
        return root;
    }

    public boolean isBalanced1(TreeNode root) {
        isBalanced (root, 0);
        return false;
    }

    public int isBalanced(TreeNode root, int level) {
        if (root == null)
            return level;
        level++;
        int leftLevel = isBalanced (root.left, level);
        int rightLevel = isBalanced (root.right, level);
        if (Math.abs (leftLevel - rightLevel) > 1) {

        }
        return level;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> lt = new LinkedList<> ();
        lt.add (root);
        int minDepth = 0;
        int size = 1;
        while (!lt.isEmpty ()) {
            TreeNode node = lt.pop ();
            size--;
            if (size == 0) {
                minDepth++;
            }
            if (node.left == null && node.right == null) {
                return minDepth;
            }
            if (node.left != null) {
                lt.add (node.left);
            }
            if (node.right != null) {
                lt.add (node.right);
            }
            if (size == 0) {
                minDepth++;
                size = lt.size ();
            }
        }
        return minDepth;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> ls = new LinkedList<> ();
        getPath (root, ls, "");
        return ls;
    }

    public void getPath(TreeNode root, List<String> ls, String path) {
        if (root == null)
            return;
        path += "->" + root.val;
        if (root.left == null && root.right == null) {
            String newPath = new String (path);
            newPath = newPath.substring (2, newPath.length ());
            ls.add (newPath);
        }
        getPath (root.left, ls, path);
        getPath (root.right, ls, path);
        path = path.substring (0, path.length () - 3);
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode> ();
        if (n == 0) {
            return ans;
        }
        TreeNode root = new TreeNode (0); //作为一个哨兵节点
        getAns (n, ans, root, 0);
        return ans;
    }

    private static void getAns(int n, List<TreeNode> ans, TreeNode root, int count) {
        if (count == n) {
            //复制当前树并且加到结果中
            //   TreeNode newRoot = treeCopy(root);
            //    ans.add(newRoot.right);
            return;
        }
        TreeNode root_copy = root;
        //尝试插入每个数
        for (int i = 1; i <= n; i++) {
            root = root_copy;
            //寻找要插入的位置
            while (root != null) {
                //在左子树中插入
                if (i < root.val) {
                    //到了最左边
                    if (root.left == null) {
                        //插入当前数字
                        root.left = new TreeNode (i);
                        //进入递归
                        getAns (n, ans, root_copy, count + 1);
                        //还原为 null，尝试插入下个数字
                        root.left = null;
                        break;
                    }
                    root = root.left;
                    //在右子树中插入
                } else if (i > root.val) {
                    //到了最右边
                    if (root.right == null) {
                        //插入当前数字
                        root.right = new TreeNode (i);
                        //进入递归
                        getAns (n, ans, root_copy, count + 1);
                        //还原为 null，尝试插入下个数字
                        root.right = null;
                        break;
                    }
                    root = root.right;
                    //如果找到了相等的数字，就结束，尝试下一个数字
                } else {
                    break;
                }
            }
        }
    }

    public int getAnswer(TreeNode root, Boolean flag) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && flag == true) {
            return root.val;
        }
        return getAnswer (root.left, true) + getAnswer (root.right, false);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            if (root.val == subRoot.val && solution (root, subRoot)) {
                return true;
            } else {
                return isSubtree (root.left, subRoot) || isSubtree (root.right, subRoot);
            }
        }

        return false;
    }

    public boolean solution(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else if (root.val != subRoot.val) {
            return false;
        }
        return solution (root.left, subRoot.left) && solution (root.right, subRoot.right);
    }

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solution2 (root, p, q);
        return ans;
    }

    public Boolean solution2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || ans != null)
            return false;
        Boolean left = solution2 (root.left, p, q);
        Boolean right = solution2 (root.right, p, q);
        if (left == right)
            ans = root;
        if (root.val == p.val || root.val == q.val && left || right) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

    public static int[] countBits(int n) {
        int ans[] = new int[n + 1];

        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String> ();
        backtrack (ans, new StringBuilder (), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length () == max * 2) {
            ans.add (cur.toString ());
            return;
        }
        if (open < max) {
            cur.append ('(');
            backtrack (ans, cur, open + 1, close, max);
            cur.deleteCharAt (cur.length () - 1);
        }
        if (close < open) {
            cur.append (')');
            backtrack (ans, cur, open, close + 1, max);
            cur.deleteCharAt (cur.length () - 1);
        }
    }

    public static void testString(String str) {
        str += "123";
    }

    List<String> ls = new ArrayList ();

    public List<String> letterCombinations(String digits) {
        if (digits.length () == 0) {
            return ls;
        }
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solution ("", strs, 0, digits);
        return ls;
    }

    public void solution(String str, String strs[], int index, String digits) {
        if (str.length () == digits.length ()) {
            ls.add (str);
            return;
        }

        String temp = strs[digits.charAt (index) - '0'];
        for (int i = 0; i < temp.length (); i++) {
            solution (str + digits.charAt (index), strs, index + 1, digits);
        }
        return;
    }


    class Solution {
        //用来记录前一个节点的值
        int pre = 0;
        //保存又可能出现的多个众数
        ArrayList<Integer> ai = new ArrayList<Integer> ();
        //记录众数的最大个数
        int max = 0;
        //记录当前节点值的出现的次数
        int count = 0;

        public int[] findMode(TreeNode root) {
            //因为root一定不为空，所以
            solution (root);
            int a[] = new int[ai.size ()];
            int j = 0;
            for (int el : ai) {
                a[j++] = el;
            }
            return a;
        }

        public void solution(TreeNode root) {
            if (root == null)
                return;
            solution (root.left);
            //如果前一个节点值和当前节点值相同
            if (pre == root.val) {
                //计数值加一
                count++;
            } else {
                //如果不相同，则当前节点的计数到此位置，开始下一个节点的计数
                pre = root.val;
                count = 1;
            }
            //如果当前节点的个数大于最大值
            if (count > max) {
                //说明众数另有一个
                max = count;
                //清空当前list
                ai.clear ();
                //将新的众数加入
                ai.add (pre);

            } else
                //如果相等的话，说明众数有多个，都要加入
                if (count == max) {
                    ai.add (pre);
                }
            solution (root.right);
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> ai = new ArrayList<> ();
//        ai.add (1);
//        ai.add (2);
//        ai.add (2);
//        ai.add (3);
//        ai.add (4);
//        ai.add (4);
//        ai.add (3);
//        String str = new String ("a");
//        String str1 = "b";
//
//        testString (str);
//        System.out.println (str);
//        TreeNode tree = TreeNode.getLeetCodeTree (ai);
        countBits (3);
        // System.out.println (new Test ().isSymmetric1 (tree));
    }
}
