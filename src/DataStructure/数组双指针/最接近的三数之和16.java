package DataStructure.数组双指针;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * @author: 饶嘉伟
 * @create: 2023-10-12 09:45
 **/
public class 最接近的三数之和16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort (nums);
        int ans = Integer.MAX_VALUE;
        int k = 0;
        int res = 0;
        while (k < nums.length) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i] + nums[j] + nums[k] - target;
                if (Math.abs (temp) < ans) {

                    res = nums[i] + nums[j] + nums[k];
                    ans = Math.abs (temp);
                }

                if (temp < 0) {
                    i++;
                } else {
                    j--;
                }
            }
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new 最接近的三数之和16 ().threeSumClosest (new int[]{-1, 2, 1, -4}, 1);
        System.out.println (res);
    }
}
