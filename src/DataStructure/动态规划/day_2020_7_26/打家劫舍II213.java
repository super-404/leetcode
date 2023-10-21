package DataStructure.动态规划.day_2020_7_26;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-26 14:59
 **/
public class 打家劫舍II213 {
    public static void main(String[] args) {
        System.out.println (new Solution ().rob (new int[]{10, 3, 2, 6, 3, 5, 4, 7, 10, 30}));
    }
}

//与前面那道题目差不多

class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max (nums[1], nums[0]);
        if (nums.length == 2)
            return dp[1];
        //这里首尾不能同时取

        //因此先判断有首无尾的情况的最大值
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max (dp[i - 2] + nums[i], dp[i - 1]);
        }

        int max1 = dp[nums.length - 2];
        System.out.println (Arrays.toString (dp));
        Arrays.fill (dp, 0);


        //因此先判断有尾无首的情况的最大值
        dp[1] = nums[1];

        dp[2] = Math.max (nums[1], nums[2]);
        if (nums.length == 3)
            return Math.max (dp[2], max1);

        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max (dp[i - 2] + nums[i], dp[i - 1]);
        }
        System.out.println (Arrays.toString (dp));
        int max2 = dp[nums.length - 1];
        //最后将两个最大值比较返回
        return Math.max (max2, max1);
    }
}
