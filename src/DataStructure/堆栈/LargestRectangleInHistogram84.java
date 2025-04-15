package DataStructure.堆栈;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-18 22:07
 **/


public class LargestRectangleInHistogram84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {

            //先计算左右两边的最小值
            int len = heights.length;
            int l[] = new int[len];
            int r[] = new int[len];
            Arrays.fill (l, -1);
            Arrays.fill (r, len);
            Deque<Integer> di = new LinkedList<> ();
            //先从左往右
            for (int i = 0; i < len; i++) {
                //保存的下标，搞定
                while (!di.isEmpty () && heights[i] < heights[di.peek ()]) {
                    int cur = di.pop ();
                    r[cur] = i;
                }
                di.push (i);
            }
            System.out.println (l);
            di.clear ();
            //先从右往左
            for (int i = len - 1; i >= 0; i--) {
                //保存的下标，搞定
                while (!di.isEmpty () && heights[i] < heights[di.peek ()]) {
                    int cur = di.pop ();
                    l[cur] = i;
                }
                di.push (i);
            }
            int max = 0;
            System.out.println (r);
            for (int i = 0; i < len; i++) {
                max = Math.max (max, (heights[i] * (r[i] - l[i] - 1)));
            }
            return max;
        }
    }

    @Test
    public void test() {
        int a[] = {2, 1, 5, 6, 2, 3};
        int i = new Solution ().largestRectangleArea (a);
        System.out.println (i);
    }
}
