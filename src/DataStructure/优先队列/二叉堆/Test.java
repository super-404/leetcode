package DataStructure.优先队列.二叉堆;

/**
 * @program: leetcode
 * @description: 测试二叉堆
 * @author: 饶嘉伟
 * @create: 2020-11-09 15:15
 **/
public class Test {
    @org.junit.Test
    public void creat() {
        MaxPQ<Integer> t = new MaxPQ<> ();
        t.insert (1);
        t.insert (7);
        t.insert (5);
        t.insert (-3);
        t.insert (8);
        t.insert (10);
        t.insert (-4);
        t.insert (9);
        t.insert (14);
        t.insert (23);
        t.insert (-9);
        System.out.println (t.delMax ());
    }
}
