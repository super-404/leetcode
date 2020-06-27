package DataStructure.回溯.day_2020_6_27;

import java.util.*;

public class 有重复字符串的排列组合 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1 ();

        for (String s :
                solution.permutation (new String ("qqe"))) {
            System.out.println (s);
        }

    }
}

class Solution1 {
    char str[];
    Set<String> slc = new HashSet<> ();
    boolean used[];

    public String[] permutation(String S) {
        str = S.toCharArray ();
        used = new boolean[str.length];
        Arrays.sort (str);
        backTrack (0, new StringBuilder ());
        String[] s = new String[slc.size ()];
        s = slc.toArray (s);
        return s;
    }

    public void backTrack(int start, StringBuilder goal) {
        if (start == str.length) {
            slc.add (goal.toString ());
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (!used[i]) {

                if (i > 0 && str[i] == str[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                goal.append (str[i]);
                backTrack (goal.length (), goal);
                goal.delete (goal.length () - 1, goal.length ());
                used[i] = false;
            }
        }
    }
}
