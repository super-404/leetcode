package DataStructure.堆栈;

import org.junit.Test;

import javax.security.auth.callback.CallbackHandler;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-18 22:55
 **/
public class RemoveDuplicateLetters316 {
    class Solution {
        public String removeDuplicateLetters(String s) {

            TreeMap<Character, Integer> tc = new TreeMap<> ();
            for (int i = 0; i < s.length (); i++) {
                char c = s.charAt (i);
                tc.put (c, i);
            }
//            return tc.
            return null;
        }
    }

    @Test
    public void test() {
        String s = "bcabc";
        String s1 = new Solution ().removeDuplicateLetters (s);
        System.out.println (s1);
    }
}
