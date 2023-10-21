package DataStructure.Union_Find_Sets.leetcode_union练习;

import java.util.Arrays;

public class TheAreaArounDFS {

    boolean isVisited[][];

    public static void main(String[] args) {
        TheAreaArounDFS theAreaArounDFS = new TheAreaArounDFS ();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        theAreaArounDFS.solution (board);
        for (int i = 0; i < board.length; i++) {
            System.out.println (Arrays.toString (board[i]));
        }
    }

    public void solution(char[][] board) {
        if (board.length <= 2)
            return;
        isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //如果当前是'O',且还未访问过
                if (board[i][j] == 'O' && !isVisited[i][j]) {
                    //并且当前的'O'在四边上
                    if ((i == 0 || j == 0 || j == board[0].length - 1 || i == board.length - 1)) {
                        //深度优先搜索所有与该点连接的'O'
                        dfs (i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board) {
        //如果不是说明这条路走到了尽头
        if (board[i][j] != 'O') {
            return;
        }
        //将当前的访问节点置为真
        isVisited[i][j] = true;
        //将当前节点设为'#',方便后续遍历
        board[i][j] = '#';
        //依次遍历上下左右
        if (i - 1 >= 0)
            dfs (i - 1, j, board);
        if (i + 1 <= board.length - 1)
            dfs (i + 1, j, board);
        if (j - 1 >= 0)
            dfs (i, j - 1, board);
        if (j + 1 <= board[0].length)
            dfs (i, j + 1, board);

    }
}
