import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-11-10 19:04
 **/
public class jianxinjinke {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型一维数组
     * @return int整型一维数组
     */
    public int[] solve(int[] arr) {
        // write code here
        HashMap<Integer, List<Integer>> hil = new HashMap<> ();
        for (int i = 0; i < arr.length; i++) {
            if (hil.containsKey (arr[i])) {
                List<Integer> integers = hil.get (arr[i]);
                integers.add (i + 1);
                hil.put (arr[i], integers);
            } else {
                ArrayList<Integer> l = new ArrayList<> ();
                l.add (i + 1);
                hil.put (arr[i], l);
            }

        }
        int ans[] = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                continue;
            }
            List<Integer> li = hil.get (arr[i]);
            if (li.size () != 2) {
                for (int j : li) {
                    ans[j - 1] = -1;
                }
            } else {
                int f = li.get (0);
                int g = li.get (1);
                ans[f - 1] = g;
                ans[g - 1] = f;
            }
        }
        return ans;
    }

    public long solve2(int[] arr) {
        // write code here
//        int n = arr.length;
//        int dp [] [] =new int [n][n];
//        for (int length  = 2 ; length <n ; length++) {
//            for (int i = 0; i <=n-length; i++) {
//                int j = i+length-1;
//                if(arr[i]==arr[j]){
//                    dp[i][j] = dp[i+1][j-1];
//                }else{
//                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1])+1;
//                }
//            }
//        }
//        return dp[n-2][n-1];
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        while (left < right) {

            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else if (right - 1 == left) {
                return -1;
            } else if (arr[left] < arr[right]) {
                ans += arr[right] - arr[left];
                arr[left + 1] += arr[right] - arr[left];
                arr[left] = arr[right];
            } else if (arr[left] > arr[right]) {
                ans += arr[left] - arr[right];
                arr[right - 1] += arr[left] - arr[right];
                arr[right] = arr[left];
            }
        }
        return ans;
    }

    public long solve3(int arr[]) {
        // write code here
        int n = arr.length;
        long dp[][] = new long[n][n];
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max (dp[i + 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[0][n - 1] - 1;
    }

    @Test
    public void test() {
        int t[] = {1, 2, 2, 2, 1};
        System.out.println (solve3 (t));
    }

}
