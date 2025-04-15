package DataStructure.动态规划.线性dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-08 23:14
 **/
public class 最长的斐波那契子序列的长度873 {
    public int lenLongestFibSubseq(int[] arr) {
        //********* 方法1 ***************
        HashMap<Integer, Integer> hii = new HashMap<> ();
        for (int i = 0; i < arr.length; i++) {
            hii.put (arr[i], i);
        }
        int max = 0;
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = i + 1; j < arr.length; j++) {
//                int tempJ = arr[j];
//                int tempI = arr[i];
//                int res = 2;
//                while (hii.containsKey (tempJ + tempI)) {
//                    int idx = hii.get (tempJ + tempI);
//                    tempI = tempJ;
//                    tempJ = arr[idx];
//                    res++;
//                }
//                max = max > res ? max : res;
//            }
//        }
//        return max >= 3 ? max : 0;

//          *********** 方法2 ******************

        int len = arr.length;
        int dp[][] = new int[len][len];
        Arrays.stream (dp).forEach ((a) -> Arrays.fill (a, 2));
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tempJ = arr[j];
                int tempI = arr[i];
                if (hii.containsKey (tempJ + tempI)) {
                    int idx = hii.get (tempJ + tempI);
                    dp[j][idx] = dp[i][j] + 1;
                    max = max > dp[j][idx] ? max : dp[j][idx];
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println (lenLongestFibSubseq (a));
    }
}
