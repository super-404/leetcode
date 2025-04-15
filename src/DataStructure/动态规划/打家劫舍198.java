package DataStructure.动态规划;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-13 23:54
 **/
public class 打家劫舍198 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s[] = in.nextLine ().split (";");
        int h = 0;
        int v = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length () != 3)
                continue;
            if (s[i].charAt (0) != 'W' && s[i].charAt (0) != 'S' &&
                    s[i].charAt (0) != 'A' && s[i].charAt (0) != 'D') {
                continue;
            }
            int move = 0;
            try {
                move = Integer.parseInt (s[i].substring (1));
            } catch (NumberFormatException nf) {
                continue;
            }
            switch (s[i].charAt (0)) {
                case 'A': {
                    h -= move;
                    break;
                }
                case 'S': {
                    v -= move;
                    break;
                }
                case 'D': {
                    h += move;
                    break;
                }
                case 'W': {
                    v += move;
                    break;
                }
            }
        }
        System.out.println (h + "," + v);
    }

    public int rob(int[] nums) {
        int a = dfs (nums, 0, false);
        int b = dfs (nums, 0, true);
        return a > b ? a : b;
    }

    public int dfs(int[] nums, int i, boolean isSteal) {
        if (i >= nums.length)
            return 0;
        return isSteal ? dfs (nums, i + 1, false) + 0 :
                dfs (nums, i + 1, false) + 0 >
                        dfs (nums, i + 1, true) + nums[i] ?
                        dfs (nums, i + 1, false) + 0 : dfs (nums, i + 1, true) + nums[i];
    }

    @Test
    public void test() {
        int a[] = {2, 1, 1, 2};
        String[] split = "5.5".split ("\\.");
        System.out.println (Arrays.toString (split));
        System.out.println (rob (a));
        HashMap<Integer, Integer> hii = new HashMap ();
        hii.forEach ((k, v) -> {
            System.out.println (k + " " + v);
        });
    }

    @Test
    public void test1() {

    }
}
