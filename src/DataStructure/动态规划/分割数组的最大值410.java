package DataStructure.动态规划;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-23 14:51
 **/
public class 分割数组的最大值410 {

    public int splitArray(int[] nums, int k) {
        int len = nums.length;

        int dp[][] = new int[len + 1][k + 1];
        //前缀和计算
        int prefix[] = new int[len + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        for (int i = 1; i < prefix.length; i++) {
            dp[i][1] = prefix[i];
        }
        //第一步考虑好，要切分几下
        //
        ArrayList<Integer> al = new ArrayList ();
        for (int j = 2; j < dp[0].length; j++) {
            for (int i = 2; i < dp.length; i++) {
                for (int l = j - 1; l < i; l++) {
                    dp[i][j] = Math.max (dp[l][j - 1], (prefix[i] - prefix[l]));
                    al.add (dp[i][j]);
                }
                if (al.isEmpty ()) {
                    continue;
                }
                dp[i][j] = al.stream ().min ((o1, o2) -> {
                    return o1 - o2;
                }).get ();
                al.clear ();
            }
        }
        return dp[len][k];
    }

    @Test
    public void test() {
        int a[] = {7, 2, 5, 10, 8};
        int res = splitArray (a, 3);
        System.out.println (res);
    }
}
