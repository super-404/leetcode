package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: Example 1:
 * <p>
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * @author: 饶嘉伟
 * @create: 2023-10-13 22:52
 **/
public class Longest_Mountain_in_Array {

    public int longestMountain(int[] arr) {
        int count_in = 0;
        int count_de = 0;
        boolean is_in = false;
        boolean is_de = false;
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                if (is_de) {
                    ans = Math.max (ans, count_in + count_de);
                    count_in = 0;
                    count_de = 0;
                    is_in = false;
                    is_de = false;
                }
                count_in++;
                is_in = true;
            } else if (arr[i + 1] < arr[i] && is_in) {
                count_de++;

                is_de = true;
            } else {
                if (is_de) {
                    ans = Math.max (ans, count_in + count_de);
                }
                count_in = 0;
                count_de = 0;
                is_in = false;
                is_de = false;
            }
        }
        if (is_in && is_de) {
            ans = Math.max (ans, count_in + count_de);
        }
        return ans == 0 ? 0 : ans + 1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 0, 0, 1, 1, 1, 1};
        int res = new Longest_Mountain_in_Array ().longestMountain (a);
        System.out.println (res);


    }
}
