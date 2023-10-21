package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 给你一个由若干 0 和 1 组成的二维网格 grid，
 * 请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。
 * 如果不存在，则返回 0。
 * @author: 饶嘉伟
 * @create: 2020-07-13 14:31
 **/


public class 最大的以1为边界的正方形1139 {
    public static void main(String[] args) {

        int grid[][] = {
                {0, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 0, 1, 1, 1, 1}
        };
        int grid1[][] = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},

        };
        System.out.println (new Solution1 ().largest1BorderedSquare (grid));
    }
}

//对每个节点进行检测
//然后同时向右边和向下边延申，直到某条边不为1

//然后再从右下角向左边和上边进行判断，直到与之前判断的两条边相遇
//说明形成正方形
//例如：

/*
  1 1 1
  1 0 1
  1 1 1
*/
/*
左边与上边形成 1 1 1
             1
             1
再检查右边与下边
              1  1  1
              1     1
              1  1  1

 */

class Solution1 {
    public int largest1BorderedSquare(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                max = Math.max (1, max);
                int right, down;
                for (right = j + 1, down = i + 1; right < grid[0].length && down < grid.length;
                     right++, down++) {

                    if (grid[i][right] == 1 && grid[down][j] == 1) {
                        int left, top;
                        int length1 = right - j + 1;
                        int length2 = down - i + 1;
                        //需要注意的是要对每一个可能的情况都遍历一遍
                        //避免漏掉某个解
                        for (left = right, top = down; left > j && top > i; left--, top--) {
                            if (grid[down][left] == 1 && grid[top][right] == 1) {
                                if (left == j + 1 && top == i + 1) {
                                    max = Math.max (length1 * length2, max);
                                    break;
                                }
                                continue;
                            } else
                                break;
                        }
                    } else
                        break;
                }
            }
        }
        return max;
    }
}
