package DataStructure.深度优先搜索.day_2020_5_26;

import java.util.Arrays;

/**
 * @Author: 饶嘉伟
 * @Description  找地雷类型
 * 利用深搜，可以很快实现但是注意搜索时不再是四个位置，上下左右
 * 而是目标身边的一圈的位置，共八个方向都需要去搜索
 * 还有一个需要注意的点就是，需要利用一个数组记录是否访问过该条路径
 * @Date: 2020/5/26 18:23
 * @Para: a
 * @retun: a
 **/

public class 扫雷游戏 {
    public static void main(String[] args) {
     char board[][]=
             {{'E', 'E', 'E', 'E', 'E'},
             {'E', 'E', 'M', 'E', 'E'},
             {'E', 'E', 'E', 'E', 'E'},
             {'E', 'E', 'E', 'E', 'E'}
     };
     Solution s=new Solution ();
     s.updateBoard (board,new int[]{3,0});
    }
}

class Solution {
    int number=1;
    boolean visited[][];
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0||board[0].length==0){
            return board;
        }

        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        visited=new boolean[board.length][board[0].length];
        change(board,click[0],click[1]);
        return board;
    }
    public void change(char [][]board, int x,int y){
        int count=0;

        if(x==board.length||y==board[0].length||x<0||y<0){
            return;
        }

        if(board[x][y]=='M'){
            return;
        }
        if(visited[x][y]){
            return;
        }
        //判断八个方向的有没有满足条件的
        if(x+1<board.length&&board[x+1][y]=='M')
            count++;
        if(y+1<board[0].length&&board[x][y+1]=='M')
            count++;
        if(x-1>=0&&board[x-1][y]=='M')
            count++;
        if(y-1>=0&&board[x][y-1]=='M')
            count++;
        if(x+1<board.length&&y+1<board[0].length&&board[x+1][y+1]=='M')
            count++;
        if(x-1>=0&&y-1>=0&&board[x-1][y-1]=='M')
            count++;
        if(y+1<board[0].length&&x-1>=0&&board[x-1][y+1]=='M')
            count++;
        if(x+1<board.length&&y-1>=0&&board[x+1][y-1]=='M')
            count++;
        if(count==0){
            board[x][y] = 'B';
             System.out.println (number++);
             for(int i=0;i<board.length;i++){
                 System.out.println (Arrays.toString (board[i]));
             }
        }
        else{
            //这里也需要注意
            //因为把我们必须确保每一个这个数字方块附近一定要可以找到B
            //换句话说，如果当前的方块是数字

            //不能再向下搜索了，必须要返回
            board[x][y]=(char)(count+'0');
            return;
        }
        visited[x][y]=true;
        change(board,x+1,y);
        change(board ,x,y+1);
        change(board,x-1,y);
        change(board,x,y-1);
        change(board,x+1,y+1);
        change(board ,x-1,y+1);
        change(board,x-1,y-1);
        change(board,x+1,y-1);
    }
}


