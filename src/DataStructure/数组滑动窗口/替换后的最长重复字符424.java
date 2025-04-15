package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description: 给你一个字符串 s 和一个整数 k 。
 * <p>
 * <p>
 * 你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。
 * 该操作最多可执行 k 次。
 * <p>
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 可能存在其他的方法来得到同样的结果
 * @author: 饶嘉伟
 * @create: 2023-12-08 14:36
 **/

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int charNum[] = new int[26];
        int count = 0;
        int max = -1;

        while (right < s.length ()) {
            int id = s.charAt (right) - 'A';
            charNum[id] += 1;
            //记录出现过的最多的单词
            max = Math.max (max, charNum[id]);
            if (right - left + 1 > max + k) {

                charNum[s.charAt (left) - 'A'] -= 1;
                left++;
            }
            count = Math.max (count, right - left);
            right++;
        }
        return count;
    }
}

public class 替换后的最长重复字符424 {

    public static void main(String[] args) {
        String s = "ABCD";
        int i = new Solution ().characterReplacement (s, 1);
        System.out.println (i);
    }
}
