package DataStructure.回溯.day_2020_6_30;

import java.util.*;

public class 幂集面试题0804 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

//        for(List<Integer> li:new Solution().subsets (nums)){
//            System.out.println (Arrays.toString(li.toArray ()));
//        }
        long a = Long.MAX_VALUE;
        List<Integer> li = new ArrayList<> ();
        li.add (0);
        System.out.println (li);
    }
}

//这就是最简单的那种回朔了
class Solution {
    int goal[];
    List<List<Integer>> lli = new ArrayList<> ();

    public List<List<Integer>> subsets(int[] nums) {
        goal = nums;
        backTrack (0, new ArrayList<Integer> ());
        return lli;
    }

    public void backTrack(int start, List path) {
        lli.add (new ArrayList (path));
        for (int i = start; i < goal.length; i++) {
            path.add (goal[i]);
            backTrack (i + 1, path);
            path.remove (path.size () - 1);
        }
    }
}


//还有一种解法是利用位掩码来解决
class Solution1 {

}
