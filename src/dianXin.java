/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-26 09:00
 **/
public class dianXin {
    public static void main(String[] args) {
        int a[] = {1, 2};

        System.out.println (kinterval (a, 2, 1));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @return int整型
     */
    public static int seven_good_number(int n) {
        // write code here
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (check (i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean check(int n) {
        int end = 0;
        int start = 0;
        end = n % 10;
        int count = 1;
        int temp = n;
        while (temp >= 10) {
            temp = temp / 10;
            count *= 10;
        }
        start = n / count;
        if (start == 7 && end == 7) {
            return true;
        }
        return false;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组
     * @param x int整型
     * @param k int整型
     * @return long长整型
     */
    public static int kinterval(int[] a, int x, int k) {
        // write code here
        int ans = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < a.length) {
            if (a[right] % x == 0) {
                // ans++;
                count++;
            }
            while (count > k && left < a.length) {

                if (a[left] % x == 0) {
                    count--;
                }
                left++;
            }

            if (count == k && k == 0) {
                ans += right - left + 1;
            }

            right++;

            if (count == k && k != 0) {
                int tleft = left;
                while (tleft < right && a[tleft] % x != 0) {

                    tleft++;
                }
                ans += (tleft - left) + 1;

            }

        }
        return ans;
    }


}
