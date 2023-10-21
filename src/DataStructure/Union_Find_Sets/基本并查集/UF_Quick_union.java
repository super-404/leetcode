package DataStructure.Union_Find_Sets.基本并查集;

import java.util.Arrays;

/**
 * @Author: 饶嘉伟
 * @Description 合并时间为O(logn)
 * 查找时间也为O（logn）
 * @Date: 2020/3/26 16:59
 * @Para: DataStructure.a
 * @retun: DataStructure.a
 **/

public class UF_Quick_union extends BaseUF {

    public static void main(String[] args) {
        UF_Quick_union uf_quick_union = new UF_Quick_union ();
        uf_quick_union.union (0, 1);
        uf_quick_union.union (1, 3);
        uf_quick_union.union (5, 6);
        uf_quick_union.union (4, 5);
        uf_quick_union.union (7, 6);
        System.out.println (Arrays.toString (uf_quick_union.parents));

        System.out.println (uf_quick_union.isSame (4, 7));
        System.out.println (uf_quick_union.isSame (0, 3));
    }


    @Override
    public int find(int v) {
        //路径压缩保证在查找一遍过后
        //路径上的每个节点都会指向根节点
        if (v != parents[v]) {
            parents[v] = find (parents[v]);
        }
        //注意这里要返回根节点
        return parents[v];
    }

    @Override
    public void union(int v, int p) {
        int p1 = find (v);
        int p2 = find (p);
        if (p1 == p2)
            return;
        parents[p1] = p2;
    }

    @Override
    public boolean isSame(int v, int p) {
        return find (v) == find (p);
    }
}
