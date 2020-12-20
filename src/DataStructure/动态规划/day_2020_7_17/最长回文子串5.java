package DataStructure.动态规划.day_2020_7_17;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author: 饶嘉伟
 * @create: 2020-07-17 15:48
 **/
public class 最长回文子串5 {
    public static void main(String[] args) {
        System.out.println (new Solution2 ().longestPalindrome ("babab"));
    }
}

class Solution1 {
    String s;

    public String longestPalindrome(String s) {
        this.s = s;
        if (s.length () == 0)
            return "";
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int a[];
        int b[];
        for (int i = 0; i < s.length (); i++) {
            a = checkEven (i);
            b = checkOld (i);
            int length1 = a[1] - a[0];
            int length2 = b[1] - b[0];
            if (length1 > max) {
                start = a[0];
                end = a[1];
                max = length1;
            }
            if (length2 > max) {
                start = b[0];
                end = b[1];
                max = length2;
            }
        }
        return s.substring (start, end + 1);
    }

    //偶数长度的回文串
    public int[] checkOld(int start) {
        int i = start;
        int j = start + 1;
        char a;
        char b;
        if (j < s.length ()) {
            a = s.charAt (i);
            b = s.charAt (j);
            if (a != b) {
                return new int[]{i, j - 1};
            }
        }
        while (i >= 0 && j < s.length ()) {
            a = s.charAt (i);
            b = s.charAt (j);
            if (a == b) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j - 1};
    }

    //奇数长度的回文串
    public int[] checkEven(int start) {
        int i = start - 1;
        int j = start + 1;
        while (i >= 0 && j < s.length ()) {
            char a = s.charAt (i);
            char b = s.charAt (j);
            if (a == b) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j - 1};
    }
}

class Solution2 {
    String s;

    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length ()][s.length ()];
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < s.length (); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt (i) != s.charAt (j)) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else
                        dp[j][i] = dp[j + 1][i - 1];
                }
                if (dp[j][i] && (i - j > maxLength)) {
                    maxLength = i - j;
                    start = j;
                    end = i;
                }
            }
        }
        for (int i = 0; i < s.length (); i++) {
            for (int k = 0; k < i; k++) {
                System.out.print ("      ");
            }
            for (int j = i; j < s.length (); j++) {
                System.out.print (dp[i][j] + " ");
            }
            System.out.println ();
        }
        return s.substring (start, end + 1);
    }
}
