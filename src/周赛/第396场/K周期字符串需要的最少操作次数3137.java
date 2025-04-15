package 周赛.第396场;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-05-09 09:33
 **/
public class K周期字符串需要的最少操作次数3137 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {

        HashMap<String, Integer> hsi = new HashMap<> ();
        //int start =
        int max = 0;
        for (int i = 0; i <= word.length (); i += k) {


            String substr = word.substring (i, i + k);
            hsi.computeIfPresent (substr, (key, v) -> {
                return v + 1;
            });
            hsi.computeIfAbsent (substr, (key) -> {
                System.out.println (key);
                return 1;
            });
            if (max > hsi.get (substr)) {
                max = hsi.get (substr);
            }

        }
        return word.length () / k - max;
    }

    @Test
    public void test() {
        minimumOperationsToMakeKPeriodic ("leetcodeleet", 4);
    }
}
