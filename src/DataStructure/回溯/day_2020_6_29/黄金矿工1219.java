package DataStructure.回溯.day_2020_6_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 饶嘉伟
 * @Description: 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，
 * 并用大小为 m * n 的网格 grid 进行了标注
 * 。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * <p>
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * <p>
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-maximum-gold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/29 19:19
 * @Param a
 * @retur: a
 **/

public class 黄金矿工1219 {

    public static void main(String[] args) {
        Solution solution = new Solution ();
        int grid[][] = {
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0},
                {3, 0, 5, 0, 20, 0}
        };
        int max = solution.getMaximumGold (grid);
        System.out.println (max);
    }
}

class Solution {
    int grid[][];
    int max = Integer.MIN_VALUE;
    int move[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    ArrayList<Integer> ai = new ArrayList<> ();
    ArrayList<ArrayList<Integer>> aai = new ArrayList<> ();

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    dfs (i, j, 0);
                }
            }
        }
        return max;
    }

    public void dfs(int x, int y, int sum) {

        if (grid[x][y] == 0) {
            return;
        }
        int temp = grid[x][y];
        grid[x][y] = 0;
        sum += temp;
        if (sum > max) {
            max = sum;
        }
        for (int act[] : move) {
            int i = x + act[0];
            int j = y + act[1];
            if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0) {
                continue;
            }
            dfs (i, j, sum);
        }
        grid[x][y] = temp;
    }
}
