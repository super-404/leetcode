package DataStructure.数组滑动窗口;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 nums 和两个整数：left 及 right 。
 * 找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，
 * 并返回满足条件的子数组的个数。  生成的测试用例保证结果符合 32-bit 整数范围。
 * 示例 1：
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * <p>
 * 示例 2：
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * @author: 饶嘉伟
 * @create: 2023-12-08 23:03
 **/
public class 区间子数组个数795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = 0;
        int r = 0;
        int count = 0;
        int max = 0;
        while (r < nums.length) {
            max = Math.max (max, nums[r]);
            if (max >= left && max <= right) {

                count += 1;
            } else {
                l = r + 1;
                max = 0;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3};

        int i = new 区间子数组个数795 ().numSubarrayBoundedMax (a, 2, 3);

        System.out.println (i);
//        System.out.println (2-+1);
//        System.out.println (-7-+1);
    }

    @Test
    public void test_1() {
        int a[] = {2, 9, 2, 5, 6};

        int i = new 区间子数组个数795 ().numSubarrayBoundedMax (a, 2, 8);

        System.out.println (i);
//        System.out.println (2-+1);
//        System.out.println (-7-+1);
    }
}
