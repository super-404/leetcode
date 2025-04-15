package DataStructure.数组滑动窗口;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 你正在探访一家农场，农场从左到右种植了一排果树。
 * <p>
 * 这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，
 * 你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。
 * 每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
 * <p>
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * <p>
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * <p>
 * 给你一个整数数组 fruits ，返回你可以收集的水果的最大数目。
 * @author: 饶嘉伟
 * @create: 2023-12-10 21:51
 **/
public class 水果成篮904 {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<> ();

        while (right < fruits.length) {
            int k = fruits[right];
            hm.computeIfPresent (k, (a, b) -> b + 1);
            hm.putIfAbsent (k, 1);
//          sum += k;
            while (hm.size () > 2) {
                hm.computeIfPresent (fruits[left], (a, b) -> b - 1);
                if (hm.get (fruits[left]) == 0) {
                    hm.remove (fruits[left]);
//                    sum-=fruits[left];
                }
                left++;
            }
            ans = Math.max (ans, right - left + 1);
            right++;
        }
        return ans;
    }

    @Test
    public void test1() {
        int a[] = {1, 2, 1};
        int res = new 水果成篮904 ().totalFruit (a);
        System.out.println (res);
    }

    @Test
    public void test2() {
        int a[] = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int res = new 水果成篮904 ().totalFruit (a);
        System.out.println (res);
    }
}
