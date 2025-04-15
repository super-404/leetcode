package 华为机考;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-23 21:55
 **/
public class HJ20密码验证合格程序 {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext ()) { // 注意 while 处理多个 case
            String s = in.nextLine ();
            valid (s);
            //System.out.println (a + b);
        }
    }

    public static void valid(String s) {
        int num = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int specialCase = 0;
        for (int i = 0; i < s.length (); i++) {
            char c = s.charAt (i);

            if (Character.isDigit (c)) {
                num = 1;
            } else {
                if (Character.isLowerCase (c)) {
                    lowerCase = 1;
                } else {
                    if (Character.isUpperCase (c)) {
                        upperCase = 1;
                    } else {
                        specialCase = 1;
                    }
                }
            }
        }
        if (num == 1 && lowerCase == 1 && upperCase == 1 && specialCase == 1) {
            System.out.println ("yes");
        } else {
            System.out.println ("NG");
        }
        for (int i = 0; i < s.length (); i++) {
            for (int j = i + 3; j < s.length (); j++) {
                String remain = s.substring (j);
                if (remain.contains (s.substring (i, j))) {
                    System.out.println ("NG");
                    return;
                }
            }
        }
        System.out.println ("yes");
    }
}
