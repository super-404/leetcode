package DataStructure.散列表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-04 14:56
 **/
public class 子域名访问计数811 {
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> his = new HashMap<> ();
        //将数字和字符串且分开来
        for (String s : cpdomains) {
            String[] strs = s.split (" ");

            int count = Integer.parseInt (strs[0]);

            //切分域名方便拼接
            String[] cpstrs = strs[1].split ("\\.");

            for (int i = 0; i < cpstrs.length; i++) {
                String s1 = "";

                //拼接字符串

                for (int j = i; j < cpstrs.length; j++) {
                    s1 += "." + cpstrs[j];
                }
                s1 = s1.substring (1, s1.length ());
                his.computeIfPresent (s1, (key, value) -> {
                    return value + count;
                });
                his.computeIfAbsent (s1, (key) -> {
                    return count;
                });
            }
        }

        List<String> ls = new ArrayList<> ();
        his.forEach ((key, value) -> {
            ls.add (value + " " + key);
        });
        return ls;
    }

    public static void main(String[] args) {
        String s[] = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> ls = new 子域名访问计数811 ().subdomainVisits (s);
        System.out.println (ls.toString ());
        String str = "5.1";
        System.out.println (Arrays.toString (str.split ("\\.")));
    }

}
