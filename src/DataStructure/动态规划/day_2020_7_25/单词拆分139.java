package DataStructure.动态规划.day_2020_7_25;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * <p>
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-25 14:13
 **/
public class 单词拆分139 {
    public static void main(String[] args) {
        System.out.println (new Solution ().wordBreak ("cars", new ArrayList<String> () {{
            add ("car");
            add ("ca");
            add ("rs");
        }}));
    }
}


//记忆化递归
//因为在递归的过程中会有很多重复的判断
class Solution {
    HashMap<String, Boolean> memory = new HashMap<> ();

    public boolean wordBreak(String s, List<String> wordDict) {

        if (memory.containsKey (s))
            return memory.get (s);
        if (s.length () == 0) {
            return true;
        }
        for (String entries : wordDict) {
            String prefix = entries;
            if (s.startsWith (prefix)) {
                String temp = new String (s);
                s = s.substring (prefix.length ());
                if (wordBreak (s, wordDict)) {
                    memory.putIfAbsent (s, true);
                    return true;
                }
                s = temp;
            }
        }
        //因此对于s字符串来讲是不可能有解的
        //所以下次只要它在出现，可以直接返回false;
        memory.put (s, false);
        return false;
    }
}

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet stringList = new HashSet<> (wordDict);

        int start = 0;
        int end = 0;
        boolean dp[] = new boolean[s.length () + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length (); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && stringList.contains (s.substring (j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length ()];
    }
}
