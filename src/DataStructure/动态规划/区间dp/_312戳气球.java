package DataStructure.动态规划.区间dp;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-05-19 14:25
 **/
public class _312戳气球 {
    public static void main(String[] args) {
        new Solution ().maxCoins (new int[]{3, 1, 5, 8});
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) arr[i] = nums[i - 1];
        int[][] f = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int l = 0; l + len - 1 <= n + 1; l++) {
                int r = l + len - 1;
                for (int k = l + 1; k <= r - 1; k++) {
                    f[l][r] = Math.max (f[l][r], f[l][k] + f[k][r] + arr[l] * arr[k] * arr[r]);
                }
            }
        }
        return f[0][n + 1];
    }
}
