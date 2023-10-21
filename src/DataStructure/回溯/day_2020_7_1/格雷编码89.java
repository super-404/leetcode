package DataStructure.回溯.day_2020_7_1;

/**
 * @program: leetcode
 * @description: 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。
 * 即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-01 15:52
 **/

import java.lang.reflect.Array;
import java.util.*;

public class 格雷编码89 {
    public static void main(String[] args) {
//        System.out.println (new Solution2 ().grayCode (5));
//        System.out.println ((~-3));
        List<Integer> res = new ArrayList<Integer> () {
            {
                add (0);
            }
        };
        System.out.println (res);
    }
}

class Solution2 {
    int n;
    List<Integer> li = new ArrayList<> ();
    int zeroAndOne[] = {0, 1};
    List<List<Integer>> lli = new ArrayList<> ();

    public List<Integer> grayCode(int n) {
        this.n = n;
        ArrayList<Integer> path = new ArrayList<> ();
        for (int i = 0; i < n; i++) {
            path.add (0);
        }
        backTrack (path);
        ArrayList<Integer> res = new ArrayList<> ();
        for (List<Integer> li : lli) {
            int count = n;
            int sum = 0;
            System.out.println (li);
            for (Integer i : li) {
                sum += i * Math.pow (2, --count);
            }
            res.add (sum);
        }
        return res;
    }

    public void backTrack(ArrayList<Integer> path) {
        if (lli.size () <= Math.pow (2, n)) {
            lli.add (new ArrayList<> (path));
        }
        for (int i = 0; i < n; i++) {
            //对于每一个可能的情况取非，记得+2
            path.set (i, ~path.get (i) + 2);
            if (lli.contains (path)) {
                path.set (i, ~path.get (i) + 2);
                continue;
            }
            if (lli.size () == Math.pow (2, n)) {
                return;
            }
            backTrack (path);
            path.set (i, ~path.get (i) + 2);
        }
    }
}
