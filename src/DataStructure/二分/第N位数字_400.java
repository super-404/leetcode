package DataStructure.二分;

/**
 * @program: leetcode
 * @description: 给你一个整数 n ，
 * <p>
 * 请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]
 * <p>
 * 中找出并返回第 n 位上的数字。
 * @author: 饶嘉伟
 * @create: 2023-09-22 20:45
 **/

public class 第N位数字_400 {


    public int findNthDigit(int n) {
        int count = 9;

        int digit = 1;
        int base = 10;
        int total = 0;
        while (n > count) {

            //total += digit *count;
            n = n - digit * count;

            digit++;

            count *= base;
        }
        //count /= base;

        //多少位；
        n -= 1;

        int idx = n / digit;

        int num = (int) Math.pow (10, digit) + idx;

        int pos = digit - 1 - n % digit;
        while (pos > 0) {
            num /= 10;
            pos--;
        }
        return num % 10;
    }

    public static void main(String[] args) {
        int ans = new 第N位数字_400 ().findNthDigit (273);
        System.out.println (ans);
    }
}
