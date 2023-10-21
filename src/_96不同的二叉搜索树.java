/**
 * @program: leetcode
 * @description: 给你一个整数 n ，
 * 求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 * @author: 饶嘉伟
 * @create: 2023-03-13 23:41
 **/
public class _96不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println (numTrees (4));
    }

    /*当根节点等于 1 时 ，其余数字都比1大，只能在右边 dp[i] += dp[4]
    当根节点等于 2 时，左边有一个1比2小，右边有三个比2大的数字 dp[i] += dp[1] * dp[3]
    当根节点等于 3 时，左边有两个数比3小，右边有两个数比3大的数字 dp[i] += dp[2] * dp[2]
            ...
    知道根节点等于5，左边有4个数字比5小，只能放在5的左边,dp[i] += dp[4]
*/
    public static int numTrees(int n) {
        int ans = 0;
        int dp[] = new int[n + 1];
        //dp[i]为当n=i时的数目
        dp[0] = 1;
        dp[1] = 1;
        if (n <= 1)
            return ans;

        for (int i = 2; i <= n; i++) {
            //每个节点都可能是根节点
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
