package 每日一题;

import DataStructure.动态规划.day_2020_7_21.三角形最小路径和120;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-24 10:55
 **/
public class FindTheFirstPlayertowinKGamesinaRow3175 {
    public int findWinningPlayer(int[] skills, int k) {
        int len = skills.length;
        int count = 0;
        int maxI = 0;
        for (int i = 1; i < len; i++) {

            if (skills[i] > skills[maxI]) {
                maxI = i;
                count = 0;
            }
            count++;
        }
        return maxI;

    }
}
