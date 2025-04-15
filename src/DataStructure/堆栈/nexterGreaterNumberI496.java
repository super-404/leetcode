package DataStructure.堆栈;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-18 09:20
 **/
public class nexterGreaterNumberI496 {

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> si = new Stack<> ();
            HashMap<Integer, Integer> hmii = new HashMap<> ();
            for (int i = 0; i < nums2.length; i++) {
                while (!si.isEmpty () && nums2[i] > si.peek ()) {
                    hmii.put (si.pop (), nums2[i]);
                }
                si.push (nums2[i]);
            }
            int ans[] = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = hmii.getOrDefault (nums1[i], -1);
            }
            return ans;
        }

    }

    @Test
    public void test() {
        int input1[] = {2, 4};
        int input2[] = {1, 2, 3, 4};
        int ans[] = new Solution ().nextGreaterElement (input1, input2);
        System.out.println (Arrays.toString (ans));
    }
}
