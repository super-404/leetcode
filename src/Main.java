import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-15 19:30
 **/
public class Main {
    public static void solution1() {
        Scanner in = new Scanner (System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt ();
        int a[][] = new int[n][4];
        int b[] = new int[n];
        int i = 0;

        while (i < n) {
            int j = 0;
            while (j < 4) {
                a[i][j] = in.nextInt ();
                j++;
            }
            b[i] = in.nextInt ();
            in.nextLine ();
            i++;
        }
//        for (int k = 0; k < n; k++) {
//            System.out.println (Arrays.toString (a[k]));
//        }

        for (int j = 0; j < n; j++) {

            for (int k = 0; k < b[j]; k++) {
                Arrays.sort (a[j]);
                a[j][0]++;
            }
            int ans = 1;
            for (int k = 0; k < 4; k++) {
                ans = ans * a[j][k];
            }
            System.out.println (ans);

        }
        //  System.out.println (Arrays.toString (b));

    }

    public static void solution2() {
        Scanner in = new Scanner (System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt ();
        int m = in.nextInt ();
        //int a[][] = new int[n][4];
        int x[] = new int[m];
        int c[] = new int[n];

        int count[] = new int[m + 1];
        count[0] = n;
        int ans = 1;
        for (int i = 0; i < m; i++) {
            x[i] = in.nextInt ();
        }

//        for (int i = 0; i < m; i++) {
//            int temp =x[i];
//            int res =1;
//            for (int j = 0; j < i; j++) {
//                if(x[i]<x[j]){
//                   res++;
//                }
//            }
//            System.out.print (res+1);
//        }
        for (int i = 0; i < m; i++) {
            int max = x[i];
            boolean flag = false;
            ans++;
            for (int j = 0; j < max; j++) {
                int temp = c[j];
                if (c[j] < i + 1) {

                    count[i + 1]++;
                    count[temp]--;

                    if (count[temp] == 0) {
                        ans--;
                    }
                    c[j] = i + 1;
                }
            }

            System.out.print (ans);
        }
    }

    public static void main(String[] args) {
        solution2 ();

    }
//    @Test
//    public void test1(){
//        solution1();
//    }
}
