package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * @author: 饶嘉伟
 * @create: 2023-03-10 13:43
 **/
public class _746使用最小花费爬楼梯 {

    public static void main(String[] args) {
        int i = minCostClimbingStairs (new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println (i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 2) {
            return Math.min (cost[0], cost[1]);
        }
//        int dp [] =new int [len+1];
//        //前两阶楼梯不需要任何代价
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i =2 ;i<dp.length;i++){
//            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
//        }
//        return dp[len];
        //因为始终只有两个变量，不需要用到数组
        //前两阶楼梯不需要任何代价
        int prepre = 0;
        int pre = 0;
        for (int i = 2; i < len + 1; i++) {

            int min = Math.min (pre + cost[i - 1], prepre + cost[i - 2]);
            prepre = pre;
            pre = min;
        }
        return pre;
    }
}

