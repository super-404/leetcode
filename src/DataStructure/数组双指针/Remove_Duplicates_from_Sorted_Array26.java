package DataStructure.数组双指针;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-13 20:58
 **/
public class Remove_Duplicates_from_Sorted_Array26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {

            while (j < nums.length && nums[j] == nums[i]) j++;
            if (j == nums.length) {
                break;
            }
            nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2};
        int res = new Remove_Duplicates_from_Sorted_Array26 ().removeDuplicates (a);
        System.out.println (res);
        System.out.println (Arrays.toString (a));
    }
}
