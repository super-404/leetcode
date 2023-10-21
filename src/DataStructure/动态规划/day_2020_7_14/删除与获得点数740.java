package DataStructure.动态规划.day_2020_7_14;

import java.util.ArrayList;
import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-14 14:49
 **/
public class 删除与获得点数740 {
    public static void main(String[] args) {

        System.out.println (new Solution ().deleteAndEarn (new int[]
                {2, 2, 3, 3, 3, 4}));
        new Stack<Integer> ();
        System.out.println ();
    }
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        int minValue = Integer.MIN_VALUE + 1;
        for (int k = 0; k < nums.length; k++) {
            int sum = 0;
            ArrayList als = new ArrayList<Integer> ();
            for (int m = 0; m < nums.length; m++) {
                als.add (nums[m]);
            }
            int del = (Integer) als.get (k);
            sum += del;
            als.remove ((Integer) del);
            while (als.remove ((Integer) (del - 1))) ;
            while (als.remove ((Integer) (del + 1))) ;
            while (als.size () > 0) {
                del = (Integer) als.get (0);
                sum += del;
                als.remove ((Integer) del);
                while (als.remove ((Integer) (del - 1))) ;
                while (als.remove ((Integer) (del + 1))) ;
            }
            System.out.println ("k:" + k);
            System.out.println ("max:" + max);
            max = Math.max (sum, max);
        }
        return max;
    }
}
//class Solution1 {
//    int max=0;
//    int nums[];
//    int inc=0;
//    int des=0;
//    public int deleteAndEarn(int[] nums) {
//        this.nums=nums;
//        ArrayList als=new ArrayList<Integer>();
//        for(int m=0;m<nums.length;m++){
//            als.add(nums[m]);
//        }
//        backTrack (als,0,0,0,0);
//        return max;
//    }
//    public void backTrack(List<Integer> als,int des,int inc,int del,int sum) {
//        sum+=del;
//        while (als.remove ((Integer) (del - 1))){
//            des++;
//        } ;
//        while (als.remove ((Integer) (del + 1))){
//            inc++;
//        };
//        if(als.size ()==0){
//            return ;
//        }
//        for(int i=0;i<als.size();i++){
//           int cancle= als.remove (i);
//            backTrack (als,des,inc,cancle,sum);
//            als.add(cancle);
//            for(int k=0;k<inc;k++){
//                als.add(cancle+1);
//            }
//            for(int k=0;k<des;k++){
//                als.add(cancle-1);
//            }
//        }
//        if(sum>max){
//            max=sum;
//        }
//    }
//}
