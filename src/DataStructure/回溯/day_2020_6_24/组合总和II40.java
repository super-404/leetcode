package DataStructure.回溯.day_2020_6_24;

import java.util.*;

public class 组合总和II40 {
    public static void main(String[] args) {
        int nums[] = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort (nums);
        int target = 8;
        Solution solution = new Solution ();
        solution.combinationSum2 (nums, target);
    }
}

class Solution {
    Set<List<Integer>> res = new HashSet ();
    int nums[];
    int target;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        nums = candidates;
        this.target = target;
        used = new boolean[nums.length];
        Arrays.sort (nums);
        backTrack (0, new ArrayList<Integer> (), 0);
        List<List<Integer>> lli = new ArrayList (res);
        for (List<Integer> l : res) {
            System.out.println (l);
        }
        return lli;
    }

    public void backTrack(int start, List<Integer> path, int sum) {
        if (sum == target) {
            res.add (new ArrayList<Integer> (path));
        }
        for (int i = start; i < nums.length; i++) {

            path.add (nums[i]);

            backTrack (i + 1, path, sum + nums[i]);

            path.remove (path.size () - 1);
        }
    }
}
