package DataStructure.回溯.day_2020_7_4;

/**
 * @program: leetcode
 * @description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-04 16:47
 **/

import java.util.*;
import java.util.stream.Collectors;

public class 单词拆分II140 {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList ("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println (new Solution3 ().wordBreak ("pineapplepenapple", ls));
    }
}

class Solution2 {
    List<List<String>> lls = new ArrayList<> ();
    String s;
    Set<String> wordDict;
    HashMap<Integer, String> his = new HashMap<> ();
    int minLength;
    int maxLength;
    int length = 0;

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty () || s.length () == 0) {
            return new ArrayList<String> ();
        }
        this.s = s;
        this.wordDict = new HashSet<> (wordDict);
//        //把排序方便得到最短长度或者最长长度
//        wordDict = wordDict.stream ()
//                .sorted ((a, b) -> {
//                    if (a.length () > b.length ()) {
//                        return 1;
//                    } else if (a.length () < b.length ())
//                        return -1;
//                    else {
//                        return 0;
//                    }
//                })
//                .collect (Collectors.toList ());
//        minLength = wordDict.get (0).length ();
//        maxLength = wordDict.get (wordDict.size () - 1).length ();

        backTrack (0, new ArrayList<String> ());

        List<String> stringList =
                lls.stream ()
                        .map (ls -> ls.stream ().collect (Collectors.joining (" ")))
                        .collect (Collectors.toList ());
        return stringList;
    }

    public void backTrack(int start, ArrayList<String> strings) {
        if (length == s.length ()) {
            lls.add (new ArrayList<> (strings));
            return;
        }
        for (int i = start; i < s.length (); i++) {
            String waitCheck = s.substring (start, i + 1);

//            if ( waitCheck.length () < minLength)
//                continue;
//            if(maxLength < waitCheck.length ()){
//                return;
//            }
            if (wordDict.contains (waitCheck)) {
                strings.add (waitCheck);
                length += waitCheck.length ();
                if (i + 1 == s.length ()) {
                    his.put (start, waitCheck);
                }
                if (his.containsKey (i + 1)) {
                    strings.add (his.get (i + 1));
                    lls.add (new ArrayList<> (strings));
                    strings.remove (strings.size () - 1);
                }
            } else {
                continue;
            }
            backTrack (i + 1, strings);
            String ss = strings.remove (strings.size () - 1);
            length -= ss.length ();
        }
    }
}

class Solution3 {
    Map<String, List<String>> cuttingCache = new HashMap<> ();

    /**
     * s--> 拆分成prefix s.subString(prefix.length())
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> cuttingResult = cuttingCache.get (s);
        if (cuttingResult != null) {
            return cuttingResult;
        }

        List<String> result = new ArrayList<> ();
        for (String prefix : wordDict) {

            if (!s.startsWith (prefix)) {
                continue;
            }

            String left = s.substring (prefix.length ());
            if (left.length () == 0) {
                result.add (prefix);
                continue;
            }

            List<String> childResult = wordBreak (left, wordDict);
            if (childResult == null) {
                continue;
            }
            for (String child : childResult) {
                result.add (prefix + " " + child);
            }
        }
        cuttingCache.put (s, result);
        return result;
    }

}
