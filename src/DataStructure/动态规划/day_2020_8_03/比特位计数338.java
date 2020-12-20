package DataStructure.动态规划.day_2020_8_03;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @author: 饶嘉伟
 * @create: 2020-08-03 15:39
 **/
public class 比特位计数338 {
    public static void main(String[] args) {
        new Solution ().countBits (14);
    }
}

class Solution {
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        popcount (num);
        dp[0] = 1;
        int count = 1;
        int power = 1;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[power] + dp[i - power];
            count--;
            if (count == 0) {
                power *= 2;
                count = power;
            }
        }
        dp[0] = 0;
        System.out.println (Arrays.toString (dp));
        return dp;
    }

    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
            x &= x - 1; //zeroing out the least significant nonzero bit
        //把最末尾的1，变成0，
        return count;
    }


}
