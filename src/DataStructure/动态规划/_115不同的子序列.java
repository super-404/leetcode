package DataStructure.动态规划;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * @author: 饶嘉伟
 * @create: 2023-03-24 00:13
 **/
public class _115不同的子序列 {
    public static void main(String[] args) {
        System.out.println (new _115不同的子序列 ().numDistinct ("anacondastreetracecar", "contra"));
    }

    public int numDistinct(String s, String t) {

        int dp[][] = new int[s.length ()][t.length ()];
        //用来记录最后的答案，只在t的最后一个字符的时候记录
        int ans = 0;

        for (int i = 0, count = 0; i < s.length (); i++) {
            if (s.charAt (i) == t.charAt (0)) {
                dp[i][0] = ++count;

                if (t.length () == 1) {
                    //又可能t只有一个字符，需要记录答案
                    ans = dp[i][0];
                }
            }
        }
        for (int j = 1; j < t.length (); j++) {
            int sum = 0;
            for (int i = j; i < s.length (); i++) {
                if (s.charAt (i) == t.charAt (j)) {
                    for (int k = i - 1; k >= 0; k--) {

                        if (dp[k][j - 1] != 0) {
                            sum += dp[k][j - 1];
                            break;
                        }
                    }
                    dp[i][j] = sum;
                    if (j == t.length () - 1)
                        ans = dp[i][j];
                }
            }
        }
//        for (int i = 0; i <s.length () ; i++) {
//            System.out.println (Arrays.toString (dp[i]));
//        }

        return ans;
    }
}
