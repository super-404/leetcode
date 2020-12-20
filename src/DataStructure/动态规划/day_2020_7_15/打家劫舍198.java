package DataStructure.动态规划.day_2020_7_15;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 * @author: 饶嘉伟
 * @create: 2020-07-15 16:18
 **/
/*
示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 打家劫舍198 {
    public static void main(String[] args) {
        int a = new Solution ().rob (new int[]{2, 7, 9, 3, 1});
        System.out.println (a);
    }
}

class Solution {
    int nums[];
    int max = 0;
    int dp[];

    public int rob(int[] nums) {
        this.nums = nums;
        int i = 0;
        dp = new int[nums.length];
        Arrays.fill (dp, -1);
        backTrack (0);
        System.out.println (Arrays.toString (dp));
        return max;
    }

    public int backTrack(int start) {
        if (start >= nums.length)
            return 0;
//        if(dp[start]!=-1){
//            return dp[start];
//        }
        int sum = 0;
        for (int i = start; i < nums.length; i++) {
            sum = Math.max (sum, nums[i] + backTrack (i + 2));
        }
        System.out.println ("start值：" + start);
        System.out.println ("sum值：" + sum);
        // dp[start] = sum;
        return sum;
    }
}

class Solution1 {
    int nums[];
    int max = 0;
    int dp[];

    public int rob(int[] nums) {
        dp = Arrays.copyOf (nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 2; j < nums.length; j++) {
                sum = sum + nums[j];
                if (dp[j] > sum) {
                    break;
                } else {
                    dp[j] = sum;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            max = Math.max (max, dp[i]);
        }
        return max;
    }

    public void backTrack(int start, int sum) {
        if (sum > max) {
            max = sum;
        }
        if (start >= 2 && dp[start - 2] < sum) {
            dp[start - 2] = sum;
        }
        for (int i = start; i < nums.length; i++) {
            if (dp[i] > sum + nums[i])
                return;
            backTrack (i + 2, sum + nums[i]);
        }
    }
}

class Solution2 {
    int nums[];
    int max = 0;
    int dp[];

    public int rob(int[] nums) {
        dp = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max (nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max (nums[i] + dp[i - 2], dp[i - 1]);
        }
        for (int i = 0; i < dp.length; i++) {
            max = Math.max (max, dp[i]);
        }
        return max;
    }
}
