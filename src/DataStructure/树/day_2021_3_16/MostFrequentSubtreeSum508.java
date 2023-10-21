package DataStructure.树.day_2021_3_16;

import DataStructure.树.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: Given the root of DataStructure.a tree,
 * you are asked to find the most frequent subtree sum.
 * The subtree sum of DataStructure.a node is
 * defined as the sum of all the node values formed
 * by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value?
 * If there is DataStructure.a tie,
 * return all the values with the highest frequency in any order.
 * Examples 1
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * <p>
 * return [2, -3, 4],
 * since all the values happen only once, return all of them in any order
 * <p>
 * <p>
 * Examples 2
 * Input:
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2021-03-16 10:25
 **/
public class MostFrequentSubtreeSum508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        HashMap<Integer, Integer> res = new HashMap<> ();
        solution (root, res);
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<> ();
        for (Map.Entry<Integer, Integer> i : res.entrySet ()) {
            if (i.getValue () > max) {
                max = i.getValue ();
                arrayList.clear ();
                arrayList.add (i.getKey ());
            } else {
                if (i.getValue () == max) {
                    arrayList.add (i.getKey ());
                }
            }
        }
        int a[] = new int[arrayList.size ()];
        for (int i = 0; i < a.length; i++) {
            a[i] = arrayList.get (i);
        }
        return a;
    }

    private int solution(TreeNode root, HashMap<Integer, Integer> res) {
        if (root == null)
            return 0;
        int left = solution (root.left, res);
        int right = solution (root.right, res);
        int sum = left + right + root.val;
        int key = res.getOrDefault (sum, 0);
        res.put (sum, key + 1);
        return sum;
    }
}
