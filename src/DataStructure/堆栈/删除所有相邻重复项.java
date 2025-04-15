package DataStructure.堆栈;

import org.junit.Test;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * @author: 饶嘉伟
 * @create: 2023-12-17 13:23
 **/


//类似于消消乐
public class 删除所有相邻重复项 {
    class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> sc = new Stack<> ();
            for (int i = 0; i < s.length (); i++) {
                char c = s.charAt (i);
                if (sc.isEmpty ()) {
                    sc.push (c);
                } else {
                    char popc = sc.peek ();
                    if (popc == c) {
                        sc.pop ();
                    } else {
                        sc.push (c);
                    }
                }
            }
            return sc.stream ().map ((c) -> {
                return c.toString ();
            }).collect (Collectors.joining ());
        }
    }

    @Test
    public void test() {
        String s = "abbaccaadf";
        String ans = new Solution ().removeDuplicates (s);
        System.out.println (ans);
        // assert (ans);
    }
}
