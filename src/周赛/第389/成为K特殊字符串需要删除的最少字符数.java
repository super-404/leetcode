package 周赛.第389;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-31 09:58
 **/
public class 成为K特殊字符串需要删除的最少字符数 {
    public int minimumDeletions(String word, int k) {
        int len = word.length ();
        int[] freq = new int[26];
        int charCount = 0;
        for (int i = 0; i < len; i++) {
            if (freq[word.charAt (i) - 'a'] == 0)
                charCount++;
            freq[word.charAt (i) - 'a']++;
        }
        int[] removeZero = new int[charCount];
        int j = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                removeZero[j] = freq[i];
                j++;
            }
        }

        //Arrays.
        Arrays.sort (removeZero);

        int max = removeZero[charCount - 1];
        int min = removeZero[0];
        int res = 0;
        while (max - min > k) {
            if (max - min - k >= min) {
                res += min;
                removeZero = Arrays.copyOfRange (removeZero, 1, removeZero.length);

            } else {
                res += max - min - k;
                removeZero[removeZero.length - 1] -= max - min - k;
            }
            Arrays.sort (removeZero);
            max = removeZero[removeZero.length - 1];
            min = removeZero[0];
        }
        return res;
    }

    @Test
    public void test() {
        String test = "vvnowvov";
        System.out.println (minimumDeletions (test, 2));
    }
}
