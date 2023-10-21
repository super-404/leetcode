package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2022-10-07 22:34
 **/
public class 最长有效括号32 {
    public static void main(String[] args) {
        System.out.println (new Solution ().longestValidParentheses ("(()"));
    }
}

class Solution3 {
    int max = 0;

    // String maxStr=""
    public int longestValidParentheses(String s) {
        if (s.length () == 0)
            return max;
        int temp = 0;
        for (int i = 0; i < s.length (); i++) {
            int maxin = 0;
            for (int j = i + 1; j <= s.length (); j++) {

                if (isValidParentheses (s.substring (i, j))) {
                    if (i == temp) {
                        maxin += j - i;
                    } else {
                        if (maxin < j - i)
                            maxin = j - i;
                    }
                    i = j;
                    temp = i;
                }
            }
            if (maxin > max)
                max = maxin;
        }
        return max;
    }

    public boolean isValidParentheses(String s) {

        int left = 0;
        if (s.charAt (0) == ')')
            return false;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == '(')
                left++;
            else if (s.charAt (i) == ')' && left > 0)
                left--;
            else
                return false;
        }
        if (left > 0)
            return false;
        else
            return true;
    }
}

class Solution {
    int max = 0;

    // String maxStr=""
    public int longestValidParentheses(String s) {
        if (s.length () == 0)
            return max;
        int left = 0;
        int start = 0;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == '(')
                left++;
            else if (s.charAt (i) == ')' && left > 0)
                left--;
            else if (max < i - start) {
                max = i - start;
                start = i;
            }
        }
        return max;
    }

    public boolean isValidParentheses(String s) {

        int left = 0;
        if (s.charAt (0) == ')')
            return false;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == '(')
                left++;
            else if (s.charAt (i) == ')' && left > 0)
                left--;
            else
                return false;
        }
        if (left > 0)
            return false;
        else
            return true;
    }
}

class Solution32 {
    int max = 0;

    // String maxStr=""
    public int longestValidParentheses(String s) {
        if (s.length () == 0)
            return max;
        int left = 0;
        int start = 0;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == '(')
                left++;
            else if (s.charAt (i) == ')' && left > 0)
                left--;
            else if (max < i - start) {
                max = i - start;
                start = i;
            }
        }
        return max;
    }

    public boolean isValidParentheses(String s) {

        int left = 0;
        if (s.charAt (0) == ')')
            return false;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == '(')
                left++;
            else if (s.charAt (i) == ')' && left > 0)
                left--;
            else
                return false;
        }
        if (left > 0)
            return false;
        else
            return true;
    }
}
