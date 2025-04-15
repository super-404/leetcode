package DataStructure.数组滑动窗口;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-06 09:09
 **/
public class 求出最长好子序列 {
    public int maximumLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int count = 0;
        int res = 0;
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        while (right < len - 1) {
            if (nums[right] != nums[right + 1]) {
                count++;
            }
            while (count > k) {
                if (left < len - 1 && nums[left] != nums[left + 1]) {
                    count--;
                }
                left++;
            }
            right++;
            res = Math.max (res, right - left + 1);
        }
        return res;
    }

    @Test
    public void test() {
        int a[] = {1};
        maximumLength (a, 0);
    }

    public String q1() {
        Scanner in = new Scanner (System.in);
        int len = in.nextInt ();
        in.nextLine ();
        List<String> as = new ArrayList<> ();
        String s = "";
        // 注意 hasNext 和 hasNextLine 的区别
        while ((s = in.next ()) != null) { // 注意 while 处理多个 case
            as.add (s);
            //System.out.println(a + b);
        }
        Collections.sort (as);
        StringBuilder res = new StringBuilder ("");
        as.forEach ((x) -> {
            res.append (x + " ");
        });
        return res.toString ();
    }

    @Test
    public void testq1() {
        q1 ();
    }
}
