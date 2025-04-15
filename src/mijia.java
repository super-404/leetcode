import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-24 17:22
 **/
public class mijia {
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length (); i++) {
            for (int j = i + 1; j < s.length (); j++) {
                String sub = s.substring (i, j);
                if (!vertify (sub)) {
                    continue;
                }
                if (ans.length () < sub.length ()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }

    public Boolean vertify(String s) {
        int left = 0;
        int right = s.length () - 1;
        while (left < right) {
            if (s.charAt (left) != s.charAt (right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // write code here
        int max = Math.max (jug1Capacity, jug2Capacity);
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<> ();
        queue.add (new int[]{0, 0});
        Set<String> visited = new HashSet<> ();
        visited.add ("0,0");
        while (!queue.isEmpty ()) {
            int[] current = queue.poll ();
            int x = current[0];
            int y = current[1];
            if (x == targetCapacity || y == targetCapacity || x + y == targetCapacity) {
                return true;
            }
            Set<int[]> s = new HashSet<> ();
            s.add (new int[]{jug1Capacity, y});
            s.add (new int[]{x, jug2Capacity});
            s.add (new int[]{0, y});
            s.add (new int[]{x, 0});

            s.add (new int[]{x - Math.min (x, jug2Capacity - y), y + Math.min (x, jug2Capacity - y)});

            s.add (new int[]{x + Math.min (y, jug1Capacity - x), y - Math.min (y, jug1Capacity - x)});
            for (int[] ss : s) {
                String str = ss[0] + "," + ss[1];
                if (!visited.contains (str)) {
                    visited.add (str);
                    queue.add (ss);
                }
            }
        }
        return false;
    }
}
