package 华为机考;

import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-24 19:05
 **/
public class Solution {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner (System.in);
        String line = in.nextLine ();
        String nums[] = line.split (" ");
        int a[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = Integer.parseInt (nums[i]);
        }
        Arrays.sort (a);


        int target = Integer.parseInt (in.nextLine ());
        int idx = Arrays.binarySearch (a, target);

        int left = 0;
        int right = a.length - 1;
        System.out.print ('S');

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                System.out.print ('Y');
                return;
            } else if (a[mid] > target) {
                right = mid - 1;
                if (idx < 0 && left == right) {

                } else
                    System.out.print ("L");
            } else {
                if (idx < 0 && left == right) {
                } else
                    System.out.print ("R");
                left = mid + 1;
            }
        }
        System.out.println ('N');
    }

    @Test
    public void solution2() {
        Scanner in = new Scanner (System.in);

        int nums = in.nextInt ();
        int count = in.nextInt ();
        in.nextLine ();
        String line = in.nextLine ();

        String goals[] = line.split (" ");

        Member[] ms = new Member[nums];
        for (int i = 0; i < nums; i++) {
            ms[i] = new Member ();
        }
        //统计射门次数
        //以及什么时候失射
        int get[] = new int[nums];

        for (int i = 0; i < goals.length; i++) {
            int continueNums = 0;
            for (int j = 0; j < count; j++) {
                char c = goals[i].charAt (j);
                if (c == '1') {
                    get[i]++;
                    continueNums++;
                } else {
                    ms[i].firstGG = j;
                    ms[i].continueNums = Math.max (ms[i].continueNums, continueNums);
                    continueNums = 0;
                }
            }
            ms[i].count = get[i];
            ms[i].id = i + 1;
        }

        Arrays.sort (ms, (o1, o2) -> {
            if ((o1.count - o2.count) != 0) {
                return o1.count - o2.count;
            } else {
                if ((o1.continueNums - o2.continueNums) != 0) {
                    return (o1.continueNums - o2.continueNums);
                } else {
                    if ((o1.firstGG - o2.firstGG) != 0) {
                        return (o1.firstGG - o2.firstGG);
                    } else {
                        if ((o1.id - o2.id) != 0) {
                            return o2.id - o1.id;
                        }
                    }
                }
            }
            return 0;
        });
        for (int i = 0; i < ms.length; i++) {
            System.out.print (ms[i].id);
        }
    }

    static class Member {
        int id;
        int count;
        int firstGG;
        int continueNums;

    }

    public void solution1() {
        Scanner in = new Scanner (System.in);

        int i = 0;
        ArrayList<Integer> ai = new ArrayList<> ();
        while (in.hasNext ()) {
            int a = in.nextInt ();
            ai.add (a);
            i++;
        }
        //ai.sort((o1,o2)->{return o1-o2;});
        in.nextLine ();
        int target = in.nextInt ();
        int a[] = new int[ai.size ()];
        for (int j = 0; j < ai.size (); j++) {
            a[j] = ai.get (j);
        }
        TreeNode tn = new TreeNode ();
        tn.buildTree (tn, ai);

    }

    @Test
    public void testSolution1() {

    }
}


/**
 * @program: leetcode
 * @description: 树的一般性定义
 * @author: 饶嘉伟
 * @create: 2020-10-12 18:24
 **/
class TreeNode {
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

    public static DataStructure.树.TreeNode getTree(ArrayList<Integer> list) {
        LinkedList<DataStructure.树.TreeNode> qt = new LinkedList<> ();
        DataStructure.树.TreeNode q = new DataStructure.树.TreeNode ();
        DataStructure.树.TreeNode root = new DataStructure.树.TreeNode (list.get (0));
        qt.add (root);
        int i = 1;
        while (i < list.size ()) {
            DataStructure.树.TreeNode p = qt.poll ();
            if (i < list.size ()) {
                p.left = new DataStructure.树.TreeNode (list.get (i++));
                qt.add (p.left);
            }
            if (i < list.size ()) {
                p.right = new DataStructure.树.TreeNode (list.get (i++));
                qt.add (p.right);
            }
        }
        return root;
    }

    public static DataStructure.树.TreeNode getLeetCodeTree(Integer[] list) {
        //Integer DataStructure.a[][]={{1,3,-100,-100,2},{}};
        ArrayList<Integer> ai = new ArrayList<> ();
        Collections.addAll (ai, list);
        DataStructure.树.TreeNode root = DataStructure.树.TreeNode.getLeetCodeTree (ai);
        return root;
    }

    public static DataStructure.树.TreeNode getLeetCodeTree(ArrayList<Integer> list) {
        LinkedList<DataStructure.树.TreeNode> qt = new LinkedList<> ();
        DataStructure.树.TreeNode q = new DataStructure.树.TreeNode ();
        DataStructure.树.TreeNode root = new DataStructure.树.TreeNode (list.get (0));
        qt.add (root);
        int i = 1;
        while (i < list.size ()) {
            DataStructure.树.TreeNode p = qt.poll ();
            if (i < list.size ()) {
                Integer v = list.get (i);
                if (v != -100) {
                    p.left = new DataStructure.树.TreeNode (list.get (i));
                    qt.add (p.left);
                }
                i++;
            }
            if (i < list.size ()) {
                Integer v = list.get (i);
                if (v != -100) {
                    p.right = new DataStructure.树.TreeNode (list.get (i));
                    qt.add (p.right);
                }
                i++;
            }
        }
        return root;
    }

    //
    public static void preprint(DataStructure.树.TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println (treeNode.val);
            preprint (treeNode.left);
            preprint (treeNode.right);
        }
    }

}

