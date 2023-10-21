import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author: 饶嘉伟
 * @create: 2022-10-10 22:23
 **/
public class 最长回文子串5 {

    public static void main(String[] args) {
        System.out.println (new Solution5 ().longestPalindrome ("acbcc"));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        if (s.length () == 1)
            return s;
        ArrayList<Integer> dp[] = new ArrayList[s.length ()];
        dp[0] = new ArrayList<> ();
        dp[0].add (1);
        for (int i = 1; i < s.length (); i++) {
            dp[i] = new ArrayList<> ();
            int even = 0;//奇数
            int odd = 0;//偶数
            for (int t : dp[i - 1]) {
                if (i - t >= 0 && s.charAt (i) == s.charAt (i - t) && (dp[i - 1].contains (t - 1) || t == 1)) {
                    odd = t + 1;
                    dp[i].add (odd);
                    if (odd > max) {
                        start = i - t;
                        end = i;
                        max = odd;
                    }
                }
                if (i - t - 1 >= 0 && s.charAt (i) == s.charAt (i - t - 1)) {
                    even = t + 2;
                    dp[i].add (even);
                    if (even > max) {
                        start = i - t - 1;
                        end = i;
                        max = even;
                    }
                }
            }
            dp[i].add (1);
        }
        System.out.println (start);
        System.out.println (end);
        for (ArrayList al :
                dp) {
            System.out.print (al.toString ());
            System.out.println (" ");
        }
        return s.substring (start, end + 1);
    }
}
