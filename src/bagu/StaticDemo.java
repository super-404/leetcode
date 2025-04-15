package bagu;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-12 20:37
 **/
public class StaticDemo {
    static int i = 0;

    public int getI() {
        i = i + 1;
        return i;
    }

    public static int getI(int i1) {

        return i;
    }

    public static void main(String[] args) {
        StaticDemo ob1 = new StaticDemo ();
        StaticDemo.i = 10;
        Character c = Character.valueOf ('c');
        Character c1 = Character.valueOf ('c');
        Double d1 = Double.valueOf (0.1);
        Double d2 = Double.valueOf (0.1);
        Integer i1 = Integer.valueOf (1);
        Integer i2 = Integer.valueOf (1);
        System.out.println (c == c1);
        System.out.println (d1 == d2);
        System.out.println (i1 == i2);
        System.out.println (i);
    }
}
