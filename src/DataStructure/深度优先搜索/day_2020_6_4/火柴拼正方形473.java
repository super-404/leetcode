package DataStructure.深度优先搜索.day_2020_6_4;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: 饶嘉伟
 * @Description:
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，
 * 请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，
 * 可以把火柴连接起来，并且每根火柴都要用到。
输入为小女孩拥有火柴的数目，每根火柴用其长度表示。
输出即为是否能用所有的火柴拼成正方形。
来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/4 20:46
 * @Param DataStructure.a
 * @retur: DataStructure.a
 **/
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 火柴拼正方形473 {
    public static void main(String[] args) {
        int a[] = {3, 3, 3, 3, 4};
        Solution s = new Solution ();
        s.makesquare (a);
    }
}

class Solution {
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    public Solution() {
        this.sums = new int[4];
    }

    // Depth First Search function.
    public boolean dfs(int index) {

        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == this.nums.size ()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // Get current matchstick.
        int element = this.nums.get (index);

        // Try adding it to each of the 4 sides (if possible)
        for (int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (this.dfs (index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }

    public boolean makesquare(int[] nums) {
        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for (int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        this.possibleSquareSide = perimeter / 4;
        if (this.possibleSquareSide * 4 != perimeter) {
            return false;
        }
        // Convert the array of primitive int to ArrayList (for sorting).
        this.nums = Arrays.stream (nums).boxed ().collect (Collectors.toList ());
        Collections.sort (this.nums, Collections.reverseOrder ());
        return this.dfs (0);
    }
}
