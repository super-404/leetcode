package BilibiliZuoChengYun;

/**
 * @program: leetcode
 * @description: nothing
 * @author: 饶嘉伟
 * @create: 2022-02-23 20:56
 **/
public class day_2022_2_23 {
    public day_2022_2_23() {

    }

    public static void main(String[] args) {
        String str = "123";
        String str1 = new String ("123");
        System.out.println (str1.equals (str));

    }

    //异或的运用，
    //1^1=0
    //1^0=1
    //所以偶数个相同的数相异或是0
    //剩下的就是我们要找的
    //这是找一个奇数
    public static void getOneOddNumber() {
        int test[] = new int[]{3, 3, 6, 6, 4, 5};
        int OddNumber = test[0];
        for (int i = 1; i < test.length; i++) {
            OddNumber = OddNumber ^ test[i];
        }
        System.out.println (OddNumber);
    }

    //找到两个不同的奇数个数的数
    //原理：a b  others
    //a b 分别代表有奇数个数的数 111 222
    //others 是其他的偶数
    //所以把这些数全部异或，
    //最后= a ^ b
    //
    public static void getTwoOddNumber() {
        int test[] = new int[]{3, 3, 6, 6, 4, 5};
        int OddNumber = test[0];
        for (int i = 1; i < test.length; i++) {
            OddNumber = OddNumber ^ test[i];
        }
        System.out.println (OddNumber);
    }
}
