package DataStructure.回溯.day_2020_7_3;

/**
 * @program: leetcode
 * @description: 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，
 * 字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
 * @author: 饶嘉伟
 * @create: 2020-07-03 15:35
 **/

import java.math.BigInteger;
import java.util.*;

public class 累加数306 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis ();
        String str = "19910099101";
        new Solution1 ().isAdditiveNumber (str);
        long endTime = System.currentTimeMillis ();
        System.out.println ("花费：" + (endTime - startTime));
    }
}

class Solution1 {
    String str;
    boolean flag;

    public boolean isAdditiveNumber(String num) {
        List<String> path = new ArrayList<> ();
        str = num;
        backtrack (0, path);
        return flag;
    }

    public boolean check(List<String> path) {
        int n = path.size ();
        String s1 = path.get (n - 3);
        String s2 = path.get (n - 2);
        String s3 = path.get (n - 1);
        int result[] = new int[Math.max (s1.length (), s2.length () + 1)];
        int s1end = s1.length () - 1;
        int s2end = s2.length () - 1;
        int resultLength = result.length - 1;
        while (s1end >= 0 && s2end >= 0) {
            result[resultLength--] = s1.charAt (s1end--) - '0' + s2.charAt (s2end--) - '0';
        }
        while (s1end >= 0) {
            result[resultLength--] = s1.charAt (s1end--) - '0';
        }
        while (s2end >= 0) {
            result[resultLength--] = s2.charAt (s2end--) - '0';
        }
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] = result[i - 1] + result[i] / 10;
                result[i] = result[i] % 10;
            }
        }
        String s = "";
        int k = 0;
        while (result[k++] == 0) ;
        for (int i = k - 1; i < result.length; i++) {
            s += String.valueOf (result[i]);
        }
        if (!s.equals (s3)) {
            return false;
        }
        return true;
    }

    public void backtrack(int start, List<String> path) {
        if (path.size () >= 3) {
            if (!check (path)) {
                return;
            }
            long sum = path.stream ()
                    .map (String::length)
                    .reduce (0, Integer::sum);
            if (sum == str.length ()) {
                System.out.println (path);
                flag = true;
            }
        }
        for (int i = start; i < str.length (); i++) {
            String check = str.substring (start, i + 1);
            if ((check.charAt (0) == '0' && check.length () > 1)) {
                continue;
            }
            path.add (check);
            backtrack (i + 1, path);
            path.remove (path.size () - 1);
        }
    }
}
