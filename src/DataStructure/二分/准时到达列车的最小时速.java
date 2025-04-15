package DataStructure.二分;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-02 23:25
 **/
public class 准时到达列车的最小时速 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > right) {
                right = dist[i];
            }
        }
        //int ans = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (check (dist, mid, hour) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public double check(int[] dist, int speed, double hour) {
        double h = 0.00;
        for (int i = 0; i < dist.length - 1; i++) {
            h += (dist[i] - 1) / speed + 1;
        }

        h += dist[dist.length - 1] / (float) speed;
        return h - hour;
    }

    @Test
    public void test() {
        int dist[] = {1, 3, 2};
        int hour = 6;
        minSpeedOnTime (dist, hour);
    }
}
