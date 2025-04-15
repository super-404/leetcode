import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-07 10:20
 **/

/**
 * 2
 * 7
 * 1 2
 * 1 3
 * 3 5
 * 3 7
 * 2 4
 * 2 6
 * 7
 * 1 2
 * 1 3
 * 3 5
 * 3 7
 * 2 4
 * 2 6
 */

public class 美团笔试1 {
    public static void main(String[] args) {
        new 美团笔试1 ().q2 ();
    }

    public void q1() {

        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int a[] = new int[n];
        // 注意 hasNext 和 hasNextLine 的区别
        int i = 0;
        while (i < n) { // 注意 while 处理多个 case
            int b = in.nextInt ();
            a[i++] = b;
        }
        //偶数之和
        int e = 0;

        int ecount = 0;
        //奇数之和
        int o = 0;
        int ocount = 0;
        for (int j = 0; j < n; j++) {
            if (a[j] % 2 == 0) {
                e += a[j];
                ecount++;
            } else {
                o += a[j];
                ocount++;
            }
        }
        if (e < o) {
            System.out.println (e + ecount);
        } else {
            System.out.println (o + ocount);
        }
    }

    @Test
    public void test() {

    }
//    public int[] sortedSquares(int[] nums) {
//        List<Integer> ai = new ArrayList<>();
//        for(int i = 0 ;i<nums.length;i++){
//            ai.add(nums[i]*nums[i]);
//        }
//        Collections.sort(ai);
//        reut
//       // return ai();
//    }

    int num[] = new int[101];
    HashMap<Integer, Integer> hii = new HashMap<> ();

    public void q2() {
        Scanner in = new Scanner (System.in);
        int t = in.nextInt ();
        int k = 0;
        while (k < t) {
            int n = in.nextInt ();
            int[][] tree = new int[101][101];
            // int i  = 0;
            for (int j = 0; j < n - 1; j++) {
                int x = in.nextInt ();
                int y = in.nextInt ();
                tree[x][y] = 1;
            }
            dfs (tree, 1);
            for (int i = 1; i <= n; i++) {
                hii.computeIfPresent (num[i], (a, b) -> {
                    return b + 1;
                });
                hii.computeIfAbsent (num[i], (a) -> {
                    return 1;
                });
            }
            int res = 0;
            for (Integer li : hii.values ()) {
                res += ((li - 1) * li) / 2;
            }
            System.out.println (res);
            Arrays.fill (num, 0);
            hii.clear ();
            k++;
        }
    }

    public int dfs(int[][] tree, int root) {
        for (int i = 0; i < 101; i++) {
            if (tree[root][i] != 0) {
                num[root] += 1;

                dfs (tree, i);
            }
        }
        return num[root];
    }
}
