package DataStructure.深度优先搜索.day_2020_5_28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: 饶嘉伟
 * @Description:a 用多了dfs，
 * 所以想试一下bfs
 * @Date: 2020/5/28 19:36
 * @Param a
 * @retur: a
 **/

public class 水域大小面试题1619 {
}

class Solution {
    public int[] pondSizes(int[][] land) {
        if (land.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> li = new LinkedList<> ();
        //列的长度
        int row = land[0].length;
        ArrayList<Integer> res = new ArrayList<> ();
        int move[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int i = 0; i < land.length; i++)
            for (int j = 0; j < land[0].length; j++) {
                //零为水域
                if (land[i][j] == 0) {
                    //添加进队列
                    li.add (i * row + j);
                    //标注已经访问过
                    land[i][j] = -1;
                    //开始计数
                    int count = 0;
                    count++;

                    while (!li.isEmpty ()) {
                        //弹出队首元素
                        int origin = li.poll ();
                        //获取行坐标
                        int x = origin / row;
                        //获取列坐标
                        int y = origin % row;
                        //判断8个方向是否有相连的水域
                        for (int k = 0; k < 8; k++) {
                            int nextX = x + move[k][0];
                            int nextY = y + move[k][1];
                            if (nextX >= 0 && nextY >= 0 && nextX < land.length && nextY < land[0].length && land[nextX][nextY] == 0) {
                                li.add (nextX * row + nextY);
                                count++;
                                land[nextX][nextY] = -1;
                            }

                        }

                    }
                    res.add (count);
                }
            }
        Collections.sort (res);
        int a[] = new int[res.size ()];
        int k = 0;
        for (int n : res
        ) {
            a[k++] = n;
        }
        return a;
    }
}
