package DataStructure.动态规划.线性dp;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-09 22:42
 **/
public class 统计打字方案数2266 {

    //
    public int countTexts(String pressedKeys) {
        int len = pressedKeys.length ();
        BigDecimal dp[] = new BigDecimal[len + 1];
        dp[0] = new BigDecimal (1);
        dp[1] = new BigDecimal (1);
        for (int i = 2; i < len + 1; i++) {
            dp[i] = new BigDecimal (0);
        }
        int continueChars = 1;
        for (int i = 1; i < len; i++) {

            char c = pressedKeys.charAt (i);
            char cf = pressedKeys.charAt (i - 1);

            if (c == cf) {
                continueChars++;
                if (c == '7' || c == '9') {
                    continueChars = Math.min (continueChars, 4);
                } else {
                    continueChars = Math.min (continueChars, 3);
                }
                for (int j = 1; j <= continueChars; j++) {
                    dp[i + 1] = new BigDecimal (dp[i + 1].add (dp[i + 1 - j]).toBigInteger ());
                }
                //dp[i+1] +=1;
            } else {
                // new BigDecimal ()
                dp[i + 1] = new BigDecimal (dp[i].toBigInteger ());
                continueChars = 1;
            }
        }
        int r = 1000000007;
        return dp[len].remainder (new BigDecimal (r)).intValue ();
        //return Integer.valueOf (res);
    }

    @Test
    public void test() {
        String str = "444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664";
        System.out.println (countTexts (str));
    }

    public void FindHouse(int[] house) {
        // write code here
        int len = house.length;
        int count[] = new int[len];
        ArrayList<Integer> res = new ArrayList<> ();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>> ();
        for (int i = 0; i < len; i++) {
            res.add (i);
        }
        for (int i = 0; i < len; i++) {
            if (house[i] == -1) {
                continue;
            }
            int left = i - house[i];
            int right = i + house[i];
            ArrayList<Integer> tmp = new ArrayList<> ();

            if (left >= 0) {
                tmp.add (left);
            }
            if (right <= len - 1) {
                tmp.add (right);
            }
            ans.add (tmp);
//            if(left>=0&&right<=len-1) {
//                if(count[left]==0&&count[right]==0) {
//                    count[left] = 1;
//                    count[right] = 1;
//                }
//            }else{
//                if(left<=0){
//                    count[right] = 1;
//                }else{
//                    count[left] = 1;
//                }
        }
//            if(left>=0&&right<=len-1&&count[left]==0&&count[right]==0){
//                count[left] = 1;
//            }
//            if(left>=0&&right<=len-1&&count[left]==0&&count[right]==0) {
//                count[right] = 1;
//            }


        // ArrayList<Integer> ans = new ArrayList<> ();
//        for (int i = 0; i < len; i++) {
//            if(count[i]!=0){
//                ans.add (i);
//            }
//        }
//       return 0;
    }
}
