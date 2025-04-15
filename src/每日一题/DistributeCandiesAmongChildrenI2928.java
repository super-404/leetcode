package 每日一题;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-06-02 08:45
 **/
public class DistributeCandiesAmongChildrenI2928 {
    public int distributeCandies(int n, int limit) {
        int ans = n;
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            ans = n - i;
            for (int j = 0; j <= limit && ans - j >= 0; j++) {
                int temp = ans - j;
                if (temp <= limit) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        distributeCandies (3, 3);
    }
}
