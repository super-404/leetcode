package DataStructure.散列表;

/**
 * @program: leetcode
 * @description: 基于拉链法实现的散列表
 * @author: 饶嘉伟
 * @create: 2020-10-25 20:20
 **/
public class SeparateChainingHashST<Key, Value> {

    int M;//散列表中键值对的个数
    Node<Key, Value>[] chain;//存放数据的节点

    class Node<Key, Value> {
        Key key;
        Value val;
        Node next;
        Node first;

        public Node(Key k, Value v, Node first) {
            this.key = k;
            this.val = v;
            this.next = first;
        }

        public Node() {

        }

        public void put(Key key, Value value) {
            for (Node next = first; next != null; next = next.next) {
                if (next.key == key) {
                    next.val = value;
                    return;
                }
            }
            first = new Node (key, value, first);
        }

        public Value get(Key key) {
            for (Node next = first; next != null; next = next.next) {
                if (key.equals (next.key)) {
                    return (Value) next.val;
                }
            }
            return null;
        }

        public void delete(Key key) {

            for (Node next = first, pre = null; next != null; pre = next, next = next.next) {
                if (key.equals (next.key)) {
                    if (pre == null) {
                        first = first.next;
                    } else {
                        pre.next = next.next;
                    }
                }
            }
        }
    }

    public SeparateChainingHashST() {
        this (10);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        chain = (Node<Key, Value>[]) new Node[M];
        for (int i = 0; i < M; i++) {
            chain[i] = new Node ();
        }
    }

    //获取hash值
    public int hash(Key k) {
        return (k.hashCode () & 0x7fff_ffff) % M;
    }

    public void put(Key key, Value value) {
        int hash = this.hash (key);
        chain[hash].put (key, value);
    }

    public Value get(Key key) {
        int hash = this.hash (key);
        return chain[hash].get (key);
    }

    public void delete(Key key) {
        int hash = this.hash (key);
        chain[hash].delete (key);
    }

    public void print() {
        for (int i = 0; i < M; i++) {
            for (Node next = chain[i].first; next != null; next = next.next) {
                System.out.print ("[" + next.key + "," + next.val + "]");
            }
            System.out.println ();
        }
    }
}
