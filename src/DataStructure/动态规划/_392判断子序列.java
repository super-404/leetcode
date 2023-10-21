package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * @author: 饶嘉伟
 * @create: 2023-03-10 10:54
 **/
public class _392判断子序列 {
    public static void main(String[] args) {
        isSubsequence ("abc", "ahbgdc");
    }

    public static boolean isSubsequence(String s, String t) {
        int len = s.length ();
        if (len == 0)
            return true;
        //  boolean[] ans = new boolean[len];
        int j = 0;
        for (int i = 0; i < t.length () && j < s.length (); i++) {
            if (t.charAt (i) == s.charAt (j)) {
                j++;
            }
        }
        return j == s.length ();
    }
}
