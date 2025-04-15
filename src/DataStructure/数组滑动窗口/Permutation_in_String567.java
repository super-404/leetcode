package DataStructure.数组滑动窗口;


import com.sun.javafx.image.IntPixelGetter;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * @program: leetcode
 * @description: Given two strings s1 and s2,
 * return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words,
 * <p>
 * return true if one of s1's permutations is the substring of s2.
 * @author: 饶嘉伟
 * @create: 2023-11-10 09:21
 **/

public class Permutation_in_String567 {

    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> hm = new HashMap ();
        for (int i = 0; i < s1.length (); i++) {
            char c = s1.charAt (i);
            if (hm.containsKey (c)) {
                hm.put (c, hm.get (c) + 1);
            } else {
                hm.put (c, 1);
            }
        }
        int left = 0;
        int right = 0;
        int k = s1.length ();
        while (right < s2.length ()) {
            char c = s2.charAt (right);
            if (hm.containsKey (c)) {
                hm.put (c, hm.get (c) - 1);
            }
            if (right - left + 1 == k) {
                boolean flag = true;
                for (Map.Entry<Character, Integer> entry : hm.entrySet ()) {
                    if (entry.getValue () != 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    return true;
                }
                //控制窗口向前
                char c1 = s2.charAt (left);
                if (hm.containsKey (c1)) {
                    hm.put (c1, hm.get (c1) + 1);
                }
                left++;
            }
            right++;
        }
        return false;
    }

    //    public void act(HashMap<Character, Integer> hm, char c) {
//        if (hm.containsKey (c)) {
//            hm.put (c, (Integer) hm.get (c) - 1);
//        }
//    }
    @Test
    public void test() {

        String s1 = "abc";

        String s2 = "bbbca";

        Permutation_in_String567 pi = new Permutation_in_String567 ();

        assertTrue (pi.checkInclusion (s1, s2));
    }
}
