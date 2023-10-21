package DataStructure.动态规划;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-03-26 16:46
 **/
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String N = in.nextLine ();
        String s = in.nextLine ();
        new test1 ().solution (s);
    }

    public String solution(String s) {
        int len = s.length ();
        StringBuilder ans = new StringBuilder ();
        int[] a = new int[26];
        for (int i = 0; i < 26; i++) {

        }
        return ans.toString ();
    }

    public char suc(char c) {
        int i = c - 'a';
        return (char) (((i + 1) % 26) + 'a');
    }
}
