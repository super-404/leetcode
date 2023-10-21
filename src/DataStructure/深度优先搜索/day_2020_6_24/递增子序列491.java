package DataStructure.深度优先搜索.day_2020_6_24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 递增子序列491 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        Solution solution = new Solution ();
        solution.findSubsequences (nums);
        for (List<Integer> l : solution.res) {
            System.out.println (l);
        }
    }
}

class Solution {
    Set<List<Integer>> res;
    int[] nums;
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        this.n = n;
        res = new HashSet<> ();
        helper (new ArrayList<Integer> (), 0);
        return new ArrayList (res);
    }

    void helper(List<Integer> cur, int start) {
        if (cur.size () >= 2) {
            res.add (new ArrayList<Integer> (cur));
        }
        for (int i = start; i < nums.length; i++) {
            if (cur.size () == 0 || cur.get (cur.size () - 1) <= nums[i]) {
                cur.add (nums[i]);
                helper (cur, i + 1);
                cur.remove ((Integer) nums[i]);
            }
        }
    }
}

