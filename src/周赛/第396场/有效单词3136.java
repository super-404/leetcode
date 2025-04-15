package 周赛.第396场;

import org.junit.Test;

import java.util.Locale;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-05-09 09:13
 **/
public class 有效单词3136 {

    public boolean isValid(String word) {
        if (word.length () < 3) {
            return false;
        }
        word = word.toLowerCase ();
        int vowelCount = 0;
        int ConsonantCount = 0;
        char[] vowelChar = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < word.length (); i++) {
            char c = word.charAt (i);
            if (!Character.isLetterOrDigit (c)) {
                return false;
            }
            boolean flag = false;
            for (int j = 0; j < vowelChar.length; j++) {
                if (c == vowelChar[j]) {
                    vowelCount++;
                    flag = true;
                }
            }
            if (!flag)
                ConsonantCount++;

        }
        return vowelCount > 0 && ConsonantCount > 0;
    }

    @Test
    public void test() {
        isValid ("UuE6");
    }

}
