package DataStructure;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-12 23:47
 **/
public class 环形子数组的最大和918 {
    public int maxSubarraySumCircular(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        int len = nums.length;
        int max = 0;
        while (left <= right) {
            if (res < 0) {
                left = right;
            } else {
                res += nums[right % len];
                max = res > max ? res : max;
            }
            right++;
        }
        return max;
    }
}
