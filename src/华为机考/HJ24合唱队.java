package 华为机考;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-23 22:12
 **/
public class HJ24合唱队 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int len = in.nextInt ();
        int nums[] = new int[len];
        int i = 0;
        in.nextLine ();
        // 注意 hasNext 和 hasNextLine 的区别
        while (i < len) { // 注意 while 处理多个 case
            int a = in.nextInt ();
            nums[i++] = a;
            //System.out.println ();
            //int b = in.nextInt();
            //System.out.println(a + b);
        }
        //计算前向递增子序列
        int dp[] = new int[len];
        dp[0] = 1;
        for (int j = 1; j < len; j++) {
            for (int k = 0; k < j; k++) {
                if (nums[j] > nums[k]) {
//                   System.out.println (println);
                    dp[j] = Math.max (dp[k] + 1, dp[j]);
                } else {
                    dp[j] = Math.max (dp[j], 1);
                }
            }
        }
        //计算前向递增子序列
        int dpRight[] = new int[len];
        dpRight[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            for (int k = len - 1; k >= j; k--) {
                if (nums[j] > nums[k]) {
//                   System.out.println (println);
                    dpRight[j] = Math.max (dpRight[k] + 1, dpRight[j]);
                } else {
                    dpRight[j] = Math.max (dpRight[j], 1);
                }
            }
        }
        int max = 0;
        for (int j = 0; j < len; j++) {
            max = Math.max (dp[j] + dpRight[j], max);
        }
        System.out.println (len - max + 1);
    }
}
