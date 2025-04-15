package DataStructure.数组滑动窗口;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-21 14:00
 **/
public class Grumpy_Bookstore_Owner1052 {
    /// 这道题翻译过来就是
    ///求解 k 区间内的customers数组对应的最大值
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = 0;
        int pre[] = new int[grumpy.length];
        pre[0] = grumpy[0] == 0 ? customers[0] : 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = grumpy[i] == 0 ? (customers[i] + pre[i - 1]) : pre[i - 1];
        }

        while (right < grumpy.length) {
            sum += customers[right];
            if (right - left + 1 == minutes) {
                //计算0-left-1的和

                int zero_left = left - 1 >= 0 ? pre[left - 1] : 0;
                //计算right+1 到 len的和
                int right_end = right + 1 < customers.length ? (pre[pre.length - 1] - pre[right]) : 0;

                ans = Math.max (ans, sum + zero_left + right_end);

                sum -= customers[left];
                left++;
            }
            right++;
        }
        return ans;

    }

    @Test
    public void test() {
        int c[] = new int[]{1, 0, 1, 2, 1, 1, 7, 5, 3, 4, 5, 6, 2, 8, 4, 3, 1};
        int g[] = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1};
        int m = 3;
        int r = new Grumpy_Bookstore_Owner1052 ().maxSatisfied (c, g, m);
        System.out.println (r);
    }

    @Test
    public void test_only_one_element() {
        int c[] = new int[]{1};
        int g[] = new int[]{0};
        int m = 1;
        int r = new Grumpy_Bookstore_Owner1052 ().maxSatisfied (c, g, m);
        //assertEquals();
        assert (r == 1);
        System.out.println (r);
    }
}
