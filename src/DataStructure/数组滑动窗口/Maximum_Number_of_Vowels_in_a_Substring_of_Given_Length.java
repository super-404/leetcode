package DataStructure.数组滑动窗口;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-21 16:14
 **/
public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        while (right < s.length ()) {
            sum += isVowel (s.charAt (right));
            //窗口满了。考虑向前移动
            if (right - left + 1 == k) {
                ans = Math.max (ans, sum);
                sum -= isVowel (s.charAt (left));
                left++;
            }
            right++;
        }
        return ans;
    }

    int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }

    @Test
    public void test_basic() {
        String s = "leetcodeauieudjd";
        int k = 3;
        int res = new Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length ().maxVowels (s, k);
        assert (res == 3);
    }
}
