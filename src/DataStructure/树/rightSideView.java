package DataStructure.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-09 14:09
 **/
public class rightSideView {
    List<Integer> li = new ArrayList<> ();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return li;
        }
        solution (root, 1);
        return li;
    }

    public void solution(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth - 1 == li.size ()) {
            li.add (root.val);
        }
        solution (root.right, depth + 1);
        solution (root.left, depth + 1);


    }
}
