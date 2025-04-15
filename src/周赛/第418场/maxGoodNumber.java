package 周赛.第418场;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-12 11:54
 **/
public class maxGoodNumber {

    public int maxGoodNumber(int[] nums) {
        int a = 12;
        int len = nums.length;
        String binaryStrs[] = new String[len];
        for (int i = 0; i < len; i++) {
            binaryStrs[i] = Integer.toBinaryString (nums[i]);
        }
        Arrays.sort (binaryStrs, new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare (Integer.valueOf (o2 + o1, 2), Integer.valueOf (o1 + o2, 2));

            }
        });
        String ans = "";

        for (int i = 0; i < len; i++) {
            ans += binaryStrs[i];
        }

        return Integer.valueOf (ans, 2);
    }

    @Test
    public void test() {
        int a[] = {2, 8, 16};
        int ans = maxGoodNumber (a);
        System.out.println (ans);
    }
}
