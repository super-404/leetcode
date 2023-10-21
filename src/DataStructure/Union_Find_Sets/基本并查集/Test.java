package DataStructure.Union_Find_Sets.基本并查集;

import java.util.Arrays;

public class Test {
    public void test(BaseUF uf_qf) {
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
