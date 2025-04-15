package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-19 18:00
 **/
public class 跳跃游戏II45 {
    public int jump(int[] nums) {
        int end = nums[0];
        int max = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > end) {
                return -1;
            }
            if (i == end) {
                if (end == nums.length - 1)
                    return res;
                res += 1;
                end += max;

            }
            max = Math.max (nums[i], max);
        }
        return res;
    }
}
