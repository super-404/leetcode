package DataStructure.动态规划.day_2020_7_25;

/**
 * @Author: 饶嘉伟
 * @Description 给你一个整数数组 nums ，
 * <p>
 * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * <p>
 * 并返回该子数组所对应的乘积
 * @Date: 2020/7/25 16:15
 * @Para: a
 * @retun: a
 **/

public class 乘积最大子数组152 {
    public static void main(String[] args) {
        System.out.println (new Solution2 ().maxProduct (new int[]{2, 3, -2, 4}));
    }
}

class Solution2 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int muti = nums[i];
            if (muti > max) {
                max = muti;
            }
            for (int j = i + 1; j < nums.length; j++) {
                muti = muti * nums[j];
                if (muti > max) {
                    max = muti;
                }
            }
        }
        return max;
    }
}
