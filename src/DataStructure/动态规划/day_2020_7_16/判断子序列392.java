package DataStructure.动态规划.day_2020_7_16;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串.
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-16 15:10
 **/
/*

示例 1:
s = "abc", t = "ahbgdc"
返回 true

 */
public class 判断子序列392 {
    public static void main(String[] args) {
        System.out.println (new Solution2 ().isSubsequence ("df", "abcdefg"));
        ;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int k = 0;
        boolean flag = false;
        for (int i = 0; i < s.length (); i++) {
            char goal = s.charAt (i);
            int temp = k;
            for (int j = k; j < t.length (); j++) {
                if (goal == t.charAt (j)) {
                    flag = true;
                    k = j + 1;
                    break;
                }
            }
            if (temp == k) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}

class Solution2 {
    public boolean isSubsequence(String s, String t) {
        // 预处理
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length ();
        int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch] = p;
                if (t.charAt (i) == ch + 'a') p = i;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println (Arrays.toString (dp[i]));
        }
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray ()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }
}

