package DataStructure.动态规划.day_2020_8_03;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个二维矩阵，计算其子矩形范围内元素的总和，
 * 该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * @author: 饶嘉伟
 * @create: 2020-08-03 11:53
 **/
public class 二维区域和检索矩阵不可变304 {
    public static void main(String[] args) {
        new NumMatrix (new int[0][0]).sumRegion (1, 1, 2, 2);
    }
}
//对于任何一个区域，都可以被分成三分

//分别是目标区域，上部分区域，左部分区域
//我们在一维版本中使用了累积和数组。我们注意到累积和是根据索引 0 处的原点计算的。将这个类比扩展到二维情况，我们可以预先计算出一个与原点相关的累积区域和，即 (0,0)(0,0)。
//
//
//
//Sum(OD)是相对于原点(0,0)的累计区域和。
//如何使用预先计算的累积区域和得出 Sum(ABCD)Sum(ABCD) 呢？
//
//
//
//Sum(OB)是矩形顶部的累积区域和。
//
//
//
//Sum(OC)是矩形左侧的累积区域和。
//
//
//
//Sum(OA) 是矩形左上角的累积区域和。
//区域 Sum(OA)Sum(OA) 由 Sum(OB)Sum(OB) 和 Sum(OC)Sum(OC)两次覆盖。我们可以使用包含排除原则计算 Sum(ABCD)Sum(ABCD) 如下：
//
//sum(abcd)=sum(od)-sum(ob)-sum(oc)+sum(oa)
//sum(abcd)=sum(od)−sum(ob)−sum(oc)+sum(oa)
//
//作者：LeetCode
//链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/er-wei-qu-yu-he-jian-suo-ju-zhen-bu-ke-bian-by-lee/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class NumMatrix {
    int dp[][];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0) {
            return;
        }
        dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++)
            System.out.println (Arrays.toString (dp[i]));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0) {
            if (col1 == 0) {
                return dp[row2][col2];
            } else {
                int leftCount = dp[row2][col1 - 1];
                int result = dp[row2][col2] - leftCount;
                return result;
            }
        }
        int topCount = dp[row1 - 1][col2];
        if (col1 == 0) {
            return dp[row2][col2] - topCount;
        } else {
            int leftCount = dp[row2][col1 - 1];
            int surplus = dp[row1 - 1][col1 - 1];
            return dp[row2][col2] - leftCount - topCount + surplus;
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
