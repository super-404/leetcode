package 周赛.第396场;


import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-05-09 09:50
 **/
public class 同位字符串连接的最小长度3138 {
    public int minAnagramLength(String s) {
        //检查所有的因子
        int n = s.length ();
        ArrayList<Integer> ai = new ArrayList<> ();
        int[] divisorNum = new int[n / 2];
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                ai.add (i);
            }
        }

        for (Integer i : ai) {
            int c[] = new int[26];
            for (int j = 0; j < i; j++) {
                c[s.charAt (j) - 'a']++;
            }

            boolean flag = false;
            //考虑每一个分组
            for (int j = i; j < s.length (); j += i) {
                int c1[] = new int[26];
                for (int k = j; k < j + i; k++) {
                    c1[s.charAt (k) - 'a']++;
                }

                for (int k = 0; k < 26; k++) {
                    if (c[k] != c1[k]) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                return i;
            }
        }
        return s.length ();
    }

    @Test
    public void test() {
        System.out.println (minAnagramLength ("aabb"));
    }
}
