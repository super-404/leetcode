package DataStructure.回溯.day_2020_7_2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 * 我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @author: 饶嘉伟
 * @create: 2020-07-02 16:37
 **/
public class 字母大小写全排列784 {
    public static void main(String[] args) {
//        String s = "acb2";
//        Solution solution = new Solution ();
//        System.out.println (solution.letterCasePermutation (s));

        List<String> ls = new ArrayList<String> ();
        ls.remove (ls.size () - 1);
    }
}


//回溯解法
class Solution {

    Set<String> strings = new HashSet<> ();
    int length;

    public List<String> letterCasePermutation(String S) {
        length = S.length ();
        List<String> path = new ArrayList<> ();
        path.add (S);
        char[] chs = S.toCharArray ();
        backtrack (0, chs);
        List<String> res = new ArrayList<> (strings);
        return res;
    }

    public void backtrack(int start, char[] path) {
        strings.add (String.valueOf (path));
        for (int i = start; i < length; i++) {
            //如果是大写字母变成小写
            if (Character.isUpperCase (path[i])) {
                path[i] = (char) (path[i] + 32);
                //如果这个模式已经存在了，跳过
                if (strings.contains (path)) {
                    continue;
                }
                //
                backtrack (i + 1, path);
                path[i] = (char) (path[i] - 32);
            }
            //小写变大写
            if (Character.isLetter (path[i])) {
                path[i] = (char) (path[i] - 32);
                if (strings.contains (path)) {
                    continue;
                }
                backtrack (i + 1, path);
                path[i] = (char) (path[i] + 32);
            }
        }
    }
}

//迭代的方法
/*
思路

        从左往右依次遍历字符，过程中保持 ans 为已遍历过字符的字母大小全排列。

        例如，当 S = "abc" 时，考虑字母 "DataStructure.a", "DataStructure.b", "c"，初始令 ans = [""]，
        依次更新 ans = ["DataStructure.a", "A"]，
        ans = ["ab", "Ab", "aB", "AB"]，
        ans = ["abc", "Abc", "aBc", "ABc", "abC", "AbC", "aBC", "ABC"]。

        作者：LeetCode
        链接：https://leetcode-cn.com/problems/letter-case-permutation/solution/zi-mu-da-xiao-xie-quan-pai-lie-by-leetcode/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

//时间花费比上面的回溯要多一些
class Solution1 {

    public List<String> letterCasePermutation(String S) {
        int length = S.length ();
        ArrayList<StringBuilder> list = new ArrayList<> ();
        list.add (new StringBuilder ());
        for (int i = 0; i < S.length (); i++) {
            int n = list.size ();
            char ch = S.charAt (i);
            if (Character.isLetter (ch)) {
                for (int j = 0; j < n; j++) {

                    //把前面的复制到后面
                    list.add (new StringBuilder (list.get (j)));
                    list.get (j).append (Character.toLowerCase (ch));
                    list.get (n + j).append (Character.toUpperCase (ch));


                }
            } else {
                for (int k = 0; k < n; k++) {
                    list.get (k).append (ch);
                }
            }
        }
        List<String> res = list.stream ()
                .map ((s) -> s.toString ())
                .collect (Collectors.toList ());
        return res;
    }
}
