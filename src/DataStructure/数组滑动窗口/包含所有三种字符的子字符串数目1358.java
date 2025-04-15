package DataStructure.数组滑动窗口;

import org.junit.Test;

import java.util.HashSet;

/**
 * @program: leetcode
 * @description: 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * 示例 1：
 * 输入：s = "abcabc"
 * 输出：10
 * <p>
 * <p>
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：  输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 * 输入：s = "abc"
 * 输出：1 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * @author: 饶嘉伟
 * @create: 2023-12-10 22:17
 **/
public class 包含所有三种字符的子字符串数目1358 {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int cs[] = new int[3];
        while (right < s.length ()) {
            char c = s.charAt (right);
            cs[c - 'a'] += 1;
            while (cs[0] > 0 && cs[1] > 0 && cs[2] > 0) {
                ans += s.length () - right;
                c = s.charAt (left);
                cs[c - 'a'] -= 1;
                left++;
            }
            right++;
        }

        return ans;
    }

    @Test
    public void test() {
        String s = "aaacb";
        int i = new 包含所有三种字符的子字符串数目1358 ().numberOfSubstrings (s);
        System.out.println (i);
    }
}

