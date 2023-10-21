package DataStructure.动态规划.day_2020_7_21;

import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。   
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，
 * 非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-21 17:50
 **/
public class 三角形最小路径和120 {
    public static void main(String[] args) {

        int i = new Solution1 ().minimumTotal (
                new ArrayList<List<Integer>> () {
                    {
                        add (new ArrayList<Integer> () {
                            {
                                add (2);
                            }
                        });
                        add (new ArrayList<Integer> () {
                            {
                                add (3);
                                add (4);
                            }
                        });
                        add (new ArrayList<Integer> () {
                            {
                                add (6);
                                add (5);
                                add (7);
                            }
                        });
                        add (new ArrayList<Integer> () {
                            {
                                add (4);
                                add (1);
                                add (8);
                                add (3);
                            }
                        });

                    }
                }
        );
        System.out.println (i);

    }
}

class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.size ()];
        int min = 0;
        dp[0] = triangle.get (0).get (0);
        for (List<Integer> integerList : triangle) {
            if (integerList.size () == 1)
                continue;
            int size = integerList.size () - 1;
            dp[size] = dp[size - 1] + integerList.get (size);
            for (int i = size - 1; i >= 1; i--) {
                dp[i] = Math.min (dp[i - 1], dp[i]) + integerList.get (i);
            }
            dp[0] = dp[0] + integerList.get (0);
        }
        OptionalInt min1 = Arrays.stream (dp).min ();
        return min1.getAsInt ();
    }
}
