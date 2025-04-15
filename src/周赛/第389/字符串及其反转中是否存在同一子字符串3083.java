package 周赛.第389;

/**
 * @program: leetcode
 * @description: 给你一个字符串 s ，
 * 请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 * <p>
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 * @author: 饶嘉伟
 * @create: 2024-03-31 09:25
 **/
public class 字符串及其反转中是否存在同一子字符串3083 {
    //暴力
    public boolean isSubstringPresent(String s) {
        //获取两两字符串
        for (int i = 0; i <= s.length () - 2; i++) {
            StringBuilder subStr = new StringBuilder (s.substring (i, i + 2));
            if (s.contains (subStr.reverse ().toString ())) {
                return true;
            }
        }

        return false;
    }
}
