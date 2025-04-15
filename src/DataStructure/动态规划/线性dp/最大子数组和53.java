package DataStructure.动态规划.线性dp;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 nums，
 * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * <p>
 * 子数组
 * 是数组中的一个连续部分。
 * @author: 饶嘉伟
 * @create: 2024-04-08 09:27
 **/
public class 最大子数组和53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (res < 0)
                res = nums[i];
            else {
                res += nums[i];
                max = max > res ? max : res;
            }
        }
        return max;
    }
}
