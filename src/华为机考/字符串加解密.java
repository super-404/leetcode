package 华为机考;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-24 10:01
 **/
public class 字符串加解密 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        String s2 = in.nextLine ();
        for (int i = 0; i < s1.length (); i++) {
            char c = s2.charAt (i);
            if (Character.isLowerCase (c)) {
                System.out.print ((char) ((c - 'a' + 1) % 26 + 'A'));
            } else if (Character.isUpperCase (c)) {
                System.out.print ((char) ((c - 'A' + 1) % 26 + 'a'));
            } else if (Character.isDigit (c)) {
                int num = Integer.parseInt (String.valueOf (c));
                System.out.print (num + 1);
            } else {
                System.out.print (c);
            }
        }
        System.out.println ();
        for (int i = 0; i < s2.length (); i++) {
            char c = s2.charAt (i);
            if (Character.isLowerCase (c)) {
                System.out.print ((char) ((c - 'a' - 1) % 26 + 'A'));
            } else if (Character.isUpperCase (c)) {
                System.out.print ((char) ((c - 'A' - 1) % 26 + 'a'));
            } else if (Character.isDigit (c)) {
                int num = Integer.parseInt (String.valueOf (c));
                System.out.print (num - 1);
            } else {
                System.out.print (c);
            }
        }
    }
}
