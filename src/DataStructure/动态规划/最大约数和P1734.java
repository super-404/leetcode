package DataStructure.动态规划;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: # 最大约数和
 * <p>
 * ## 题目描述
 * <p>
 * 选取和不超过 $S$ 的若干个不同的正整数，使得所有数的约数（不含它本身）之和最大。
 * <p>
 * ## 输入格式
 * <p>
 * 输入一个正整数 $S$。
 * <p>
 * ## 输出格式
 * <p>
 * 输出最大的约数之和。
 * <p>
 * ## 样例 #1
 * <p>
 * ### 样例输入 #1
 * <p>
 * ```
 * 11
 * ```
 * <p>
 * ### 样例输出 #1
 * <p>
 * ```
 * 9
 * ```
 * <p>
 * ## 提示
 * <p>
 * **【样例说明】**
 * <p>
 * 取数字 $4$ 和 $6$，可以得到最大值 $(1+2)+(1+2+3)=9$。
 * <p>
 * **【数据规模】**
 * <p>
 * 对于 $100 \%$ 的数据，$1 \le S \le 1000$。
 * @author: 饶嘉伟
 * @create: 2024-10-25 08:31
 **/
public class 最大约数和P1734 {
    public static void main(String[] args) {
        solution ();
    }

    public static void solution() {
        Scanner in = new Scanner (System.in);
        int m = in.nextInt ();
        int v[] = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            v[i] = getDivisorSum (i);
        }
        int dp[] = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= i) {
                    dp[j] = Math.max (dp[j], dp[j - i] + v[i]);
                }
            }
        }
        System.out.println (dp[m]);
    }

    public static int getDivisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
