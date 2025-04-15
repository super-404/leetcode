import DataStructure.深度优先搜索.ListNode.ListNode;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-11-11 14:20
 **/
public class TuJia {
    public String[] topWords(String[] contents, String[] stopWords, int n) {
        // write code here
        TreeMap<String, Integer> tst = new TreeMap<> ();
        HashMap<String, List<Integer>> tls = new HashMap<> ();
        for (int i = 0; i < contents.length; i++) {
            String str = contents[i];
            int t = i;
            String[] strs = str.split (" ");
            for (int j = 0; j < strs.length; j++) {

                char ch = strs[j].charAt (strs[j].length () - 1);

                if (ch == ',' || ch == '!' || ch == '?' || ch == '.') {
                    strs[j] = strs[j].substring (0, strs[j].length () - 1);
                }
                String sj = strs[j];
                boolean flag = true;
                for (int k = 0; k < stopWords.length; k++) {
                    if (stopWords[k].equals (sj)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    tst.computeIfPresent (strs[j], (k, v) ->
                            v + 1
                    );
                    tst.putIfAbsent (strs[j], 1);
                    tls.computeIfPresent (strs[j], (k, v) -> {
                        v.add (t);
                        return v;
                    });
                    tls.computeIfAbsent (strs[j], (v) -> {
                        ArrayList<Integer> integers = new ArrayList<> ();
                        integers.add (t);
                        return integers;
                    });
                }
            }
        }
        LinkedHashMap<String, Integer> collect = tst.entrySet ().stream ().sorted (Map.Entry.<String, Integer>comparingByValue ().reversed ()).collect (Collectors.toMap (Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0;
        int v[] = new int[contents.length];
        ArrayList<String> ans = new ArrayList<> ();
        ArrayList<String> topWord = new ArrayList<> ();

        int fc = 0;

        String t = "";
        for (Map.Entry<String, Integer> msi : collect.entrySet ()) {

            String w = msi.getKey ();
            Integer c = msi.getValue ();

            if (fc != c) {
                i++;
                fc = c;
                if (i > n) {
                    break;
                }
            }
            topWord.add (w);
            t += "(" + w + "," + c + ") ";

        }
        t = t.substring (0, t.length () - 1);
        ans.add (t);
        for (String w : topWord) {
            List<Integer> li = tls.get (w);
            for (Integer idx : li) {
                v[idx] = 1;
            }
        }
        for (int j = 0; j < v.length; j++) {
            if (v[j] == 1) {
                ans.add (contents[j]);
            }
        }
        String[] ss = new String[ans.size ()];
        i = 0;
        for (String s : ans) {
            ss[i++] = s;
        }
        return ss;
    }

    public int calculate(String expression) {
        // write code here
        ScriptEngineManager manager = new ScriptEngineManager ();
        ScriptEngine e = manager.getEngineByName ("JavaScript");
        try {
            Object res = e.eval (expression);
            cc
        } catch (ScriptException ex) {
            throw new RuntimeException (ex);
        }
    }

    @Test
    public void test() {

        String[] c = {"The dog wags its tail when it is happy.", "The dog likes to play with a ball.", "The cat purrs softly when it is content.", "The dog and the cat sometimes play together in the yard."};
        String[] t = {"with", "when", "The", "the", "for", "it", "is", "a"};
        int n = 2;
        System.out.println (Arrays.toString (topWords (c, t, n)));
    }

    @Test
    public void test2() {
        String s = "3 + 5 * 2 / ( 4 - 2 )";
        System.out.println (calculate (s));
    }
}
