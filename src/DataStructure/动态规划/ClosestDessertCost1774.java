package DataStructure.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-24 15:10
 **/
public class ClosestDessertCost1774 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int max = Integer.MAX_VALUE;
        int min = Arrays.stream (toppingCosts).min ().getAsInt ();
        for (int i = 0; i < baseCosts.length; i++) {
            int ans = 0;
            if (target >= baseCosts[i]) {
                ans = solution1 (toppingCosts, target - baseCosts[i]) + baseCosts[i];
                System.out.println ("ans ================" + ans);
                //当前的ans可能不是最优解；
                // ans = baseCosts[i]+min;


                if (ans < target) {
                    int abs = Math.abs (ans + min - target);
                    if (Math.abs (max - target) > abs) {
                        max = ans + min;
                    }
                    if (Math.abs (max - target) == abs) {
                        if (max > ans) {
                            max = ans;
                        }
                    }
                }
            } else {
                ans = baseCosts[i];

            }
            if (Math.abs (max - target) > Math.abs (ans - target)) {
                max = ans;
            }
            if (Math.abs (max - target) == Math.abs (ans - target)) {
                if (max > ans) {
                    max = ans;
                }
            }
        }
        System.out.println (max);
        return max;
    }

    public int solution1(int[] toppingCosts, int target) {
        int dp[] = new int[target + 1];
        for (int i = 0; i < toppingCosts.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= toppingCosts[i]) {
                    dp[j] = Math.max (dp[j], dp[j - toppingCosts[i]] + toppingCosts[i]);
                }

                if (j >= 2 * toppingCosts[i]) {
                    dp[j] = Math.max (dp[j], dp[j - toppingCosts[i] * 2] + toppingCosts[i] * 2);
                }
            }
        }
        System.out.println (Arrays.toString (dp));
        return dp[target];
    }

    @Test
    public void test() {
        int baseCosts[] = {3738, 5646, 197, 7652};
        int toppingCosts[] = {5056};
        int target = 9853;
        closestCost (baseCosts, toppingCosts, target);
    }
}
