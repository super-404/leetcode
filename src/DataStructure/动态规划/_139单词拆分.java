package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * @author: 饶嘉伟
 * @create: 2023-03-21 13:08
 **/

import java.util.ArrayList;
import java.util.List;

public class _139单词拆分 {
    public static void main(String[] args) {
        String s = "rusthahahaed";
        List<String> ls = new ArrayList<> ();
        ls.add ("ru");
        ls.add ("rust");
        ls.add ("haha");
        ls.add ("hahah");
        ls.add ("haed");
        System.out.println (new _139单词拆分 ().wordBreak (s, ls));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean flag = false;
        int start = 0;
        boolean dp[] = new boolean[s.length () + 1];
        dp[0] = true;
        for (int i = 1; i < s.length (); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring (j, i);
                if (dp[j] && wordDict.contains (sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length ()];
    }
}
