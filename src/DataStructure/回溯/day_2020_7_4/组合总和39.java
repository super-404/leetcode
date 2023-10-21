package DataStructure.回溯.day_2020_7_4;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-04 15:38
 **/
public class 组合总和39 {
    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        new Solution ().combinationSum (a, 8)
                .stream ()
                .forEach (s -> {
                    System.out.println (s);
                });
    }
}

class Solution {
    Set<List<Integer>> lli = new HashSet<> ();
    int target;
    int goal[];

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        goal = candidates;
        Arrays.sort (goal);
        backTrack (new ArrayList<Integer> (), target);
        return new ArrayList (lli);
    }

    public void backTrack(List<Integer> path, int remain) {
        if (remain == 0) {
            lli.add (path.stream ().sorted ().collect (Collectors.toList ()));
            return;
        } else {
            if (remain > 0) {
                for (int i = 0; i < goal.length; i++) {
                    if (remain - goal[i] < 0)
                        return;
                    path.add (goal[i]);
                    backTrack (path, remain - goal[i]);
                    path.remove (path.size () - 1);
                }
            }
        }
    }
}

class Solution1 {
    Set<List<Integer>> lli = new HashSet<> ();
    int target;
    int goal[];

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        goal = candidates;
        Arrays.sort (goal);
        backTrack (0, new ArrayList<Integer> (), target);
        return new ArrayList (lli);
    }

    public void backTrack(int start, List<Integer> path, int remain) {
        if (remain == 0) {
            lli.add (new ArrayList<> (path));
            return;
        } else {
            for (int i = start; i < goal.length; i++) {
                if (remain - goal[i] < 0)
                    return;
                path.add (goal[i]);
                backTrack (i, path, remain - goal[i]);
                path.remove (path.size () - 1);
            }
        }
    }
}
