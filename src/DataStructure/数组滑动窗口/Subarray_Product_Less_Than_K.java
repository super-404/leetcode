package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-20 10:57
 **/
public class Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int ret = 0;
        int prod = 0;


        if (k == 0)
            return 0;
        while (right < nums.length) {
            prod *= nums[right];
            while (prod > k) {
                prod /= nums[left];
                left++;
            }
            //注意这里是所有的子数组，不能单纯加一 ，

            // 【1，2，3】子数组分别有，【1】，【2】，【3】，【1，2】，【1，3】，【2，3】；
            //如果1*2*3<k,答案应该是6，
            //7 = 0-0+1 + 1-0+1 +2-0+1
            ret += right - left + 1;
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{10, 5, 2, 6};
        int i = new Subarray_Product_Less_Than_K ().numSubarrayProductLessThanK (nums, 100);
        System.out.println (i);
    }
}
