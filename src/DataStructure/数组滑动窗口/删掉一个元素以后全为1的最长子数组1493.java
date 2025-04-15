package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description: 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * @author: 饶嘉伟
 * @create: 2023-12-08 22:31
 **/
public class 删掉一个元素以后全为1的最长子数组1493 {

    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        boolean flag = false;
        int res = 0;
        int count = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[left] == 0)
                    count--;
                left++;
            }
            res = Math.max (res, right - left + 1);
            right++;
        }
        return res - 1;
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int i = new 删掉一个元素以后全为1的最长子数组1493 ().longestSubarray (a);
        System.out.println (i);
    }
}
