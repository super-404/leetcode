package DataStructure.动态规划.day_2020_7_28;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * <p>
 * 你需要让组成和的完全平方数的个数最少。
 * @author: 饶嘉伟
 * @create: 2020-07-28 14:37
 **/
public class 完全平方数279 {
    public static void main(String[] args) {
        System.out.println (new Solution ().numSquares (21));
    }
}

class Solution {
    int count = 0;
    int min = Integer.MAX_VALUE;

    public int numSquares(int n) {
        int num = (int) Math.sqrt (n);
        int query[] = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            query[i] = i * i;
        }
        int dp[] = new int[n + 1];
        Arrays.fill (dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= num; j++) {
                if (j * j <= i) {
                    dp[i] = Math.min (dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
        // backTrack (num,query,n);
        // return min;
    }

    //傻逼解法
    public void backTrack(int start, int query[], int sum) {
        boolean flag = false;
        if (sum < 0 || count > min) {
            return;
        }
        if (sum == 0) {
            flag = true;
            min = Math.min (min, count);
        }
        for (int i = start; i >= 1; i--) {
            count++;
            backTrack (i, query, sum - query[i]);
            count--;
            if (flag)
                return;
        }
    }

    public int numSquaresHelper(int n) {
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        //依次减去一个平方数
        for (int i = 1; i * i <= n; i++) {
            //选最小的
            count = Math.min (count, numSquaresHelper (n - i * i) + 1);
        }
        return count;
    }

    //记忆化的搜索
    private int numSquaresHelper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey (n)) {
            return map.get (n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min (count, numSquaresHelper (n - i * i, map) + 1);
        }
        map.put (n, count);
        return count;
    }

}


