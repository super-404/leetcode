package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * <p>
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请  你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * @author: 饶嘉伟
 * @create: 2023-10-11 10:07
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort (nums);
        int k = 0;
        List res = new ArrayList<Integer> ();
        while (k < nums.length) {
            int i = k + 1;
            int j = nums.length - 1;
            // if (nums[k]>0) continue;
            if (k > 0 && nums[k] == nums[k - 1] || nums[k] > 0) {
                k++;
                continue;
            }
            while (i < j) {
                if (nums[i] + nums[j] == -nums[k]) {
                    res.add (new ArrayList<Integer> (Arrays.asList (nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (nums[i] + nums[j] > -nums[k]) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (nums[i] + nums[j] < -nums[k]) {
                    while (i < j && nums[i] == nums[++i]) ;
                }
            }
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> i = new 三数之和15 ().threeSum (new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println (i);
    }
}
