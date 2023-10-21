package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-21 13:41
 **/
public class Maximum_Average_Subarray643 {

    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        //注意double的最小值不是Double.MIN_VALUE
        //而是-Double.MAX_VALUE;
        double avg = -Double.MAX_VALUE;
        double sum = 0.0;
        while (right < nums.length) {
            sum += nums[right];
            if (right - left + 1 == k) {
                System.out.println (sum / k);
                avg = Math.max (avg, sum / k);
                //avg = avg>(sum/k)?avg:(sum/k);
                System.out.println (avg);
                sum -= nums[left];
                left++;
            }
            right++;

        }
        return avg;
    }

    public static void main(String[] args) {
        int a[] = new int[]{-1};
        new Maximum_Average_Subarray643 ().findMaxAverage (a, 1);
    }
}
