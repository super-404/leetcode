import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-06 15:04
 **/
public class 最小排列 {
    public static void main(String[] args) {
        new 最小排列 ().q1 ();
    }

    public void q1() {
        Scanner in = new Scanner (System.in);
        int len = in.nextInt ();
        in.nextLine ();
        List<String> as = new ArrayList<> ();
        String s = "";
        int i = 0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (i < len) { // 注意 while 处理多个 case
            s = in.next ();
            as.add (s);
            i++;
            //System.out.println(a + b);
        }
        String strs[] = new String[as.size ()];
        for (int j = 0; j < strs.length; j++) {
            strs[j] = as.get (j);
        }
//        MSDSort.sort (strs);
        Collections.sort (as, new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo (o2 + o1);
//                char[] chars1 = o1.toCharArray ();
//                char[] chars2 = o2.toCharArray ();
//                int i = 0;
//                int j = 0;
//                while (i < chars1.length && j < chars2.length) {
//                    if (chars1[i] > chars2[j]) {
//                        return 1;
//                    } else if (chars1[i] < chars2[j]) {
//                        return -1;
//                    } else {
//                        i++;
//                        j++;
//                    }
//                }
//                if (i == chars1.length&&chars1[i-1]<chars2[chars2.length-1]) {
//                    return -1;
//                }
//                if (j == chars2.length&&chars2[j-1]>chars1[chars1.length-1]) {
//                    return 1;
//                }
//
//                return 0;
            }
        });
        StringBuilder res = new StringBuilder ("");
        System.out.println (Arrays.toString (strs));
        //return res.toString ().substring (0, res.length () - 1);
    }

    public void q2() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        long target = in.nextInt ();
        ArrayList<Integer> point = new ArrayList<> ();
        int i = 0;
        while (i < n) {
            point.add (in.nextInt ());
            i++;
        }
        i = 0;
        ArrayList<Integer> db = new ArrayList<> ();

        while (i < n) {
            db.add (in.nextInt ());
            i++;
        }
        boolean f = false;
        ArrayList<Integer> firstDb = new ArrayList<> ();
        ArrayList<Integer> firstPoint = new ArrayList<> ();

        for (int j = 0; j < n; j++) {
            firstDb.add (db.get (j));
            firstPoint.add (point.get (j));
            Collections.sort (firstDb);
            Collections.sort (firstPoint);
            long res = 0;
            for (int k = 0; k < firstDb.size (); k++) {
                res += firstDb.get (k) * firstPoint.get (k);

            }
            if (res >= target && !f) {
                f = true;
                System.out.println (j + 1);

            }
        }
        if (!f) {
            System.out.println (-1);
        }
        ;

    }

    public void q3() {
        Scanner in = new Scanner (System.in);
        int i = in.nextInt ();
        String str = in.nextLine ();

    }

    public void testSort() {
        //   MSDSort.sort ();
    }
}

class MSDSort {
    //高位优先的字符串排序

    private static int R = 256; //基数，假设是扩展ASCII码
    private static final int M = 15; //小数组的切换阈值
    private static String[] aux; //数组分类的辅助数组

    private static int charAt(String s, int d) {
        //返回字符串s中第d个字符的索引，如果d超过了s的长度，返回-1
        if (d < s.length ()) {
            return s.charAt (d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        //对字符串数组a进行排序
        int N = a.length;
        aux = new String[N];
        sort (a, 0, N - 1, 0); //从第0个字符开始排序
    }

    private static void sortInsert(String[] a, int lo, int hi) {
        //对小型数组进行插入排序
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && a[j].compareTo (a[j - 1]) < 0; j--) {
                String tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        //以第d个字符为键将a[lo]至a[hi]排序

        if (hi <= lo + M) {
            //如果子数组较小，使用插入排序提高效率
            sortInsert (a, lo, hi);
            return;
        }

        int[] count = new int[R + 2]; //计算频率

        for (int i = lo; i <= hi; i++) {
            count[charAt (a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) {
            //将频率转换为索引
            count[r + 1] += count[r];
        }
    }

    @Test
    public void test4test() {

    }
}
