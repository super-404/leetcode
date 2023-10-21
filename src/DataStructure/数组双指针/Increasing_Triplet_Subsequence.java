package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * <p>
 * such that i < j < k and nums[i] < nums[j] < nums[k].
 * <p>
 * If no such indices exists, return false.
 * @author: 饶嘉伟
 * @create: 2023-10-16 19:35
 **/
public class Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {
        //超时
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    if (nums[i]<nums[j]&&nums[j]<nums[k]){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
        //可以继续优化
//        if (nums.length<3){
//            return false;
//        }
//        int leftMin [] = new int[nums.length];
//        int rightMax [] = new int[nums.length];
//        leftMin[0]  = Integer.MAX_VALUE;
//        rightMax[nums.length-1] = Integer.MIN_VALUE;
//        for (int i = 1; i < nums.length; i++) {
//            leftMin[i] = Math.min(leftMin[i-1],nums[i-1]);
//        }
//        for (int i = nums.length-2; i>=0;i--) {
//            rightMax[i] = Math.max(rightMax[i-1],nums[i+1]);
//        }
//        //去掉头和尾
//        for(int i = 1;i<nums.length-1;i++){
//            if (leftMin[i]<nums[i]&&nums[i]<rightMax[i]){
//                return true;
//            }
//        }
//        return false;
        if (nums.length < 3) {
            return false;
        }
//        int leftMin [] = new int[nums.length];
//        int rightMax [] = new int[nums.length];
//        leftMin[0]  = Integer.MAX_VALUE;
//        rightMax[nums.length-1] = Integer.MIN_VALUE;
//        for (int i = 1; i < nums.length; i++) {
//            leftMin[i] = Math.min(leftMin[i-1],nums[i-1]);
//        }
//        for (int i = nums.length-2; i>=0;i--) {
//            rightMax[i] = Math.max(rightMax[i-1],nums[i+1]);
//        }
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;
        //去掉头和尾
        for (int i = 1; i < nums.length - 1; i++) {

            if (leftMin < nums[i] && nums[i] < rightMax) {
                return true;
            }
        }
        return false;
    }
}
