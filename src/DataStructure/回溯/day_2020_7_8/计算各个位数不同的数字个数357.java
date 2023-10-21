package DataStructure.回溯.day_2020_7_8;

import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，
 * 其中 0 ≤ x < 10n 。
 * @author: 饶嘉伟
 * @create: 2020-07-08 14:30
 **/
/*
* 示例:
输入: 2
输出: 91
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
*
* */
public class 计算各个位数不同的数字个数357 {
    public static void main(String[] args) {
        System.out.println (new Solution1 ().countNumbersWithUniqueDigits (3));
    }
}

//解法一
class Solution {
    boolean used[] = new boolean[10];
    int sum = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        //这个特殊情况其实我也不是很明白
        //        //        //为什么0 位数还有1种解


        // n位
        //先从1位开始
        //然后2位
        //然后3位
        for (int i = 1; i <= n; i++)
            backTrack (i, new ArrayList<Integer> ());
        return sum;
    }

    public void backTrack(int n, List<Integer> path) {
        if (path.size () == n) {
            sum++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                //避免出现01 02 这样以0开头的数字
                if (path.size () >= 1 && path.get (0) == 0) {
                    return;
                }
                path.add (i);
                used[i] = true;
                backTrack (n, path);
                used[i] = false;
                path.remove (path.size () - 1);
            }
        }
    }
}

//解法二
//利用排列组合
class Solution1 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int temp = 9;
        int sum = 10;
        for (int i = 2; i <= n; i++) {
            temp *= (11 - i);
            sum += temp;
        }
        return sum;
    }

}
