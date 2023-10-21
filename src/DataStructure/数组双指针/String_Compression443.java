package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-12 14:17
 **/
public class String_Compression443 {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int i = 0;
        int j = i + 1;
        String ans = "";
        while (i < chars.length) {
            ans += chars[i];
            while (j < chars.length && chars[i] == chars[j]) j++;
            if (j - i > 1)
                ans += j - i;
            i = j;
            j = i + 1;
        }
        for (int k = 0; k < ans.length (); k++) {
            chars[k] = ans.charAt (k);
        }
        return ans.length ();
    }

    public static void main(String[] args) {
        char[] c = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] c1 = {'a', 'b', 'c'};
        int ans = new String_Compression443 ().compress (c);
        System.out.println (c);
        System.out.println (ans);
    }
}
