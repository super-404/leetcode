package DataStructure.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-19 09:04
 **/
public class 分割回文串II132 {
    public int minCut(String s) {
        int len = s.length ();
        boolean g[][] = new boolean[len][len];
        g[0][0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    g[i][j] = true;
                } else {
                    boolean b = s.charAt (i) == s.charAt (j);
                    if (j - i <= 2 && b) {
                        g[i][j] = true;
                    } else if (j < len - 1 && i > 0 && g[i - 1][j + 1] && b) {
                        g[i][j] = true;
                    }
                }
            }
        }
        int dp[] = new int[len];
        Arrays.fill (dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (g[0][i]) {
                dp[i] = 0;
            } else
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i])
                        dp[i] = Math.min (dp[i], dp[j] + 1);
                }
        }
        return dp[len - 1];
    }

    @Test
    public void test() {
        String str = "aab";
        System.out.println (minCut (str));
    }
}
