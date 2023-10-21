package DataStructure.回溯.day_2020_6_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 八皇后面试题0812 {
}

class Solution1 {
    char queue[][];
    int end = 0;
    ArrayList<List<String>> ai = new ArrayList ();

    public List<List<String>> solveNQueens(int n) {
        queue = new char[n][n];
        end = n;
        init ();
        backingTrip (0);
        return ai;
    }

    public void backingTrip(int n) {
        if (n == end) {
            ArrayList<String> as = new ArrayList ();
            for (int i = 0; i < end; i++) {
                as.add (String.valueOf (queue[i]));
            }
            ai.add (as);
            return;
        }
        for (int j = 0; j < end; j++) {
            queue[n][j] = 'Q';
            if (isValid (n, j)) {
                backingTrip (n + 1);
            }
            queue[n][j] = '.';
        }
    }

    public void init() {
        for (int i = 0; i < end; i++) {
            Arrays.fill (queue[i], '.');
        }

    }


    public boolean isValid(int n, int m) {
        //判断行
        int num = 0;
        for (int k = 0; k < end; k++) {
            if (queue[k][m] == 'Q') {
                num++;
            }
            if (num >= 2)
                return false;
        }
        //判断列
        num = 0;
        for (int k = 0; k < end; k++) {
            if (queue[n][k] == 'Q')
                num++;
            if (num >= 2)
                return false;
        }

        num = 1;
        for (int i = n + 1, j = m - 1; i < end && j >= 0; i++, j--) {
            if (queue[i][j] == 'Q')
                num++;
            if (num >= 2)
                return false;
        }
        for (int i = n - 1, j = m + 1; i >= 0 && j < end; i--, j++) {
            if (queue[i][j] == 'Q')
                num++;
            if (num >= 2)
                return false;
        }

        num = 1;
        for (int i = n + 1, j = m + 1; i < end && j < end; i++, j++) {
            if (queue[i][j] == 'Q')
                num++;
            if (num >= 2)
                return false;
        }
        for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {
            if (queue[i][j] == 'Q')
                num++;
            if (num >= 2)
                return false;
        }
        return true;
    }
}
