package DataStructure.回溯.day_2020_7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 一个 「开心字符串」定义为：
 * 仅包含小写字母 ['DataStructure.a', 'DataStructure.b', 'c'].
 * 对所有在 1 到 s.length - 1 之间的 i ，
 * 满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。
 * 比方说，字符串 "abc"，"ac"，"DataStructure.b" 和 "abcbabcbcb" 都是开心字符串，
 * 但是 "aa"，"baa" 和 "ababbc" 都不是开心字符串。
 * 给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。
 * 请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，
 * 那么请你返回 空字符串
 *  
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-08 15:07
 **/
//示例 1：
//
//        输入：n = 1, k = 3
//        输出："c"
//        解释：列表 ["DataStructure.a", "DataStructure.b", "c"] 包含了所有长度为 1 的开心字符串。
//        按照字典序排序后第三个字符串为 "c" 。
//
public class 长度为n的开心字符串中字典序第k小的字符串1415 {
    public static void main(String[] args) {
        System.out.println (new Solution2 ().getHappyString (2, 4));
    }
}

class Solution2 {
    char[] happy = {'a', 'b', 'c'};
    List<String> happyStringList = new ArrayList<> ();

    public String getHappyString(int n, int k) {
        backTrack (n, new StringBuilder ());
        happyStringList.stream ()
                .sorted ()
                .forEach (s -> System.out.println (s));
        System.out.println ("================");
        Collections.sort (happyStringList);
        if (happyStringList.size () >= k) {
            return happyStringList.get (k - 1);
        }
        return "";
    }

    public void backTrack(int n, StringBuilder path) {
        if (path.length () == n) {
            happyStringList.add (path.toString ());
            return;
        }
        for (int i = 0; i < happy.length; i++) {

            //避免出现连续相同的两个字母
            if (path.length () >= 1 && path.charAt (path.length () - 1) == happy[i]) {
                continue;
            }
            path.append (happy[i]);

            backTrack (n, path);

            path.deleteCharAt (path.length () - 1);
        }
    }
}
