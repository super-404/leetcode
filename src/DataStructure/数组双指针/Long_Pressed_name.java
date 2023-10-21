package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-10-17 23:08
 **/
public class Long_Pressed_name {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        while (j < typed.length ()) {
            if (i < name.length () && name.charAt (i) == typed.charAt (j)) {
                i++;
                j++;
            } else if (j >= 1 && typed.charAt (j) == typed.charAt (j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length ();
    }

    public static void main(String[] args) {
        new Long_Pressed_name ().isLongPressedName ("saeed", "ssaaedd");
    }
}
