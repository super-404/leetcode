package 华为机考;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-11 11:01
 **/
public class HJ1字符串最后一个单词的长度 {
    public static void main(String[] args) {
        String s1 = "0x1504";
        int res = 0;
        for (int i = s1.length () - 1; i >= 2; i--) {
            char c = s1.charAt (i);
            if ('0' <= c && c <= '9') {
                res += Math.pow (16, s1.length () - i - 1) * (c - '0');
            } else {
                res += Math.pow (16, s1.length () - i - 1) * ((c - 'A') + 10);
            }
        }
    }
}

