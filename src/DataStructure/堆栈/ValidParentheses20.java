package DataStructure.堆栈;

import org.junit.Test;
import org.junit.Assert;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * @author: 饶嘉伟
 * @create: 2023-12-17 11:36
 **/
public class ValidParentheses20 {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> sc = new Stack<> ();
            for (int i = 0; i < s.length (); i++) {
                char cur = s.charAt (i);
                if (cur == '(' || cur == '[' || cur == '{') {
                    sc.push (cur);
                } else {
                    if (sc.isEmpty ())
                        return false;
                    char popc = sc.pop ();
                    if (popc == '(' && cur != ')' || popc == '[' && cur != ']' || popc == '{' && cur != '}') {
                        return false;
                    }
                }
            }
            if (!sc.isEmpty ()) {
                return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        String s = "{)";
        boolean ans = new Solution ().isValid (s);
        System.out.println (ans);
        assert (ans);
    }
}
