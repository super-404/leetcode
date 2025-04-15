package 每日一题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-29 22:48
 **/
public class GenerateBinaryStringsWithoutAdjacentZeros3211 {
    ArrayList<String> as = new ArrayList<> ();

    public List<String> validStrings(int n) {
        dfs (n, "0", 1);
        dfs (n, "1", 1);
        return as;
    }

    private void dfs(int n, String s, int i) {
        if (i == n) {
            as.add (s);
            return;
        }
        if (s.charAt (s.length () - 1) == '1') {
            dfs (n, s + "0", i + 1);
        }
        dfs (n, s + "1", i + 1);

    }

    @Test
    public void test() {
        System.out.println (validStrings (3));
    }
}
