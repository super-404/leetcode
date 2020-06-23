package DataStructure.深度优先搜索.day_2020_6_11;
/**
 * @Author: 饶嘉伟
 * @Description:
 *  就是求最多个连接在一起的 1
 *  没什么说的，dfs或者bfs都可以
 * @Date: 2020/6/11 17:33
 * @Param a
 * @retur: a
 **/
public class 岛屿的最大面积695 {
    public static void main(String[] args) {
        int grid [][]=
                {{1,1,0,0,0},
                 {1,1,0,0,0},
                 {0,0,0,1,1},
                 {0,0,0,1,1},
                };
    }
}
class Solution {
    int count=0;
    boolean off=false;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=0;
                    dfs(grid,i,j);
                    res=Math.max(res,count);

                }
            }
        }
        return res;
    }
    public void dfs(int grid[][],int x,int y){
        if(grid[x][y]!=1){
            return;
        }
        grid[x][y]=2;
        count++;
        if(x-1>=0&&y<grid[0].length){
            dfs(grid,x-1,y);
        }
        if(x<grid.length&&y-1>=0){
            dfs(grid,x,y-1);
        }
        if(x+1<grid.length&&y<grid[0].length){
            dfs(grid,x+1,y);
        }
        if(x<grid.length&&y+1<grid[0].length){
            dfs(grid,x,y+1);
        }

    }
}
