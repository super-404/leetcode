package DataStructure.动态规划.day_2020_7_18;

/**
 * @program: leetcode
 * @description: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-18 16:53
 **/
public class 解码方法91 {
    public static void main(String[] args) {

        new Solution2 ().numDecodings ("11110");
    }
}

class Solution2 {
    public int numDecodings(String s) {
        if (s.length () == 0) {
            return 0;
        }
        int dp[] = new int[s.length () + 1];
        if (s.charAt (0) <= '9' && s.charAt (0) > '0')
            dp[0] = 1;
        else
            return 0;
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == '0') {
                dp[i + 1] = 0;
            } else {
                dp[i + 1] = dp[i];
            }
            if (i > 0 && (s.charAt (i - 1) == '1' || (s.charAt (i - 1) == '2' && s.charAt (i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length ()];
    }
}

/**
 * 上楼梯的复杂版？
 * 如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
 * 1.一位数决定一个字母
 * 2.两位数决定一个字母
 * 就相当于dp(i) = dp[i-1] + dp[i-2];
 * 如果不符合条件，又有两种情况
 * 1.当前数字是0：
 * 不好意思，这阶楼梯不能单独走，
 * dp[i] = dp[i-2]
 * 2.当前数字不是0
 * 不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
 * dp[i] = dp[i-1];
 */
class Solution1 {
    public int numDecodings(String s) {
        final int length = s.length ();
        if (length == 0) return 0;
        if (s.charAt (0) == '0') return 0;

        int[] dp = new int[length + 1];
        dp[0] = 1;

        for (int i = 0; i < length; i++) {
            dp[i + 1] = s.charAt (i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt (i - 1) == '1' || (s.charAt (i - 1) == '2' && s.charAt (i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[length];
    }
}
