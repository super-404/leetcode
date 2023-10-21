package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2022-10-26 23:43
 **/
public class 解码方法91 {

    public static void main(String[] args) {
        System.out.println (numDecodings ("021216"));
    }

    //对于一串码中的每个字符，我们可以单独解释，也可以将每个字符与前一个合并起来解释
    //只要合格就行
    public static int numDecodings(String s) {
        int len = s.length ();
        if (len == 0)
            return 0;
        int dp[] = new int[len];

        if (s.charAt (0) == '0') {
            return 0;
        }
        dp[0] = 1;

        if (len <= 1) {
            return dp[0];
        }
        if (s.charAt (1) != '0') {
            if (s.charAt (0) == '2' && s.charAt (1) > '6')
                dp[1] = dp[0];
            else
                dp[1] = dp[0] + 1;
        } else {
            dp[1] = dp[0];
        }
        for (int i = 2; i < len; i++) {
            char t = s.charAt (i);
            if (t != '0') {
                if (s.charAt (i - 1) == '2' && s.charAt (i) > '6')
                    dp[i] = dp[i - 1];
                else
                    dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}
