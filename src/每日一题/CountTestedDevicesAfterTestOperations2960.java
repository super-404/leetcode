package 每日一题;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-05-10 14:47
 **/
public class CountTestedDevicesAfterTestOperations2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        int len = batteryPercentages.length;
        for (int i = 0; i < len; i++) {
            if (batteryPercentages[i] - count > 0) {
                count++;
            }
        }
        return count;
    }
}
