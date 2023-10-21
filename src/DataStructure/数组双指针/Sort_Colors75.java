package DataStructure.数组双指针;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * <p>
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * @author: 饶嘉伟
 * @create: 2023-10-13 10:14
 **/
public class Sort_Colors75 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }
        for (int i = p0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            } else if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                //如果p0指向的是1的话，还要一次交换
                if (temp == 1) {
                    int temp1 = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp1;
                }
                p1++;
                p0++;
            }
        }
    }

    //    void swap(int i,int j){
//
//    }
    public static void main(String[] args) {
        int a[] = new int[]{2, 0, 2, 1, 1, 0};
        new Sort_Colors75 ().sortColors2 (a);
        System.out.println (Arrays.toString (a));
    }
}
