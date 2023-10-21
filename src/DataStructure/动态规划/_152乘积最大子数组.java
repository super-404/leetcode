package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位整数。  子数组是数组的连续子序列。
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * @author: 饶嘉伟
 * @create: 2023-03-23 23:15
 **/
public class _152乘积最大子数组 {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        //0 代表最小值，
        //1 代表最大值
        // 因为最小值乘以负数又可能是最大值
        // 最大值乘以负数有可能是最小值
        if (nums.length == 1)
            return nums[0];
        int dp[][] = new int[nums.length][2];
        int max = Integer.MIN_VALUE;
        //较小的那个
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.min (Math.min (dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.max (Math.max (dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            max = Math.max (dp[i][1], max);
        }
        return max;
    }
}
