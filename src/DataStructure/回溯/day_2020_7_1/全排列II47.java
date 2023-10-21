package DataStructure.回溯.day_2020_7_1;

/**
 * @program: leetcode
 * @description: 保存数组中所有的排列
 * @author: 饶嘉伟
 * @create: 2020-07-01 14:11
 **/

import java.lang.reflect.Array;
import java.util.*;

public class 全排列II47 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 4};
        for (List<Integer> li : new Solution ().lexicographicalOrder (nums))
            System.out.println (li);
    }
}

class Solution {
    int goal[];
    Set<List<Integer>> lli = new HashSet<> ();
    boolean used[];

    public List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);
        goal = nums;
        used = new boolean[nums.length];
        backTrack (0, new ArrayList<Integer> ());
        return new ArrayList<> (lli);
    }

    public void backTrack(int start, List path) {
        if (path.size () == goal.length) {
            lli.add (new ArrayList (path));
            return;
        }
        for (int i = 0; i < goal.length; i++) {
            if (!used[i]) {
                if (i > 0 && goal[i] == goal[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add (goal[i]);
                used[i] = true;
                backTrack (i + 1, path);
                path.remove (path.size () - 1);
                used[i] = false;
            }
        }
    }


    public List<List<Integer>> lexicographicalOrder(int nums[]) {
        Arrays.sort (nums);
        int count = 0;
        while (true) {
            //ArrayList<Integer> ai=new ArrayList<> ();
            int n = nums.length - 2;
            for (; n >= 0; n--) {
                if (nums[n] < nums[n + 1]) {
                    break;
                }
            }
            if (n < 0) {
                break;
            }
            int min = 23445;
            int m = nums.length - 1;
            for (int i = n + 1; i < nums.length; i++) {

                if (nums[n] < nums[i]) {
                    if (nums[i] < min)
                        min = nums[i];
                    m = i;
                }
            }
            swap (nums, n, m);
            count++;
            reverse (nums, nums.length - 1, n + 1);
        }
        return new ArrayList<> (lli);
    }

    public static void swap(int nums[], int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    public static void reverse(int nums[], int n, int m) {
        while (n > m) {
            int temp = nums[n];
            nums[n] = nums[m];
            nums[m] = temp;
            n--;
            m++;

        }
    }
}
