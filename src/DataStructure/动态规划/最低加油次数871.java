package DataStructure.动态规划;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-19 10:12
 **/
public class 最低加油次数871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pqi = new PriorityQueue<> ();
        int currentFuel = startFuel;
        int len = 0;
        int res = 0;
        if (currentFuel >= target) {
            return 0;
        } else if (stations.length == 0) {
            return -1;
        }
        int i = 0;
        while (len < target) {

            //当前油量能否到达下一站
            if (i < stations.length && currentFuel >= stations[i][0]) {
                //如果可以先不加油
                len += currentFuel;
                pqi.add (stations[i][1]);
                currentFuel -= stations[i][0];
                i++;
            } else {
                if (pqi.isEmpty ()) {
                    return -1;
                } else {
                    currentFuel += pqi.poll ();
                    res += 1;
                }
            }

        }
        return res;
    }

    @Test
    public void test() {
        int a[][] = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};

        System.out.println (minRefuelStops (100, 10, a));
    }
}
