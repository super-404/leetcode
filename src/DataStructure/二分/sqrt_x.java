package DataStructure.二分;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-09-21 10:00
 **/
public class sqrt_x {
    public static void main(String[] args) {

        int x = new sqrt_x ().mySqrt (1);
        System.out.println (x);
    }

    public int mySqrt(int x) {
        int temp = x;

        int l = 0;

        int r = x;

        int ans = x;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
