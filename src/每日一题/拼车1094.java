package 每日一题;

import DataStructure.树.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-21 10:47
 **/
public class 拼车1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        //  Arrays.sort (trips, Comparator.comparingInt (a -> a[0]));
        int count[] = new int[1001];
        int p = 0;
        for (int i = 0; i < trips.length; i++) {
            p += trips[i][0];
            for (int j = trips[i][1]; j <= trips[i][2]; j++) {
                count[j] += trips[i][0];
            }
        }
        //Arrays.sort(trips)
        // if(p>capacity){
        //     return false;
        // }
        boolean flag = true;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && !flag || count[i] > capacity) {
                return false;
            }

            if (count[i] != 0) {
                flag = false;
            }
            while (count[i] != 0) {
                i++;
            }
        }
        return true;
    }

    public int minGroups(int[][] intervals) {
        int diff[] = new int[1000001];
        int count = 1;
        for (int i = 0; i < intervals.length; i++) {
            diff[intervals[i][0]] += 1;
            diff[intervals[i][1] + 1] -= 1;
        }
        long max = Integer.MIN_VALUE;
        long total = 0;
        for (int i = 0; i < diff.length; i++) {
            total += diff[i];
            if (max < total) {
                total = max;
            }
        }
        return (int) max;
    }

    @Test
    public void testMinGroups() {
        int a[][] = {{1, 2}};
        minGroups (a);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length ();
        int diff[] = new int[len];
        for (int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] == 0) {
                diff[shifts[i][0]] += 1;
                diff[shifts[i][1] + 1] -= 1;
            }
            if (shifts[i][2] == 1) {
                diff[shifts[i][0]] -= 1;
                diff[shifts[i][1] + 1] += 1;
            }
        }
        int total = 0;
        String res = "";
        for (int i = 0; i < len; i++) {
            total += diff[i];
            res += (char) ((s.charAt (i) - 'a' - total + 26) % 26 + 'a');
        }
        return res;
    }

    public int sumNumbers(TreeNode root) {
        return solution (root, "");
    }

    public int solution(TreeNode root, String num) {
        if (root == null) {
            return 0;
        }
        String temp = num;
        num += String.valueOf (root.val);
        if (root.left == null && root.right == null) {
            return Integer.parseInt (num);
        }
        int l = solution (root.left, num);
        int r = solution (root.right, num);
        return l + r;
    }

    //    public void solution(TreeNode root,int depth){
//        if(root==null)
//            return ;
//        if(depth-1 == li.size()){
//            li.add(root.val);
//        }
//        solution(root.right,depth+1);
//        solution(root.left,depth+1);
//    }
    public void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> li = new ArrayList<> ();
        Queue<TreeNode> qi = new LinkedList<> ();
        qi.add (root);
//        int depth = 0;
        int size = 0;
        int curSize = 1;
        while (!qi.isEmpty ()) {
            TreeNode t = qi.poll ();
            curSize--;
            if (curSize == 0) {
                li.add (t.val);
                curSize = size;
                size = 0;
            }
            if (t.right != null) {
                qi.add (t.right);
                size++;
            }
            if (t.left != null) {
                qi.add (t.left);
                size++;
            }

        }
    }

}
