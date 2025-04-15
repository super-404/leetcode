import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-17 12:43
 **/
public class xinkailai {

    public static void solution1() {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine ();
        LinkedList<Character> lc = new LinkedList<> ();
        for (int i = 0; i < s.length (); i++) {
            char c = s.charAt (i);
            if (Character.isDigit (c)) {
                if (!lc.isEmpty ()) {
                    lc.removeLast ();
                }
            } else {
                lc.add (c);
            }
        }
        String ans = "";
        for (char c : lc) {
            ans += c;
        }
        System.out.println (ans);
    }

    public static void solution2() {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine ();

        s = s.substring (1, s.length () - 1);
        String s2 = in.nextLine ();
        s2 = s2.substring (1, s2.length () - 1);

        if (s2.length () < 2 && s.length () == 0) {
            System.out.println ("yes");
            return;
        }
        String strs[] = s2.split (",");

        Set<String> dic = new HashSet<> ();
        for (int i = 0; i < strs.length; i++) {
            dic.add (strs[i].substring (1, strs[i].length () - 1));
        }
        boolean dp[] = new boolean[s.length () + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length (); i++) {
            for (int j = 0; j < i; j++) {
                String substr = s.substring (j, i);
                if (dp[j] && dic.contains (substr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (dp[s.length ()]) {
            System.out.println ("yes");
        } else {
            System.out.println ("no");
        }

    }

    @Test
    public void test() {
        String s2 = "[]";
        if (!s2.contains (",")) {

        }
        String[] split = s2.substring (1, s2.length () - 1).split (",");
        for (int i = 0; i < split.length; i++) {
            //  split[i] = split[i].trim ();
            System.out.println (split[i]);
            System.out.println (split[i].length ());
        }
        System.out.println (split.length);
        System.out.println (Arrays.toString (split));
    }

    public static void main(String[] args) {
        solution2 ();
    }

    public static void solution3() {
        Scanner scanner = new Scanner (System.in);


        int NP = scanner.nextInt ();
        scanner.nextLine ();


        String[] names = new String[NP];
        for (int i = 0; i < NP; i++) {
            names[i] = scanner.nextLine ().trim ();
        }


        Map<String, Integer> sentMoney = new HashMap<> ();
        Map<String, Integer> receivedMoney = new HashMap<> ();


        for (String name : names) {
            sentMoney.put (name, 0);
            receivedMoney.put (name, 0);
        }


        for (int i = 0; i < NP; i++) {

            String giver = scanner.nextLine ().trim ();

            String[] firstLine = scanner.nextLine ().split (" ");

            int t = Integer.parseInt (firstLine[0]);

            int num = Integer.parseInt (firstLine[1]);

            if (num > 0) {

                int gift = t / num;

                int last = t - gift * num;

                sentMoney.put (giver, sentMoney.get (giver) + t - last);

                for (int j = 0; j < num; j++) {
                    String r = scanner.nextLine ().trim ();
                    receivedMoney.put (r, receivedMoney.get (r) + gift);
                }
            }
        }


        for (String name : names) {
            int result = receivedMoney.get (name) - sentMoney.get (name);
            System.out.println (name + " " + result);
        }
    }
}
