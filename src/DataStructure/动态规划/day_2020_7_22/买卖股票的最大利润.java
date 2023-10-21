package DataStructure.动态规划.day_2020_7_22;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *  
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-23 15:44
 **/
public class 买卖股票的最大利润 {
    public static void main(String[] args) {
        new Solution1 ().maxProfit (new int[]{7, 1, 5, 3, 6, 4});
    }
}

//暴力搜索
//每一天对于买卖股票有三种可能性
//分别是 不买也不卖
//其次是 买
//然后是 卖

class Solution {

    private int res;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs (prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        this.res = Math.max (this.res, profit);
        if (index == len) {
            return;
        }
        System.out.println ("第" + index + "天观望中");

        dfs (prices, index + 1, len, status, profit);

        if (status == 0) {
            // 可以尝试转向 1
            //卖入股票，当前收益减去股票价格
            System.out.println ("第" + index + "买入股票：" + prices[index] + "  目前收益是" + (profit - prices[index]));
            dfs (prices, index + 1, len, 1, profit - prices[index]);

        } else {
            // 此时 status == 1，可以尝试转向 0
            //把手上的股票卖掉,当前原本的收益加上股票价格
            System.out.println ("第" + index + "天卖掉股票：" + prices[index] + "目前收益是" + (profit + prices[index]));
            dfs (prices, index + 1, len, 0, profit + prices[index]);

        }
    }
}

//动态规划
class Solution1 {

    private int res;

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        /*  第一维 i 表示索引为 i 的那一天（具有前缀性质，即考虑了之前天数的收益）能获得的最大利润；
            第二维 j 表示索引为 i 的那一天是持有股票，还是持有现金。
            这里 0 表示代表不持有股票，1 表示持有股票（stock）。
       */

        int dp[][] = new int[2][n];
        //0代表不持有股票
        //1代表持有
        dp[0][0] = 0;
        //在第一天持有股票相当于0-prices[0];
        dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //现在
            dp[0][i] = Math.max (dp[0][i - 1], dp[1][i - 1] + prices[i]);
            dp[1][i] = Math.max (dp[1][i - 1], dp[0][i - 1] - prices[i]);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println (Arrays.toString (dp[i]));
        }
        return 0;
    }
}
