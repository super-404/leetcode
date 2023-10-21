package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: 844
 * <p>
 * Given two strings s and t,
 * <p>
 * return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text,
 * <p>
 * the text will continue empty.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * @author: 饶嘉伟
 * @create: 2023-10-18 09:44
 **/
public class Backspace_String_Compare {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length () - 1;
        int j = t.length () - 1;
        int skips = 0;
        int skipj = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt (i) == '#') {
                    skips++;
                    i--;
                } else if (skips > 0) {
                    skips--;
                    i--;
                } else {
                    break;
                }
                //i--;
            }
            while (j >= 0) {
                if (t.charAt (j) == '#') {
                    skipj++;
                    j--;
                } else if (skipj > 0) {
                    skipj--;
                    j--;
                } else {
                    break;
                }
                //j--;
            }

            //退出while 循环又可能是因为 j<0
            //不要使用
            if (i >= 0 & j >= 0) {
                if (s.charAt (i) != t.charAt (j)) {
                    return false;
                }
            } else if (j >= 0 || i >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        new Backspace_String_Compare ().backspaceCompare ("a#c", "c");
    }
}
