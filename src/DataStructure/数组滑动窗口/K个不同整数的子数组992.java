package DataStructure.数组滑动窗口;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
 * <p>
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，
 * <p>
 * 则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 * <p>
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * <p>
 * 子数组 是数组的 连续 部分。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,2,3], k = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：
 * [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1,3,4], k = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：
 * [1,2,1,3], [2,1,3], [1,3,4].
 * @author: 饶嘉伟
 * @create: 2023-12-09 08:36
 **/
public class K个不同整数的子数组992 {


    public int subarraysWithKDistinct(int[] nums, int k) {

        return getK (nums, k) - getK (nums, k - 1);
    }

    public int getK(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<> ();

        int left = 0;
        int right = 0;
        int res = 0;
        //这里计算的是实际上是最大为k个子数组
        while (right < nums.length) {
            //如果已经存在加一
            hm.computeIfPresent (nums[right], (a, b) -> b + 1);
            //如果不存在赋值为0
            hm.putIfAbsent (nums[right], 1);
            while (hm.size () > k) {
                hm.computeIfPresent (nums[left], (a, b) -> b - 1);
                if (hm.get (nums[left]) == 0) {
                    hm.remove (nums[left]);
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        int a[] = {1, 2, 1, 2, 3};
        int i = new K个不同整数的子数组992 ().subarraysWithKDistinct (a, 2);
        System.out.println (i);
    }
}
