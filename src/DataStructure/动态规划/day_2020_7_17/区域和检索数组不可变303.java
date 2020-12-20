package DataStructure.动态规划.day_2020_7_17;


import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和
 * ，包含 i,  j 两点
 * <p>
 * 要走到右下角一定是向右走m-1步，向下走n-1步。也就是说总共走m-1+n-1 (m+n-2) 步，
 * 其中有m-1步是向右的。
 * 那么这就是一个组合的问题，
 * 从m+n-2步中选择m-1步向右，
 * 总共有C(m+n-2,m-1)种排列方式。C(n,m) = n!/(m!*(n-m)!)
 * @author: 饶嘉伟
 * @create: 2020-07-17 15:10
 **/
public class 区域和检索数组不可变303 {

}

class NumArray {
    int nums[];
    int dp[];

    public NumArray(int[] nums) {
        this.nums = nums;
        this.dp = new int[nums.length];
        getDP ();
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        if (nums.length == 0)
            return 0;
        if (i >= 0 && j < nums.length) {
            return dp[j] - dp[i] + nums[i];
        }
        return 0;
    }

    public void getDP() {
        if (nums.length > 0) {
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
    }
}
