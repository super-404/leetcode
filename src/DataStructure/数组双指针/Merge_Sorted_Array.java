package DataStructure.数组双指针;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-15 15:31
 **/
public class Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int temp[] = Arrays.copyOf (nums1, m);
        int k = 0;
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            nums1[k++] = temp[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }

    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 0, 0, 0};
        int b[] = new int[]{2, 3, 4};
        new Merge_Sorted_Array ().merge (a, 3, b, 3);
        System.out.println (Arrays.toString (a));
    }
}
