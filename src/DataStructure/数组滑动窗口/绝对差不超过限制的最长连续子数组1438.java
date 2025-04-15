package DataStructure.数组滑动窗口;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 nums ，和一个表示限制的整数 limit，
 * 请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit。
 * 如果不存在满足条件的子数组，则返回 0。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * <p>
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * <p>
 * 因此，满足题意的最长子数组的长度为 2 。
 * @author: 饶嘉伟
 * @create: 2023-12-11 09:49
 **/
public class 绝对差不超过限制的最长连续子数组1438 {

    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int max = 0;
        int min = 0x7fffffff;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<> (nums.length, (a, b) -> {
            return b - a;
        });
        TreeSet ts = new TreeSet ();

//        while (right < nums.length) {
//            max = Math.max (nums[right], max);
//            min = Math.min (nums[right], min);
//            pq.add (nums[right]);
//            while (max - min > limit) {
//
//                left++;
//                pq.peek ()
//                if (nums[left] == max) {
//                    max = stream.max ().getAsInt ();
//                }
//                if (nums[left] == min) {
//                    min = stream.min ().getAsInt ();
//                }
//
//            }
//            ans = Math.max(ans,right-left+1);
//            right++;
//        }
        return ans;
    }

    @Test
    public void test() {
        int a[] = {10, 1, 2, 4, 7, 2};
        IntStream stream = Arrays.stream (a, 0, 1);
        System.out.println (stream.sum ());

        int i = new 绝对差不超过限制的最长连续子数组1438 ().longestSubarray (a, 5);
        System.out.println (i);
    }
}
