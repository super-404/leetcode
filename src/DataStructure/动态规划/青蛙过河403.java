package DataStructure.动态规划;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-20 09:05
 **/
public class 青蛙过河403 {
    public boolean canCross(int[] stones) {
        return dfs (1, stones, stones[1] - stones[0], 1);
    }

    public boolean dfs(int k, int[] stones, int len, int i) {
        if (k != len) {
            return false;
        }
        if (i == stones.length - 1) {
            return true;
        }
        return dfs (k - 1, stones, stones[i + 1] - stones[i], i + 1) || dfs (k, stones, stones[i + 1] - stones[i], i + 1) || dfs (k + 1, stones, stones[i + 1] - stones[i], i + 1);
    }

    @Test
    public void test() {
        int a[] = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println (canCross (a));
    }
}
