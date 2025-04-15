import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-20 10:22
 **/
public class 小美喜欢的工号23 {
    public static void main(String[] args) {
        new 小美喜欢的工号23 ().solution3 ();
        // System.out.println (i);
    }

    public void solution3() {
        Scanner in = new Scanner (System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        int len = in.nextInt ();
        int i = 0;
        in.nextLine ();
        while (i < len) {

            int n = in.nextInt ();
            int k = in.nextInt ();
            in.nextLine ();
            String s = in.nextLine ();
            String t = in.nextLine ();
            int min = 0;

            for (int j = 0; j < s.length (); j++) {
                char cs = s.charAt (j);
                char ct = t.charAt (j);
                if (cs != ct) {
                    if (cs < ct) {
                        min += ct - cs;
                    } else {
                        min += ct - 'a' + 'z' - cs + 1;
                    }
                }
            }
            System.out.println (min);
            if ((k - min) % 26 == 0) {
                System.out.println ("yes");
            } else {
                System.out.println ("no");
            }
            i++;
        }
    }

    public long solution2() {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine ();
        int[] pre = new int[s.length () - 1];
        long max = 0;
        //切割
        for (int i = 0; i < pre.length; i++) {
            if (s.charAt (i) == '-') {
                continue;
            }
            long a = Long.parseLong (s.substring (0, i + 1));
            long b = Long.parseLong (s.substring (i + 1));
            max = Math.max (max, a + b);
        }
        return max;
    }

    public void solution1() {
        Scanner in = new Scanner (System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int len = in.nextInt ();
        int i = 0;
        in.nextLine ();

//        boolean flag = true;
        while (i <= len) {
            boolean flag = true;
            String s = in.nextLine ();
            HashSet<String> hm = new HashSet<> ();
            // s.matches ()
            for (int j = 0; j < s.length (); j++) {
                char c = s.charAt (j);
                if (!Character.isLetter (c)) {
                    flag = false;
                }
                if (Character.isLowerCase (c) || (j >= 1 && s.charAt (j) == s.charAt (j - 1))) {
                    flag = false;
                } else {
                    for (int k = 0; k < s.length (); k++) {
                        for (int l = k + 1; l < s.length (); l++) {
                            String s1 = s.substring (k, k + 1);
                            String s2 = s.substring (l, l + 1);
                            if (hm.contains (s1 + s2) || hm.contains (s2 + s1))
                                flag = false;
                            else
                                hm.add (s1 + s2);
                        }
                    }
                }
            }
            if (flag)
                System.out.println ("yes");
            else {
                System.out.println ("no");
            }
            i++;
        }
    }

    @Test
    public void test() {
        System.out.println (Integer.parseInt ("-98"));
    }
}
