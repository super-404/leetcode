package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description: Given an array of positive integers nums and a positive integer target,
 * <p>
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * <p>
 * If there is no such subarray, return 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * <p>
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * @author: 饶嘉伟
 * @create: 2023-10-21 12:31
 **/
public class Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min (ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2, 3, 1, 2, 4, 3};
        int res = new Minimum_Size_Subarray_Sum ().minSubArrayLen (7, a);
        System.out.println (res);
    }
}
