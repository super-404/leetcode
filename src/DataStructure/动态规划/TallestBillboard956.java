package DataStructure.动态规划;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-24 21:17
 **/
public class TallestBillboard956 {

    public int tallestBillboard(int[] rods) {
//        Arrays.sort(rods);
//        if()

        int dp[] = new int[5001];
        for (int i = 0; i < rods.length; i++) {
            int curDp[] = Arrays.copyOf (dp, dp.length);
            for (int d = 0; d + rods[i] <= 5000; d++) {
                dp[d + rods[i]] = Math.max (dp[d + rods[i]], curDp[d]);
                int abs = Math.abs (d - rods[i]);
                dp[abs] = Math.max (dp[abs], curDp[d] + Math.min (d, rods[i]));
            }
        }
        return dp[0];
    }
}
