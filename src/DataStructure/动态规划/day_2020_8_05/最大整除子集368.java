package DataStructure.动态规划.day_2020_8_05;

/**
 * @program: leetcode
 * @description: 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，
 * 子集中任意一对 (Si，Sj)
 * 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 * 如果有多个目标子集，返回其中任何一个均可。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处.
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * @author: 饶嘉伟
 * @create: 2020-08-05 15:16
 **/

import java.util.*;

public class 最大整除子集368 {
    public static void main(String[] args) {
        new Solution ().largestDivisibleSubset (new int[]{1, 2, 3, 6, 9, 8, 16,});
    }
}
//参考官方题解思路，对于一个有序数组，设dp[i]为到数字i的最大整除子集的中元素的个数。
// 那么容易知道对于每一个数字，都要从最小数字开始遍历，
// 检查是否存在nums[i] % nums[j] == 0.如果存在的话，则dp[i] = max(dp[i] , dp[j] + 1)。
// 这就意味着，j中的数字i都可以整除。同时在遍历过程中始终将最大dp[i]的值以及下标保存。
// 最后得到最大dp数组的值及其对应的下标。
//
//        根据最大dp数组的值及其对应的下标，可以得到最大整除子集。

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<> ();
        }
        if (nums.length == 1) {
            return new ArrayList<Integer> () {{
                add (nums[0]);
            }};
        }
        int dp[] = new int[nums.length];
        Arrays.sort (nums);
        Arrays.fill (dp, 1);
        int max = 1;
        int index = 0;

        //通过dp数组得到最长的目标
        //例如

        //[1, 2, 2, 3, 3, 3, 4]

        //
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max (dp[j] + 1, dp[i]);
                    //记录下最长的整数整除子集的下标
                    if (dp[i] > max) {
                        max = dp[i];
                        index = i;
                    }
                }
            }
        }

        List<Integer> li = new ArrayList<> ();

        for (int i = index; i >= 0; i--) {
            if (nums[index] % nums[i] == 0 && dp[i] == max) {
                li.add (nums[i]);
                index = i;
                max--;
            }
        }
        System.out.println (Arrays.toString (dp));
        Collections.reverse (li);
        return li;
    }
}
