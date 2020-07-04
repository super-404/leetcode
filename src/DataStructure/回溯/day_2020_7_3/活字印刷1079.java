package DataStructure.回溯.day_2020_7_3;

import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description: 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。
 * 返回你可以印出的非空字母序列的数目。  注意：本题中，每个活字字模只能使用一次。
 * @author: 饶嘉伟
 * @create: 2020-07-03 14:32
 **/
public class 活字印刷1079 {

    public static void main(String[] args) {
        Solution solution = new Solution ();
        int res = solution.numTilePossibilities ("CDC");
        System.out.println (res);
        Solution.lli.stream ()
                .forEach ((s) -> {
                    System.out.println (s);
                });


    }
}

class Solution {
    boolean used[];
    char[] goal;
    static Set<List<Character>> lli = new HashSet<> ();


    public int numTilePossibilities(String tiles) {
        used = new boolean[tiles.length ()];
        goal = tiles.toCharArray ();
        Arrays.toString (goal);
        backTrack (new ArrayList<Character> ());
        return lli.size () - 1;
    }

    public void backTrack(List path) {
        lli.add (new ArrayList (path));
        for (int i = 0; i < goal.length; i++) {
            if (!used[i]) {
                if (i > 0 && goal[i] == goal[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add (goal[i]);
                used[i] = true;
                backTrack (path);
                path.remove (path.size () - 1);
                used[i] = false;
            }
        }
    }
}
