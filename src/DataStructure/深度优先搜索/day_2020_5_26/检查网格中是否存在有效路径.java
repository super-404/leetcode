package DataStructure.深度优先搜索.day_2020_5_26;

public class 检查网格中是否存在有效路径 {

    public static void main(String[] args) {

        int [][] grid={{1,1,2}};
        Solution1 s1=new Solution1 ();
        System.out.println (s1.hasValidPath (grid));

    }


}
//
class Solution1 {
    boolean visited[][];
    boolean flag=false;
    public boolean hasValidPath(int[][] grid) {
        if(grid.length==1&&grid[0].length==1){
            return true;
        }
        visited=new boolean[grid.length][grid[0].length];
        isArrived(grid,0,0);
        return flag;
    }
    public void isArrived(int grid[][],int x,int y){

        if(x==grid.length-1&&y==grid[0].length-1){
            flag=true;
            return;
        }
        if(x>=grid.length||y>=grid[0].length||x<0||y<0){
            return;
        }
        if(visited[x][y]){
            return;
        }
        visited[x][y]=true;
        if(grid[x][y]==1){
            if(y-1>=0&&(grid[x][y-1]==4||grid[x][y-1]==6||grid[x][y-1]==1))
                isArrived(grid,x,y-1);
            if(y+1<grid[0].length&&(grid[x][y+1]==3||grid[x][y+1]==5||grid[x][y+1]==1))
                isArrived(grid,x,y+1);
        }
        if(grid[x][y]==2){
            if(x-1>=0&&(grid[x-1][y]==2||grid[x-1][y]==3||grid[x-1][y]==4))
                isArrived(grid,x-1,y);
            if(x+1<grid.length&&(grid[x+1][y]==2||grid[x+1][y]==5||grid[x+1][y]==6))
                isArrived(grid,x+1,y);
        }
        if(grid[x][y]==3){
            if(y-1>=0&&(grid[x][y-1]==1||grid[x][y-1]==4||grid[x][y-1]==6))
                isArrived(grid,y-1,x);
            if(x+1<grid.length&&(grid[x+1][y]==2||grid[x+1][y]==5||grid[x+1][y]==6))
                isArrived(grid,x+1,y);
        }
        if(grid[x][y]==4){
            if(y+1<grid[0].length&&(grid[x][y+1]==2||grid[x][y+1]==3||grid[x][y+1]==5))
                isArrived(grid,x,y+1);
            if(x+1<grid.length&&(grid[x+1][y]==2||grid[x+1][y]==5||grid[x+1][y]==6))
                isArrived(grid,x+1,y);
        }
        if(grid[x][y]==5){
            if(y-1>=0&&(grid[x][y-1]==1||grid[x][y-1]==4||grid[x][y-1]==6))
                isArrived(grid,x,y-1);
            if(x-1>=0&&(grid[x-1][y]==2||grid[x-1][y]==3||grid[x-1][y]==4))
                isArrived(grid,x-1,y);
        }
        if(grid[x][y]==6){
            if(y+1<grid[0].length&&(grid[x][y+1]==1||grid[x][y+1]==5||grid[x][y+1]==3))
                isArrived(grid,x,y+1);
            if(x-1>=0&&(grid[x-1][y]==2||grid[x-1][y]==3||grid[x-1][y]==4))
                isArrived(grid,x-1,y);
        }
    }
}
