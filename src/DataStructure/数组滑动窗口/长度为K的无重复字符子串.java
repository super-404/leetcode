package DataStructure.数组滑动窗口;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-11-11 10:18
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：
 * 'havef','avefu','vefun','efuno','etcod','tcode'。
 * <p>
 * 示例 2：
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串
 * <p>
 * 提示：
 * 1 <= S.length <= 10^4
 * S 中的所有字符均为小写英文字母
 * 1 <= K <= 10^4
 **/
//
//2. 解题
//
//        先计算出有多少个1，假设为k个
//        然后用一个固定大小为k的窗口，遍历数组，记录窗口内0的最小个数即为答案
public class 长度为K的无重复字符子串 {


}
