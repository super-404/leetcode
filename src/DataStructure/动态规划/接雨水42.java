package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2022-10-08 15:59
 **/
public class 接雨水42 {

    public static void main(String[] args) {
        System.out.println (new Solution42 ().trap (new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

class Solution42 {
    public int trap(int[] height) {


        int rain = 0;
        for (int i = 0; i < height.length; i++) {
            int secondMax = -1;
            for (int j = i + 1; j < height.length; j++) {
                int min = height[j] >= height[i] ? height[i] : height[j];
                if (j - i - 1 > 0 && min > secondMax && secondMax != -1) {
                    rain += (min - secondMax) * (j - i - 1);
                }
                if (height[j] > secondMax)
                    secondMax = height[j];
            }
        }
        return rain;
    }
}
