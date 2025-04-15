package 周赛.第395场;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-05-10 14:55
 **/
public class 找出与数组相加的整数I {
    public int addedInteger(int[] nums1, int[] nums2) {
        return Arrays.stream (nums2).min ().getAsInt () - Arrays.stream (nums1).min ().getAsInt ();
    }

    public static void main(String[] args) {
        System.out.println (7 & 15);
    }
}
