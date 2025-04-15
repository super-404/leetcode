package 华为机考;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-24 20:20
 **/
public class solution2 {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner (System.in);

        int nums = in.nextInt ();
        int count = in.nextInt ();
        in.nextLine ();
        String line = in.nextLine ();

        String goals[] = line.split (" ");

        Member[] ms = new Member[nums];
        for (int i = 0; i < nums; i++) {
            ms[i] = new Member ();
        }
        //统计射门次数
        //以及什么时候失射
        int get[] = new int[nums];

        for (int i = 0; i < nums; i++) {
            int continueNums = 0;
            ms[i].s = goals[i];
            for (int j = 0; j < count; j++) {
                char c = goals[i].charAt (j);
                if (c == '1') {
                    get[i]++;
                    continueNums++;
                } else {

                    ms[i].continueNums = Math.max (ms[i].continueNums, continueNums);
                    continueNums = 0;
                }
            }
            ms[i].continueNums = Math.max (ms[i].continueNums, continueNums);
            ms[i].count = get[i];
            ms[i].id = i + 1;
        }
        Arrays.sort (ms, (o1, o2) -> {
            return o2.count - o1.count;
        });
        Arrays.sort (ms, (o1, o2) -> {
            return o2.continueNums - o1.continueNums;
        });

        Arrays.sort (ms, (o1, o2) -> {
            return o1.id - o2.id;
        });
        Arrays.sort (ms, (o1, o2) -> {
            if ((o1.count - o2.count) != 0) {
                return o2.count - o1.count;
            } else {
                if ((o1.continueNums - o2.continueNums) != 0) {
                    return (o2.continueNums - o1.continueNums);
                } else {

                    for (int i = 0; i < o1.s.length (); i++) {
                        if (o1.s.charAt (i) != o2.s.charAt (i)) {
                            return Integer.valueOf (o2.s.charAt (i)) - Integer.valueOf (o1.s.charAt (i));
                        }
                    }

                    if ((o1.id - o2.id) != 0) {
                        return o1.id - o2.id;
                    }
                }
            }
            return 0;
        });
        for (int i = 0; i < ms.length; i++) {
            System.out.print (ms[i].id);
        }
    }

    static class Member {
        int id;
        int count;
        String s;
        int continueNums;

    }

    public void test3() {
        String word = "";
        int letterLower[] = new int[26];
        int letterUpper[] = new int[26];
        Arrays.fill (letterUpper, 1);
        for (int i = 0; i < word.length (); i++) {
            char c = word.charAt (i);
            if (Character.isLowerCase (c)) {
                letterUpper[Character.toUpperCase (c) - 'A'] = 0;
                letterLower[c - 'a']++;
            } else {
                letterUpper[c - 'a']++;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (letterUpper[i] > 1 && letterLower[i] > 0) {
                count++;
            }
        }
    }

}
