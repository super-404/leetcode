package DataStructure.数组滑动窗口;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 给你一个二元数组 nums ，和一个整数 goal ，
 * <p>
 * 请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * @author: 饶嘉伟
 * @create: 2023-12-09 08:58
 **/
public class 和相同的二元子数组930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hm = new HashMap ();
        int sum = 0;
        int res = 0;
        //hm.put(0,1);
        //需要注意的细节是0，
        for (int i = 0; i < nums.length; i++) {
            //要先把零放进去
            hm.computeIfPresent (sum, (a, b) -> b + 1);
            hm.putIfAbsent (sum, 1);
            sum += nums[i];
            if (hm.containsKey (sum - goal)) {
                res += hm.get (sum - goal);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int a[] = {0, 0, 0, 0, 0};
        int ans = new 和相同的二元子数组930 ().numSubarraysWithSum (a, 0);
        System.out.println (ans);
    }
}
