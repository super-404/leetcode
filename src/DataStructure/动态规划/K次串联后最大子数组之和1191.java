package DataStructure.动态规划;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。
 * <p>
 * 例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。
 * <p>
 * 返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 * <p>
 * 由于 结果可能会很大，需要返回的 109 + 7 的 模 。
 * @author: 饶嘉伟
 * @create: 2024-09-25 08:58
 **/
public class K次串联后最大子数组之和1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        int newArray[] = new int[2 * arr.length];
        int temp[] = Arrays.copyOf (arr, len);
        ;
        for (int i = 0; i < 2 * len; i++) {
            newArray[i] = arr[i % len];
        }
        int max = 0;
        int sum2k = 0;
        for (int i = 0; i < newArray.length; i++) {
            sum2k = Math.max (sum2k + newArray[i], 0);
            max = Math.max (sum2k, max);
        }
        for (int i = 0; i < newArray.length; i++) {
            sum2k = Math.max (sum2k + newArray[i], 0);
            max = Math.max (sum2k, max);
        }
        if (sum < 0) {
            return max;
        } else {
            return max + sum * (k - 2);
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max (right, piles[i]);
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            ;
            long res = check (piles, mid, h);
            if (res == 0) {
                return mid;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long check(int[] piles, int mid, int h) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += (piles[i] - 1) / mid + 1;
        }
        return sum - h;
        // if(sum==h){
        //     return 0;
        // }else if (sum>h) {
        //     return 1;
        // }else{

        // }
    }

    @Test
    public void test() {
        int a[] = {1, 1, 1, 999999999};
        System.out.println (minEatingSpeed (a, 10));
    }

    public int maxProfit(int[] prices) {
        getMaxProfit (prices, 0, 0, false);
        return 0;
    }

    private void getMaxProfit(int[] prices, int start, int profit, boolean b) {
        if (profit < 0) {
            return;
        }

        getMaxProfit (prices, start + 1, profit - prices[start], false);
        getMaxProfit (prices, start + 1, profit - prices[start], false);
        getMaxProfit (prices, start + 1, profit + prices[start], true);

    }

    private int[] prices;

    private int[][] memo;


    public int maxProfit2(int[] prices) {

        this.prices = prices;

        int n = prices.length;

        memo = new int[n][2];

        for (int[] row : memo) {

            Arrays.fill (row, -1); // -1 表示还没有计算过

        }

        return dfs (n - 1, 0);

    }


    private int dfs(int i, int hold) {

        if (i < 0) {

            return hold == 1 ? Integer.MIN_VALUE : 0;

        }

        if (memo[i][hold] != -1) {

            return memo[i][hold]; // 之前计算过

        }

        if (hold == 1) {

            return memo[i][hold] = Math.max (dfs (i - 1, 1), dfs (i - 1, 0) - prices[i]);

        }

        return memo[i][hold] = Math.max (dfs (i - 1, 0), dfs (i - 1, 1) + prices[i]);

    }

    @Test
    public void testMaxProfit2() {
        int a[] = {7, 1, 5, 3, 6, 4};
        maxProfit2 (a);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m][n];
        int len = strs.length;
        int countZero[] = new int[len];
        int countOne[] = new int[len];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length (); j++) {
                if (str.charAt (j) == '0') {
                    countZero[i]++;
                } else {
                    countOne[i]++;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= countZero[i]; j++) {
                for (int l = n; l >= countOne[i]; l--) {
                    dp[j][l] = Math.max (dp[j][l], dp[j - countZero[i]][l - countOne[i]] + 1);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int differenceOfSum(int[] nums) {
        int sum = Arrays.stream (nums).sum ();
        int mod = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];

            while (t > 0) {
                int temp = t % 10;
                mod += temp;
                t = t / 10;
            }

        }
        return Math.abs (sum - mod);

    }

    public int lastStoneWeightII(int[] stones) {
        //List<Integer> ai = new ArrayList<> ();
        //System.out.println ();
        int len = stones.length;
        Arrays.stream (stones).min ().getAsInt ();
        int sum = Arrays.stream (stones).sum ();
        int dp[] = new int[(sum / 2) + 1];
        for (int i = 0; i < len; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max (dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[sum / 2];
    }

    public int takeCharacters(String s, int k) {
        int len = s.length ();
        if (3 * k > len) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int a[] = new int[3];
        int b[] = new int[3];
        for (int i = 0; i < len; i++) {
            char c = s.charAt (i);
            b[c - 'a']++;
        }
        while (left <= right && right < len) {
            char c = s.charAt (right);
            a[c - 'a']++;
            while (left <= right && (b[0] - a[0] < k || b[1] - a[1] < k || b[2] - a[2] < k)) {
                c = s.charAt (left);
                a[c - 'a']--;
                left++;
            }
            max = Math.max (max, right - left + 1);
            right++;
        }
        return max;
    }

    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        int sum = Arrays.stream (rods).sum ();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 5000; i++) {
            if (isTarget (rods, i)) {
                int temp = (sum - i) / 2;
                max = Math.max (max, temp);
            }
            ;
        }
        return max;
    }

    public boolean isTarget(int[] rods, int t) {
        boolean dp[] = new boolean[t + 1];
        dp[0] = true;
        for (int i = 0; i < rods.length; i++) {
            for (int j = t; j >= rods[i]; j--) {
                dp[j] = dp[j] || dp[j - rods[i]];
            }
        }
        return dp[t];
    }

    @Test
    public void testSolution() {
        int roads[] = {1, 2, 3, 6};
        //int k = 2;
        tallestBillboard (roads);
    }


}
