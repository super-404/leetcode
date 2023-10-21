package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: Given two non-negative integers,
 * num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string.
 * <p>
 * You must solve the problem without using any built-in library
 * for handling large integers (such as BigInteger).
 * <p>
 * You must also not convert the inputs to integers directly.
 * @author: 饶嘉伟
 * @create: 2023-10-18 10:22
 **/
public class Add_Strings_415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length () - 1;
        int j = num2.length () - 1;
        int digit = 0;
        String s = "";
        while (i >= 0 || j >= 0) {
            int val1 = 0;
            if (i >= 0) {
                val1 = num1.charAt (i) - '0';
            }

            int val2 = 0;
            if (j >= 0) {
                val2 = num2.charAt (j) - '0';
            }

            int sum = val1 + val2 + digit;

            int m = sum % 10;
            digit = sum / 10;
            //String append = String. (m);
            s += m;
            i--;
            j--;
        }
        if (digit > 0) {
            s += digit;
        }
        return new StringBuilder (s).reverse ().toString ();
    }

    public static void main(String[] args) {
        String res = new Add_Strings_415 ().addStrings ("99", "99999");
        System.out.println (res);
    }
}
