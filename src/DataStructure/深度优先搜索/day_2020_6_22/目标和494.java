package DataStructure.深度优先搜索.day_2020_6_22;

public class 目标和494 {
    public static void main(String[] args) {
        int []nums={1,1,1,1,1};
        int S=3;
        Solution s=new Solution ();
        System.out.println (s.findTargetSumWays (nums,S));
    }
}

/**
 * @Author: 饶嘉伟
 * @Description
 *
 * 给定一个非负整数数组，a1,a2,...,an,和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: 2020/6/22 17:30
 * @Para: a
 * @retun: a
 **/

class Solution {
    int goal[];
    int num;
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        goal=nums;
        num=S;
        dfs(0,0,true);
        dfs(0,0,false);
        return count;
    }
    public void  dfs(int sum,int i,boolean lessOrPlus){
        if(i==goal.length){

            return;
        }
        if(lessOrPlus){
            sum+=goal[i];
        }
        else{
            sum-=goal[i];
        }
        if(i==goal.length-1&&sum==num){
            count++;
        }
        dfs(sum,i+1,true);
        dfs(sum,i+1,false);
    }
}
