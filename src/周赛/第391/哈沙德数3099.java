package 周赛.第391;

import DataStructure.图.判断图中是否存在环.test;
import org.junit.Test;

/**
 * @program: leetcode
 * @description: 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。
 * 给你一个整数 x 。如果 x 是 哈沙德数 ，
 * 则返回 x 各个数位上的数字之和，否则，返回 -1 。
 * @author: 饶嘉伟
 * @create: 2024-04-06 10:05
 **/
public class 哈沙德数3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        boolean flag = true;
        int originX = x;
        while (x != 0 && flag) {
            int temp = x % 10;
//            flag = originX%temp==0;
            sum += temp;
            x = x / 10;
        }
        return originX % sum == 0 ? sum : -1;
    }

    @Test
    public void test() {
        sumOfTheDigitsOfHarshadNumber (18);
    }
}

