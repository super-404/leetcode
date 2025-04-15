package DataStructure.字典树;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 实现一个字典树
 * @author: 饶嘉伟
 * @create: 2024-03-07 09:04
 **/
public class Trie {
    private Node root;

    class Node {

        private HashMap<Character, Node> children;
        private boolean isEnd;

        public Node() {
            this.children = new HashMap<> ();
            this.isEnd = false;
        }
    }

    public Trie() {
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

    @Test
    //测试插入方法
    public void testInsert() {
        Trie t = new Trie ();
        t.insert ("aaaabbbb");
        boolean ans = t.search ("aaaabbbb");
        Assert.assertTrue (ans);
        boolean ans1 = t.search ("aaaabbbbcc");
        Assert.assertFalse (ans1);
    }

    @Test
    public void test() {
        String str = "trie";
        String str1 = "startswith";
        TrieArray ta = new TrieArray ();
        ta.insert (str);
        ta.insert (str1);
        System.out.println (ta.search ("a"));
        System.out.println (ta.startsWith ("a"));
    }
}

class TrieArray {
    static int N = 100009;
    static int trie[][] = new int[N][26];
    static int isEnd[] = new int[N];

    public TrieArray() {

    }

    public void insert(String str) {
        int child = 0;
        for (int i = 0; i < str.length (); i++) {
            int index = str.charAt (i) - 'a';
            if (trie[child][index] == 0) {
                trie[child][index]++;
            }
            child++;
        }
        isEnd[child] = 1;
    }

    public boolean search(String str) {
        int child = 0;
        for (int i = 0; i < str.length (); i++) {
            int index = str.charAt (i) - 'a';
            if (trie[child][index] == 0) {
                return false;
            }
            child++;
        }
        return isEnd[child] > 0;
    }

    public boolean startsWith(String str) {
        int child = 0;
        for (int i = 0; i < str.length (); i++) {
            int index = str.charAt (i) - 'a';
            if (trie[child][index] == 0) {
                return false;
            }
            child++;
        }
        return true;
    }

}
