package DataStructure.字典树;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-13 13:21
 **/
class Trie1 {
    private Node root;

    class Node {

        private HashMap<Character, Node> children;
        private boolean isEnd;

        public Node() {
            this.children = new HashMap<> ();
            this.isEnd = false;
        }
    }

    public Trie1() {
        this.root = new Node ();
    }

    //插入一个单词
    public void insert(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length (); i++) {
            char ch = word.charAt (i);
            //如果插入时是一个新的字符，创建一个新的结点
            if (!cur.children.containsKey (ch)) {
                cur.children.put (ch, new Node ());
            }
            //如果已经存在
            cur = cur.children.get (ch);
        }
        //插入完毕
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length (); i++) {
            char ch = word.charAt (i);
            //如果不在hashmap中，说明查找失败
            if (!cur.children.containsKey (ch)) {
                return false;
            }
            //如果已经存在
            cur = cur.children.get (ch);
        }
        //判断是不是一个完整的单词
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length (); i++) {
            char ch = prefix.charAt (i);
            //如果不在hashmap中，说明查找失败
            if (!cur.children.containsKey (ch)) {
                return false;
            }
            //如果已经存在
            cur = cur.children.get (ch);
        }
        //判断前缀不需要一个完整的单词
        return true;
    }

    public String query(String str) {
        Node cur = root;
        for (int i = 0; i < str.length (); i++) {
            char c = str.charAt (i);
            if (!cur.children.containsKey (c)) {
                break;
            }

            cur = cur.children.get (c);
            if (cur.isEnd) {
                return str.substring (0, i + 1);
            }

        }
        return str;
    }
}

public class Replace_Words648 {
    public String replaceWords(List<String> dictionary, String sentence) {

        String[] s = sentence.split (" ");
        StringBuilder strb = new StringBuilder ("");
        Trie1 t = new Trie1 ();
        for (String sdic : dictionary) {
            t.insert (sdic);
        }
        System.out.println (t.search ("rat"));
        for (int i = 0; i < s.length; i++) {

            strb = strb.append (t.query (s[i])).append (" ");
        }
        return strb.toString ().substring (0, strb.length () - 1);
    }

    @Test
    public void test() {
        List<String> ls = new ArrayList<> ();
        ls.add ("cat");
        ls.add ("bat");
        ls.add ("rat");
        ls.add ("ca");
        String sentence = "the cattle was rattled by the battery";

        String s = new Replace_Words648 ().replaceWords (ls, sentence);
        System.out.println (s);
    }
}
