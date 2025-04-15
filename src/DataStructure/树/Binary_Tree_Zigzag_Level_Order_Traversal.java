package DataStructure.树;

import com.sun.xml.internal.bind.v2.TODO;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-06 09:26
 **/
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<List<Integer>> ();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> quene = new LinkedList<> ();
        TreeNode node = root;

        //记录每一层的节点个数,至少是1；
        int size = 1;
        //记数
        int count = 0;
        //从左到右
        boolean flag = true;
        quene.add (node);
        while (!quene.isEmpty ()) {
            int n = size;
            size = 0;
            LinkedList<Integer> ls = new LinkedList<> ();
            for (int i = 0; i < n; i++) {
                TreeNode r = quene.remove ();
                if (flag) {
                    ls.addLast (r.val);
                } else {
                    ls.addFirst (r.val);
                }
                if (r.left != null) {
                    size++;
                    quene.add (r.left);
                }
                if (r.right != null) {
                    size++;
                    quene.add (r.right);
                }
            }
            flag = !flag;
            ans.add (ls);
        }
        return ans;
    }

    @Test
    public void Test_func() {
        TreeNode tree = new TreeNode ();
        Integer a[] = {5, -100, -10, 9, 20, -100, -100, 15, 7};
        TreeNode root = TreeNode.getLeetCodeTree (a);
        TreeNode.preprint (root);
        List<List<Integer>> lists = zigzagLevelOrder (root);
        System.out.println (lists);
    }
}

