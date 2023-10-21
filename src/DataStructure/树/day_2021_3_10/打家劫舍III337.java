package DataStructure.树.day_2021_3_10;

import DataStructure.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，
 * 每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，
 * 房屋将自动报警。
 * 计算在不触动警报的情况下，
 * 小偷一晚能够盗取的最高金额。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2021-03-10 21:21
 **/

//树形dp
public class 打家劫舍III337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> qt = new LinkedList<> ();
        qt.add (root);
        ArrayList<Integer> ai = new ArrayList<> ();
        int dp[] = new int[1000];
        dp[0] = root.val;
        if (root.left != null && root.right != null) {

        }
        int sumOfEveryLayer = 0;
        int size = 1;
        while (!qt.isEmpty ()) {
            TreeNode node = qt.remove ();
            sumOfEveryLayer += node.val;
            size--;
            if (node.left != null) {
                qt.add (node.left);
            }
            if (node.right != null) {
                qt.add (node.right);
            }
            if (size == 0) {

            }
        }
//        int num[] = new int[ai.size ()];
//        int j = 0;
//        for (int i : ai) {
//            num[j++] = i;
//        }
//        if (num.length == 1)
//            return num[0];
//        dp[0] = num[0];
//        dp[1] = Math.max (num[0], num[1]);
//        for (int i = 2; i < num.length;i++){
//            dp[i] = Math.max (dp[i-2]+num[i],dp[i-1]);
//        }
//        System.out.println (Arrays.toString (dp));
//        return  dp[num.length-1];
        return 0;
    }
}
