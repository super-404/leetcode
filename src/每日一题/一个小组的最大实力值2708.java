package 每日一题;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-03 09:21
 **/
//给你一个下标从 0 开始的整数数组 nums ，
// 它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，
// 且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，
// 那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik] 。
//
//请你返回老师创建的小组能得到的最大实力值为多少。
public class 一个小组的最大实力值2708 {
    public long maxStrength(int[] nums) {
        int len = nums.length;
        int dpMin[] = new int[len];
        int dpMax[] = new int[len];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        for (int i = 1; i < len; i++) {
//            if(nums[i]==0){
//                dpMin[i] =  dpMin[i - 1];
//                dpMax[i] = dpMax[i - 1];
//                continue;
//            }
            if (nums[i] < 0) {
                dpMin[i] = Math.min (dpMax[i - 1] * nums[i], dpMin[i - 1]);
                dpMin[i] = Math.min (dpMin[i], nums[i]);
                dpMax[i] = Math.max (dpMin[i - 1] * nums[i], dpMax[i - 1]);
                dpMax[i] = Math.max (dpMax[i], nums[i]);
            } else {
                dpMin[i] = Math.min (dpMin[i - 1] * nums[i], dpMin[i - 1]);
                dpMin[i] = Math.min (dpMin[i], nums[i]);
                dpMax[i] = Math.max (dpMax[i - 1] * nums[i], dpMax[i - 1]);
                dpMax[i] = Math.max (dpMax[i], nums[i]);
            }
        }
        return dpMax[len - 1];
    }

    @Test
    public void test() {
        int a[] = {-1, -7, -5, 7, 7, 0, 9, 0, -5, -6};
        maxStrength (a);
    }
}
