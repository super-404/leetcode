import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-20 19:22
 **/
public class _58笔试 {

    public int[][] findIntersection(int[][] firstList, int[][] secondList) {
        // write code here
        int count[] = new int[10001];
        //Arrays.fill (count,-1);
        for (int i = 0; i < firstList.length; i++) {
            for (int j = firstList[i][0]; j < firstList[i][1]; j++) {
                count[j] += 1;
            }

        }
        for (int i = 0; i < secondList.length; i++) {
            for (int j = secondList[i][0]; j < secondList[i][1]; j++) {
                count[j] += 1;
            }
        }
        System.out.println (count);
        int len = firstList.length > secondList.length ? firstList.length : secondList.length;
        int res[][] = new int[1001][2];
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            int start = 0;
            if (count[i] == 2) {
                start = i;
            }
            int end = start;
            while (i < count.length && count[i] == 2) {

                end = i;
                i++;
            }
            if (start != 0) {
                res[k][0] = start;
                res[k][1] = end;
                System.out.println (k);
                k++;
            }
        }
        int temp[][] = new int[k][2];
        for (int i = 0; i < k; i++) {

            temp[i][0] = res[i][0];
            temp[i][1] = res[i][1];
        }
        //  System.out.println (Arrays.toString (temp));
        return temp;
    }

    @Test
    public void test() {
        int f[][] = {{0, 3}, {5, 9}, {11, 13}};
        int s[][] = {{2, 6}, {8, 10}};
        int a[][] = findIntersection (f, s);
        for (int i = 0; i < a.length; i++) {
            System.out.println (Arrays.toString (a[i]));

        }
    }

    public int StringSplit(String str) {
        // write code here
        int len = str.length ();
        int left[] = new int[len];
        for (int i = 1; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                if (str.charAt (j) == 'a') {
                    sum++;
                }
            }
            left[i] = sum;
        }
        int right[] = new int[len];
        for (int i = 1; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                if (str.charAt (j) == 'b') {
                    sum++;
                }
            }
            right[i] = sum;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            if (right[i] + left[i] > max) {
                max = right[i] + left[i];
            }
        }
        return max;
    }

    int memo[][] = new int[2001][2001];

    public int numberOfWays(int startPos, int endPos, int k) {
        // write code here\
        int steps = 0;

        int res = solutionDp (startPos, endPos, steps, k);
        System.out.println ();
        int mod = 100000007;
        return res % mod;
    }
    //int count=0;

    private int solutionDp(int startPos, int endPos, int steps, int k) {
        int d = 0;
        if (endPos > startPos) {
            d = endPos - startPos;
        } else if (startPos > endPos) {
            d = startPos - endPos;
        }

        if (d > k - steps) {
            return 0;
        }

        if (startPos < 0) {
            startPos = 1001 + startPos;
        }
        if (memo[startPos][steps] != 0) {
            return memo[startPos][k];
        }
        if (steps == k) {
            memo[startPos][steps] = 1;
            return 1;
        }
        int res = solutionDp (startPos + 1, endPos, steps + 1, k) + solutionDp (startPos - 1, endPos, steps + 1, k);
        memo[startPos][steps] = res;
        return res;
    }

    public int numberOfWays(int n, int x) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int p = (int) Math.pow (i, x);
            for (int j = n; j >= 1; j--) {
                if (j < p) {
                    dp[i][j] += dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - p];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println (Arrays.toString (dp[i]));
        }
        return dp[n][n];
    }

    public int numberOfWays1(int n, int x) {
        int[] dp = new int[n + 1];
        int MOD = (int) 1e9 + 7;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int pow = (int) Math.pow (i, x);
            //控制每个元素只用一次
            for (int j = n; j >= pow; j--) {
                dp[j] = (dp[j] + dp[j - pow]) % MOD;
            }
            System.out.println (Arrays.toString (dp));
        }
        return dp[n];
    }


    @Test
    public void testSolution3() {
        int c = numberOfWays (4, 1);
        System.out.println ("dddddddd");
        numberOfWays1 (4, 1);
        System.out.println (c);
    }

    public int maxTotalReward(int[] rewardValues) {
        rewardValues = Arrays.stream (rewardValues).distinct ().toArray ();
        int len = rewardValues.length;
        Arrays.sort (rewardValues);

        int W = rewardValues[len - 1] - 1;

        int dp[][] = new int[len][W + 1];


        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j <= W; j++) {
                if (rewardValues[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    if (j < 2 * rewardValues[i])
                        dp[i + 1][j] = Math.max (dp[i][j], dp[i][j - rewardValues[i]] + rewardValues[i]);
                    else {
                        dp[i + 1][j] = Math.max (dp[i][j], dp[i][rewardValues[i] - 1] + rewardValues[i]);
                    }
                }
            }
        }
        return dp[len - 1][W] + W + 1;
    }
}
