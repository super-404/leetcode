package DataStructure.动态规划.day_2020_7_26;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * @author: 饶嘉伟
 * @create: 2020-07-26 15:59
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 **/
public class 最大正方形221 {

}

class Solution1 {
    int rightDp[][];
    int topDp[][];

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        rightDp = new int[n][m];
        topDp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i >= 1) {
                        topDp[i][j] = topDp[i - 1][j] + 1;
                    } else
                        topDp[i][j]++;
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (j == m - 1) {
                        rightDp[i][j]++;
                    } else {
                        rightDp[i][j] = rightDp[i][j + 1] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println (Arrays.toString (topDp[i]));
        }
        System.out.println ("+++++++++++++++++++++");
        for (int i = 0; i < n; i++) {
            System.out.println (Arrays.toString (rightDp[i]));
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rightDp[i][j] == topDp[i][j]) {
                    max = Math.max (max, count (i, j, rightDp[i][j]));
                }
            }
        }
        return max;
    }

    private int count(int i, int j, int num) {
        if (num == 1)
            return 1;
        int start = 0;
        while (num > 1) {
            //检查右边
            boolean flag = true;
            for (int k = start; k < i; k++) {
                if (rightDp[k][j] < num) {
                    flag = false;
                    break;
                }
            }
            //检查上面
            for (int k = j + 1; k < j + num; k++) {
                if (topDp[i][k] < num) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return num * num;
            }
            start++;
            num--;
        }
        return 0;
    }
}

class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //dp[i][j]是指在i，j处的最大的正方形

        int dp[][] = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {

                    //每一块正方形都可以被切分成左边，上面，左上三份

                    dp[i][j] = Math.min (dp[i][j - 1], Math.min (dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
                max = Math.max (max, dp[i][j]);
            }

        }
        return max * max;
    }

}
