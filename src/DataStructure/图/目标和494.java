package DataStructure.图;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-30 23:21
 **/
public class 目标和494 {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        solution (nums, 0, 0, target);
        return ans;
    }

    public void solution(int nums[], int start, int sum, int target) {
        if (sum == target && start == nums.length) {
            ans++;
        }
        if (start >= nums.length) {
            return;
        }
        if (sum < target) {
            solution (nums, start + 1, sum + nums[start], target);
        } else {
            solution (nums, start + 1, sum - nums[start], target);
        }

    }

    @Test
    public void test() {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println (findTargetSumWays (a, 3));
    }
}
