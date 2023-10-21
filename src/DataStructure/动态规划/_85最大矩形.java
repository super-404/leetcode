package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 给定一个仅包含 0 和 1 、
 * 大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @author: 饶嘉伟
 * @create: 2023-03-11 14:23
 **/
public class _85最大矩形 {
    public static void main(String[] args) {
        System.out.println (new _85最大矩形 ().maximalRectangle (
                new char[][]{
                        {'1', '1', '1', '0', '0'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '1', '0', '1', '1'},
                        {'1', '1', '1', '1', '1'}}));
        System.out.println (new _85最大矩形 ().maximalRectangle (
                new char[][]{
                        {'1', '1', '1', '0', '0'}}));
        System.out.println (new _85最大矩形 ().maximalRectangle (
                new char[][]{
                        {'1'},
                        {'1'},
                        {'1'},
                        {'1'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max (max, getArea (i, j, matrix));
                }
            }
        }
        return max;
    }

    public int getArea(int i, int j, char[][] matrix) {
        int up = i;
        int left = j;
        int lateralArea = 0;
        int verticalArea = 0;
        int rectangularArea = 0;
        for (; i >= 0 && matrix[i][left] == '1'; i--) {
            verticalArea++;
        }
        for (; j >= 0 && matrix[up][j] == '1'; j--) {
            lateralArea++;
        }
        int leftEnd = j;
        int upEnd = i;
        for (int k = up - 1; k > upEnd; k--) {
            for (int v = left - 1; v > leftEnd; v--) {
                if (matrix[k][v] == '1') {
                    rectangularArea = Math.max ((up - k + 1) * (left - v + 1), rectangularArea);
                } else {
                    leftEnd = v;
                }
            }
        }
        return verticalArea >
                lateralArea ? verticalArea > rectangularArea
                ? verticalArea : rectangularArea :
                lateralArea > rectangularArea ? lateralArea : rectangularArea;
    }
}
