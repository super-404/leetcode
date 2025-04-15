package DataStructure.动态规划.背包问题;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-27 13:45
 **/
public class 数位成本和为目标值的最大数字1449 {

    public String largestNumber(int[] cost, int target) {
        int len = cost.length;
        String dp[] = new String[target + 1];

        for (int i = 0; i <= target; i++) {
            dp[i] = "";
        }
        boolean efective[] = new boolean[target + 1];
        efective[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= cost[i]) {
                    if (efective[j - cost[i]]) {
                        dp[j] = compareString (dp[j], getMaxString (dp[j - cost[i]], String.valueOf (i + 1).charAt (0)));
                        efective[j] = true;
                    }
                }
            }
        }
        return dp[target];
    }

    public String compareString(String a, String b) {

        int i = 0;
        if (a.length () > b.length ()) {
            return a;
        } else if (a.length () < b.length ()) {
            return b;
        }
        for (; i < a.length () && i < b.length (); i++) {
            if (a.charAt (i) == b.charAt (i)) {
                continue;
            } else if (a.charAt (i) < b.charAt (i)) {
                return b;
            } else {
                return a;
            }
        }
        if (i < a.length ()) {
            return a;
        } else {
            return b;
        }
    }

    public String getMaxString(String str, char c) {

        for (int i = 0; i < str.length (); i++) {
            if (str.charAt (i) < c) {
                return str.substring (0, i) + c + str.substring (i, str.length ());
            }
        }
        return str + c;
    }

    @Test
    public void test() {
        String str = "111";
        char c = '1';
        String ans = getMaxString (str, c);
        //System.out.println (ans);
        int cost[] = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        System.out.println (largestNumber (cost, 9));
    }
}
