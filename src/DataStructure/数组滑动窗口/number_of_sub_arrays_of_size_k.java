package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description: Given an array of integers arr and two integers k and threshold,
 * <p>
 * <p>
 * return the number of sub-arrays of size k and average greater than or equal to threshold.
 * @author: 饶嘉伟
 * @create: 2023-10-19 09:54
 **/

/**
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * <p>
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
 * <p>
 * All other sub-arrays of size 3 have averages less than 4 (the threshold).
 **/
public class number_of_sub_arrays_of_size_k {


    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;

        int left = 0;
        int right = 0;


        int res = 0;
        while (right < arr.length) {

            sum += arr[right];
            if (right - left + 1 >= k) {
                int average = sum / k;
                if (average >= threshold) {
                    res++;
                }
                sum -= arr[left];
                left++;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        new number_of_sub_arrays_of_size_k ().numOfSubarrays (new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4);
    }
}
