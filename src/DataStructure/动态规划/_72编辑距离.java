package DataStructure.动态规划;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
 * 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * @author: 饶嘉伟
 * @create: 2023-03-22 09:58
 **/
public class _72编辑距离 {
    public static void main(String[] args) {
        int i = new _72编辑距离 ().minDistance ("execution", "intention");
        System.out.println (i);
    }

    public int minDistance(String word1, String word2) {
        word1 = "#" + word1;
        word2 = "#" + word2;
        int len1 = word1.length ();
        int len2 = word2.length ();
        int dp[][] = new int[len1][len2];
        for (int i = 0; i < len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt (i) == word2.charAt (j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = dp[i - 1][j] + 1;

                    dp[i][j] = Math.min (dp[i][j], dp[i][j - 1] + 1);

                    dp[i][j] = Math.min (dp[i][j], dp[i - 1][j - 1] + 1);

                }
            }
        }
        for (int i = 0; i < len1; i++) {
            System.out.println (Arrays.toString (dp[i]));
        }

        return dp[len1 - 1][len2 - 1];
    }
}
