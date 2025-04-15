package DataStructure.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 17:46
 **/
public class MaximumTotalRewardUsingOperationsI {

    public int maxTotalReward(int[] rewardValues) {
        return solution (rewardValues, 0, 0);
    }

    private int solution(int[] rewardValues, int ans, int i) {
        if (i >= rewardValues.length) {
            return ans;
        }
        int max = 0;
        for (int j = i; j < rewardValues.length; j++) {
            if (ans < rewardValues[j]) {
                max = Math.max (solution (rewardValues, ans + rewardValues[j], j), max);
            }
        }
        return max;
    }

    class Solution {
        private int[] nums;
        private Integer[] f;

        public int maxTotalReward(int[] rewardValues) {
            nums = rewardValues;
            Arrays.sort (nums);
            int n = nums.length;
            f = new Integer[nums[n - 1] << 1];
            return dfs (0);
        }

        private int dfs(int x) {
            if (f[x] != null) {
                return f[x];
            }
            int i = Arrays.binarySearch (nums, x + 1);
            i = i < 0 ? -i - 1 : i;
            int ans = 0;
            for (; i < nums.length; ++i) {
                ans = Math.max (ans, nums[i] + dfs (x + nums[i]));
            }
            return f[x] = ans;
        }
    }

    @Test
    public void test() {
        int a[] = {1, 6, 4, 3, 2};
        new Solution ().maxTotalReward (a);
    }
}
