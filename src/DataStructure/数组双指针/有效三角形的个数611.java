package DataStructure.数组双指针;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * @author: 饶嘉伟
 * @create: 2023-10-11 09:26
 **/
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        //先排序
        Arrays.sort (nums);
        int k = 2;
        int ans = 0;
        while (k < nums.length) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    ans += j - i;
                    j--;
                } else {
                    i++;
                }
            }
            k++;
        }
        return ans;
    }
}

public class 有效三角形的个数611 {

    public static void main(String[] args) {
        int res = new Solution ().triangleNumber (new int[]{4, 2, 3, 4});
        System.out.println (res);
    }
}
