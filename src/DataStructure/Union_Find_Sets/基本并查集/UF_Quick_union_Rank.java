package DataStructure.Union_Find_Sets.基本并查集;


import java.util.Arrays;

/**
 * @Author: 饶嘉伟
 * @Description 前一个size的优化，并不能保证在每种情况下的两颗树合并后的高度是最小的
 * 因此有了基于树的高度的优化，rank
 * 在这种优化下，小树永远指向大树，可以有效地避免不必要的树高的增大
 * @Date: 2020/3/26 17:42
 * @Para: DataStructure.a
 * @retun: DataStructure.a
 **/

public class UF_Quick_union_Rank extends BaseUF {
    private int capacity = 10;
    private int rank[] = new int[capacity];

    UF_Quick_union_Rank() {
        super ();
        for (int i = 0; i < capacity; i++) {
            rank[i] = 1;
        }
    }

    public static void main(String[] args) {
        UF_Quick_union_Rank uf_quick_union_size = new UF_Quick_union_Rank ();
        new Test ().test (uf_quick_union_size);
        System.out.println (Arrays.toString (uf_quick_union_size.rank));
    }

    @Override
    public int find(int v) {
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
        //基于rank的优化
        if (rank[p1] < rank[p2]) {
            //小树指向大树
            parents[p1] = p2;
        } else {
            //同理
            if (rank[p1] > rank[p2])
                parents[p2] = p1;
                //只有当两颗树高度相同时。
                //合并后的树的高度增1
            else {
                parents[p2] = p1;
                rank[p1]++;
            }
        }

    }

    @Override
    public boolean isSame(int v, int p) {
        return find (v) == find (p);
    }
}
