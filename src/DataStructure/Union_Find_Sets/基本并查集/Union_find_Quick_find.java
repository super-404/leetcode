package DataStructure.Union_Find_Sets.基本并查集;

import java.util.Arrays;

/**
 * @Author: 饶嘉伟
 * @Description 查找时间复杂度是O(1)
 * 合并时间复杂度是O（n）
 * 合并太慢了，不建议使用
 * @Date: 2020/3/26 16:26
 * @Para: DataStructure.a
 * @retun: DataStructure.a
 **/

public class Union_find_Quick_find extends BaseUF {
    private int parents[] = new int[10];

    Union_find_Quick_find() {
        for (int i = 0; i < 10; i++) {
            parents[i] = i;
        }
    }

    public int find(int v) {
        return parents[v];
    }

    public void union(int v, int p) {
        //v的祖先节点
        int p1 = find (v);
        //p的祖先节点
        int p2 = find (p);

        if (p1 == p2) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }

    public boolean isSame(int v, int p) {
        return find (v) == find (p);
    }

    public static void main(String[] args) {
        Union_find_Quick_find uf_qf = new Union_find_Quick_find ();
        uf_qf.union (0, 1);
        uf_qf.union (1, 3);
        uf_qf.union (5, 6);
        uf_qf.union (4, 5);
        uf_qf.union (7, 6);
        System.out.println (Arrays.toString (uf_qf.parents));
        ;
        System.out.println (uf_qf.isSame (2, 3));
    }
}
