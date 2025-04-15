/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 15:18
 **/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class diandian {
    static class P {
        int t, h, l;

        P(int t, int h, int l) {
            this.t = t;
            this.h = h;
            this.l = l;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int d = scanner.nextInt ();
        int g = scanner.nextInt ();
        P[] c = new P[g + 1];

        for (int i = 1; i <= g; i++) {
            int t = scanner.nextInt ();
            int l = scanner.nextInt ();
            int h = scanner.nextInt ();
            c[i] = new P (t, h, l);
        }

        Arrays.sort (c, 1, g + 1, Comparator.comparingInt (a -> a.t));

        int[] f = new int[d + 1];
        Arrays.fill (f, 0);
        f[0] = 10;
        boolean flag = false;
        int ans = 0;
        for (int i = 1; i <= g; i++) {
            for (int j = d; j >= 0; j--) {
                if (f[j] >= c[i].t) {
                    if (j + c[i].h >= d) {
                        // System.out.println(c[i].t);
                        flag = true;
                        ans = c[i].t;
                        // return;
                    }
                    f[j + c[i].h] = Math.max (f[j + c[i].h], f[j]);
                    f[j] += c[i].l;
                }
            }
            System.out.println (Arrays.toString (f));
        }

        System.out.println (f[0]);
    }
}


