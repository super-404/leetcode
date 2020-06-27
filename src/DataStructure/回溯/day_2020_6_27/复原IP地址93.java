package DataStructure.回溯.day_2020_6_27;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class 复原IP地址93 {
    public static void main(String[] args) {
        Solution s = new Solution ();
        for (String str :
                s.restoreIpAddresses ("0000")) {
            System.out.println (str);
        }
    }
}

class Solution {
    String str;
    ArrayList<String> ls = new ArrayList ();

    public List<String> restoreIpAddresses(String s) {
        //对于任意ip地址，长度都在4-12范围内，超出这个范围不可能有解
        if (s.length () < 4 || s.length () > 12) {
            return ls;
        }
        str = s;
        backTrack (0, new ArrayList<> (), 0);
        return ls;
    }

    public void backTrack(int start, List<String> point, int index) {

        if (point.size () > 0) {
            String test = point.get (point.size () - 1);

            Long num = Long.valueOf (point.get (point.size () - 1));
            if (num > 255) {
                return;
            }
            //0开头的长度不能超过1
            if (test.charAt (0) == '0' && test.length () > 1) {
                return;
            }
            //如果每个
            if (point.size () >= 3) {

                String s1 = "";
                Long fourth = 0L;

                //得到第四段
                String end = str.substring (index, str.length ());

                if (end.length () > 3) {
                    return;
                }
                //第三段的下标必须小于整个字符串长度
                if (index < str.length ()) {
                    fourth = Long.valueOf (end);
                } else {
                    return;
                }

                //
                if (end.charAt (0) == '0' && end.length () > 1) {
                    return;
                }
                //不能大于255
                if (fourth > 255) {
                    return;
                }
                //拼接字符串
                for (String i : point) {
                    s1 += i + ".";
                }
                s1 += str.substring (index, str.length ());
                ls.add (s1);
                return;
            }
        }
        for (int i = start; i < str.length (); i++) {
            String check = str.substring (start, i + 1);
            if (check.length () > 3) {
                return;
            }
            point.add (check);
            backTrack (i + 1, point, i + 1);
            point.remove (point.size () - 1);

        }
    }
}
