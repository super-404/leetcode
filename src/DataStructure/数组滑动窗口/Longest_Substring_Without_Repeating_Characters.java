package DataStructure.数组滑动窗口;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @program: leetcode
 * @description: Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation:
 * The answer is "abc", with the length of 3.
 * @author: 饶嘉伟
 * @create: 2023-10-21 10:19
 **/
public class Longest_Substring_Without_Repeating_Characters {


    public int lengthOfLongestSubstring(String s) {
        if (s.length () < 0) {
            return 0;
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        HashMap hm = new HashMap<Character, Integer> ();
        while (right < s.length ()) {
            Character c = (Character) s.charAt (right);
            if (hm.containsKey (c)) {
                //left 要保证往前走，但是因为使用hash,没有删除前面一部分，因此可能出现重复值在前面，
                //导致left回退了，所以需要取left最大值， 例如abcbbcabc。
                // 两个a之间是重复的
                left = Math.max (left, (int) hm.get (c) + 1);
            }
            hm.put (c, right);
            ans = Math.max (ans, right - left + 1);
            right++;
        }
        return ans;
    }

    //
    public static void main(String[] args) {

        int s = new Longest_Substring_Without_Repeating_Characters ().lengthOfLongestSubstring ("tmmzuxt");
        System.out.println (s);
    }

}
