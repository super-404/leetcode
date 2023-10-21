package DataStructure.树;

/**
 * @program: leetcode
 * @description: 2-3树的实现
 * @author: 饶嘉伟
 * @create: 2020-10-18 16:04
 **/


//键值对的形式
//Key 必须是可比较的
//Value 随意
public class TwoThreeTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int size;

    private class Node {
        //        int m=3;
//        Entry[] children = new Entry[3];
        Node left;
        Node right;
        Node mid;
        Key key;
        Object val;
        boolean isTwo = true;

        public Node(Key key, Object val, boolean isTwo) {
            this.key = key;
            this.val = val;
            this.isTwo = isTwo;
        }
    }

    private class Entry {
        private Node next;
        Comparable key;
        Object val;

        public Entry(Node next, Comparable key, Object val) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Node put(Key key, Value value) {
        root = put (root, key, value);
        return root;
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) {
            return new Node (key, value, true);
        }
        return null;
    }
}
