package DataStructure.堆栈;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-17 14:07
 **/
public class 每日温度730 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> si = new LinkedList<> ();
            //Stack<Integer> ssi =new Stack<> ();
            int ans[] = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                if (si.isEmpty ()) {
                    si.push (i);
                } else {
                    int cur = temperatures[i];
                    //如果当前元素比栈顶的元素还要大。说明找到了
                    while (!si.isEmpty () && cur > temperatures[si.peek ()]) {
                        int prev = si.pop ();
                        ans[prev] = i - prev;
                    }
                    //栈里的元素处理完之后保存当前的下标
                    si.push (i);
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        int[] s = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new Solution ().dailyTemperatures (s);
        System.out.println (Arrays.toString (ans));
        // assert (ans);
    }
}
