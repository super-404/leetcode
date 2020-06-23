package DataStructure.Union_Find_Sets.leetcode_union练习;

import java.util.Arrays;

/**
 * @Author: 饶嘉伟
 * @Description:
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 输出：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 这个是使用并查集的解法
 * 利用并查集来解决区域之间是否互连
 *
 * @Date: 2020/3/27 20:30
 * @Param a
 * @retur: a
 **/

public class TheAreaAround130 {
    int parents[];
    public static void main(String[] args) {
        TheAreaAround130 taa=new TheAreaAround130 ();
        char[][] board={
                {'X', 'X', 'X','X'},
                {'X', 'O', 'O','X'},
                {'X', 'X', 'O','X'},
                {'X', 'O', 'O','X'}
        };
        taa.solution (board);
        for (int i = 0; i <board.length ; i++) {
            System.out.println (Arrays.toString (board[i]));
        }
    }
    public  void solution(char [][] board){
        uf u=new uf(board.length,board[0].length);

        int length=board[0].length;

        //这个un可以任意取，但是还是要保证在整个数组中唯一

        int un=board.length*board[0].length;

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                //但它是'O'时
                if(board[i][j]=='O') {
                    //判断是否在边界上
                    if ((i == 0 || j == 0 || j == board[0].length - 1 || i == board.length - 1)) {
                       //如果在的话，利用横纵坐标生成一个在矩阵中唯一的数字
                        //然后与之前定义好的一个数字构成一个区域，代表没有被包围
                        //代表这是一个在边界上的区域
                        u.union (getIndex (i, j, length), un);
                    } else {

                        //如果不在边界上
                        //找到上下左右的目标'O'
                        //并且连接成一个整体
                        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                            u.union (getIndex (i, j, length), getIndex (i - 1, j, length));
                        }
                        if (i + 1 <= board.length - 1 && board[i + 1][j] == 'O') {
                            u.union (getIndex (i, j, length), getIndex (i + 1, j, length));
                        }
                        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                            u.union (getIndex (i, j, length), getIndex (i, j - 1, length));
                        }
                        if (j + 1 <= board[0].length - 1 && board[i][j + 1] == 'O') {
                            u.union (getIndex (i, j, length), getIndex (i, j + 1, length));
                        }
                    }
                }
            }
        }
        //最后判断当前'O' 是否与un互连
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]=='O'&&!u.isSame (getIndex (i,j,length),un)){
                    board[i][j]='X';
                }
            }
        }


    }
    public int getIndex(int i,int j,int length){
        return i*length+j;
    }


   public class uf{

            uf(int i,int j){
                parents=new int [i*j+1];
                for(int k=0;k<parents.length;k++){
                    parents[k]=k;
                }
            }
            int  find(int p){
                while(p!=parents[p]){
                //路径压缩
                parents[p]=parents[parents[p]];
                p=parents[p];
            }
         return p;
        }
        void  union(int p,int v){

            int p1=find(p);
            int p2=find(v);
            if(p1==p2)
                return ;
            //待优化
            parents[p1]=p2;
        }
        boolean isSame(int p,int v){
            return find(p)==find(v);
        }

    }
}

