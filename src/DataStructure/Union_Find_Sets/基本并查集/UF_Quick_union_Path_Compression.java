package DataStructure.Union_Find_Sets.基本并查集;

import java.util.Arrays;

public class UF_Quick_union_Path_Compression extends BaseUF {

    public static void main(String[] args) {
        UF_Quick_union uf_quick_union = new UF_Quick_union ();
        uf_quick_union.union (0, 1);
        uf_quick_union.union (1, 3);
        uf_quick_union.union (5, 6);
        uf_quick_union.union (4, 5);
        uf_quick_union.union (7, 6);
        System.out.println (Arrays.toString (uf_quick_union.parents));

        System.out.println (uf_quick_union.isSame (4, 7));
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
        parents[p1] = p2;
    }

    @Override
    public boolean isSame(int v, int p) {
        return find (v) == find (p);
    }
}


