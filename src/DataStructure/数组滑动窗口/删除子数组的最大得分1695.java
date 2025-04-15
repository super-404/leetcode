package DataStructure.数组滑动窗口;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。
 * <p>
 * 删除子数组的得分就是子数组各元素之和。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分。
 * <p>
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，
 * 那么它就是 a 的一个子数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * @author: 饶嘉伟
 * @create: 2023-12-08 21:57
 **/


public class 删除子数组的最大得分1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        HashMap hm = new HashMap<Integer, Integer> ();
        while (right < nums.length) {
            //先判断是不是有重复的
            if (hm.containsKey (nums[right])) {
                int old_left = left;
                left = Math.max (left, (int) hm.get (nums[right]) + 1);
                for (int i = old_left; i < left; i++) {
                    sum -= nums[i];
                }
            }
            hm.put (nums[right], right);
            sum += nums[right];
            res = Math.max (res, sum);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {4, 2, 4, 5, 6};
        int a1[] = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int i = new 删除子数组的最大得分1695 ().maximumUniqueSubarray (a1);
        System.out.println (i);
    }
}
