package 每日一题;

import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-08 22:14
 **/
public class 旅行终点站1436 {

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> hss = new HashMap<String, String> ();
        for (List<String> ls : paths) {
            hss.put (ls.get (0), ls.get (1));
        }
        String ans = "";
        for (String s : hss.values ()) {
            if (!hss.containsKey (s)) {
                return s;
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = prices[len - 1];

        int ans = 0;
        if (len == 1)
            return ans;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
