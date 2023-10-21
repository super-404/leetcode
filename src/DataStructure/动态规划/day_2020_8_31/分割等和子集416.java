package DataStructure.动态规划.day_2020_8_31;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:  每个数组中的元素不会超过 100 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-09-02 15:46
 **/
public class 分割等和子集416 {
    public static void main(String[] args) {
        System.out.println (new Solution ().canPartition (new int[]{6, 4, 4, 2}));
    }
}

class Solution {
    public boolean canPartition(int[] nums) {

        //由于需要等和分割
        //因此该数组和必须可以整除2
        //所以
        int sum = Arrays.stream (nums).sum ();
        if (sum % 2 != 0) {
            return false;
        }
        //如果可以被均分成两部分，那么我们只需要判断数组中是否有数据的和会等于sum/2;
        int target = sum / 2;

        //从0开始往后推，0，1，2，3，.... target
        boolean dp[][] = new boolean[nums.length][target + 1];
        if (nums[0] <= target)
            dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] == j) {
                    dp[i][j] = true;
                }
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        boolean betterDp[] = new boolean[target + 1];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] == j) {
                    betterDp[j] = true;
                }
                if (j > nums[i]) {
                    betterDp[j] = betterDp[j] || betterDp[j - nums[i]];
                }
            }
        }
        System.out.println (Arrays.toString (betterDp));
        System.out.println ("=============================");
        for (int i = 0; i < nums.length; i++) {
            System.out.println (Arrays.toString (dp[i]));
        }
        return dp[nums.length - 1][target];
    }
}
