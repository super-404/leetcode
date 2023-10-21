package DataStructure.深度优先搜索.day_2020_5_31;

import java.util.ArrayList;

public class 叶子相似的树872 {


}

class dfs {
    ArrayList<Integer> li1 = new ArrayList<> ();
    ArrayList<Integer> li2 = new ArrayList<> ();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getRes (root1, li1);
        getRes (root2, li2);
        return li1.equals (li2);
    }

    public void getRes(TreeNode root, ArrayList arrayList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arrayList.add (root.val);
        }
        getRes (root.left, arrayList);
        getRes (root.right, arrayList);
    }
}
