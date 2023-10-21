package DataStructure.优先队列.二叉堆;

/**
 * @program: leetcode
 * @description: 二叉堆的思想
 * @author: 饶嘉伟
 * @create: 2020-11-09 14:56
 **/
public class MaxPQ<Key extends Comparable> {

    private Key[] pq;
    private int size = 0;

    public MaxPQ() {
        pq = (Key[]) new Comparable[15];
    }

    //创建一个初始容量是max的优先队列
    public MaxPQ(int max) {

        //java不允许直接创建泛型数组
        //所以只能通过泛型强转
        pq = (Key[]) new Comparable[max];
    }

    //利用PQ创建一个优先队列
    public MaxPQ(Key k[]) {
        pq = k;
    }

    private boolean less(int i, int j) {
        if (pq[i].compareTo (pq[j]) < 0)
            return true;
        else
            return false;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {

        while (k > 1 && less (k / 2, k)) {
            exch (k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {

        while (2 * k < size) {
            int j = 2 * k;
            if (j + 1 < size && less (j, j + 1))
                j++;
            if (less (j, k))
                break;
            exch (j, k);
            k = 2 * k;
        }
    }

    public void insert(Key k) {
        if (size + 1 < pq.length) {
            pq[++size] = k;
            swim (size);
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch (1, size);
        pq[size] = null;
        size--;
        sink (1);
        return max;
    }
}
