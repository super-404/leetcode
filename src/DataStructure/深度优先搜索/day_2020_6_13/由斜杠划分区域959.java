package DataStructure.深度优先搜索.day_2020_6_13;


/**
 * @Author: 饶嘉伟
 * @Description: 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。
 * 这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/13 17:02
 * @Param DataStructure.a
 * @retur: DataStructure.a
 **/

//这道题目其实还蛮简单的(主要是我做出来了，虽然性能没有并查集的好)
//首先每一个小方格都可以被分成两份。
//而这两份又可以向上下左右四个方向合并
//斜线就是用来告诉你，那些小方格不能向上向下。。。。

//示例三

/*[
  "\\/",
  "/\\"
]
*/

//可以被转换成这个样子
/*
   0 1 1 1 1 0
   1 0 1 1 0 1
   1 1 0 0 1 1
   1 1 0 0 1 1
   1 0 1 1 0 1
   0 1 1 1 1 0
 */
//一开始本来是想到4*4的
//但是发现无法满足要求

//然后这道题目就变成了一道非常简单的查找连通分量的问题

public class 由斜杠划分区域959 {

}

class Solution1 {
    int goal[][];

    public int regionsBySlashes(String[] grid) {

        goal = new int[grid.length * 3][grid.length * 3];

        //初始化目标数组全部为1
        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < goal[0].length; j++) {
                goal[i][j] = 1;
            }
        }
        //对题目给出的条件进行判断
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length (); j++) {

                if (grid[i].charAt (j) == '/') {
                    goal[i * 3][j * 3 + 2] = 0;
                    goal[i * 3 + 1][j * 3 + 1] = 0;
                    goal[i * 3 + 2][j * 3] = 0;
                }
                if (grid[i].charAt (j) == '\\') {
                    goal[i * 3][j * 3] = 0;
                    goal[i * 3 + 1][j * 3 + 1] = 0;
                    goal[i * 3 + 2][j * 3 + 2] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < goal[0].length; j++) {
                if (goal[i][j] == 1) {
                    dfs (i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y) {
        if (goal[x][y] != 1) {
            return;
        }
        goal[x][y] = 2;
        if (x - 1 >= 0) {
            dfs (x - 1, y);
        }
        if (x + 1 <= goal.length - 1) {
            dfs (x + 1, y);
        }
        if (y - 1 >= 0) {
            dfs (x, y - 1);
        }
        if (y + 1 <= goal[0].length - 1) {
            dfs (x, y + 1);
        }
    }
}
