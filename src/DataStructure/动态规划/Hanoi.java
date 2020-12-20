package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-07-15 19:11
 **/
public class Hanoi {

    public static void main(String[] args) {
        int nDisks = 3;
        doTowers (nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println ("Disk 1 from "
                    + from + " to " + to);
        } else {
            doTowers (topN - 1, from, to, inter);
            System.out.println ("Disk "
                    + topN + " from " + from + " to " + to);
            doTowers (topN - 1, inter, from, to);
        }
    }

}
