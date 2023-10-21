package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2022-10-09 23:30
 **/
public class 正则表达式匹配10 {
    public static void main(String[] args) {
        System.out.println (new Solution10 ().isMatch ("a", ".a"));
    }
}

class Solution10 {
    public boolean isMatch(String s, String p) {
        int n = s.length ();
        int m = p.length ();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        //特殊处理第一行
        for (int i = 1; i < p.length (); i++) {
            if (p.charAt (i) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < s.length (); i++) {
            for (int j = 1; j < p.length (); j++) {
                if (p.charAt (j) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt (j) == s.charAt (i) || p.charAt (j) == '.');
                } else {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt (j - 1) == s.charAt (i) || p.charAt (j - 1) == '.'));
                }
            }
        }
        return dp[n][m];
    }
}
