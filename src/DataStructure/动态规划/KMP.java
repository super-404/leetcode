package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-07-16 19:02
 **/
public class KMP {
    private final int R;
    private int[][] dfa;//记录文本和模式不匹配时候，模式指针退回多远的值

    private char[] pattern;
    private String pat;

    public KMP(String pat) {
        this.R = 256;
        this.pat = pat;

        int m = pat.length ();
        dfa = new int[R][m];
        dfa[pat.charAt (0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                //不匹配 文本i位置的可以是除匹配字符以外的任意字符，但在此位置的重启状态X都是一样的
                dfa[c][j] = dfa[c][x];
            }

            //匹配,就是说只有dfa[pat.charAt(j)][j]的项才会使状态前进，不匹配的都会经重新状态X转到合适的位置
            dfa[pat.charAt (j)][j] = j + 1;
            x = dfa[pat.charAt (j)][x];//更新X 不同状态，对应的重启状态X不一样
        }
    }

    public KMP(char[] pattern, int R) {
        this.R = R;
        this.pattern = new char[pattern.length];
        for (int j = 0; j < pattern.length; j++) {
            this.pattern[j] = pattern[j];
        }

        int m = pattern.length;
        dfa = new int[R][m];
        dfa[pattern[0]][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];//不匹配
            }
            dfa[pattern[j]][j] = j + 1;//匹配
            x = dfa[pattern[j]][x];//模式不同位置，对应的重启状态X不一样
        }
    }

    public int search(String txt) {
        int m = pat.length ();
        int n = txt.length ();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            //只有dfa[txt.charAt(i)][j]==dfa[pat.charAt(j)][j],j才会等于j+1,即匹配。其他的情况，j会退回到之前的位置
            j = dfa[txt.charAt (i)][j];
        }
        if (j == m) return i - m;//发现
        return n;//未发现
    }

    public int search(char[] text) {
        int m = pattern.length;
        int n = text.length;
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[text[i]][j];
        }
        if (j == m) return i - m;//发现
        return n;//未发现
    }

    public static void main(String[] args) {

    }
}
