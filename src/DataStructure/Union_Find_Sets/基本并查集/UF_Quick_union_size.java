package DataStructure.Union_Find_Sets.基本并查集;

import java.util.Arrays;

/**
 * @Author: 饶嘉伟
 * @Description
 *
 *    基于节点大小的优化
 *    让节点数更小的集合，合并到节点数更大的集合上
 *    减小整个树的高度，避免出现在查找的时候出现O（n）的时间复杂度
 *
 * @Date: 2020/3/26 17:28
 * @Para: a
 * @retun: a
 **/

public class UF_Quick_union_size extends BaseUF{
    private int capacity=10;
    private  int size[]=new int[capacity];
    UF_Quick_union_size(){
        super();
        for (int i = 0; i <capacity ; i++) {
            size[i]=1;
        }
    }
    public static void main(String[] args) {
        UF_Quick_union_size uf_quick_union_size = new UF_Quick_union_size ();
        new Test ().test (uf_quick_union_size);
        System.out.println (Arrays.toString (uf_quick_union_size.size));
    }
    @Override
    public  int find(int v) {
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    @Override
    public void union(int v, int p) {
        int p1 = find (v);
        int p2 = find (p);

        if (p1 == p2)
            return;
        //基于size的优化
        if(size[p1]<size[p2]) {
            parents[p1] = p2;
            //p1指向p2
            //那么合并以后size[p2]的节点个数应该加上p1的节点个数
            size[p2]+=size[p1];
        }
        else {

                parents[p2]=p1;
                //同理
                size[p1]+=size[p2];
            }

    }

    @Override
    public boolean isSame(int v, int p) {
        return find (v) == find (p);
    }
}
