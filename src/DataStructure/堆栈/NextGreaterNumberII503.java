package DataStructure.堆栈;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-18 09:36
 **/
public class NextGreaterNumberII503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int ans[] = new int[nums.length];
            Arrays.fill (ans, -1);
            Deque<Integer> si = new LinkedList ();
            //先从左往右遍历
            int i = 0;
            for (int k = 0; k < nums.length * 2; k++) {
                i = k % nums.length;
                while (!si.isEmpty () && nums[i] > nums[si.peek ()]) {
                    //int cur = nums[si.pop()];
                    int x = si.pop ();
                    if (ans[x] == -1)
                        ans[x] = nums[i];
                }
                //保存下标，方便计算
                si.push (i);
            }

//            //再冲右往左遍历，这个时候栈里面可能还有一些数据的
//            for (int i = nums.length-1 ;i >= 0 ; i--) {
//
//                while(!si.isEmpty()&&nums[i]>nums[si.peek()]){
//                    //int cur = nums[si.pop()];
//                   if(ans[si.pop()]==-1)
//                        ans[si.pop()] = nums[i];
//                }
//                //保存下标，方便计算
//                si.push(i);
//            }
            return ans;
        }
    }

    @Test
    public void test() {

        int input2[] = {5, 4, 3, 2, 1};
        int ans[] = new Solution ().nextGreaterElements (input2);
        System.out.println (Arrays.toString (ans));
    }
}
