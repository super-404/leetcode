package DataStructure.深度优先搜索.day_2020_6_23;

import DataStructure.深度优先搜索.Tree.TreeNode;

import java.util.HashMap;

/**
 * @Author: 饶嘉伟
 * @Description
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: 2020/6/23 15:49
 * @Para: a
 * @retun: a
 **/

public class 从中序与后序遍历序列构造二叉树106 {

}

class Solution1 {
    int [] in;
    int [] post;
    HashMap<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in=inorder;
        post=postorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode build(int inLeft,int inRight,int postLeft,int postRight){

        if(postLeft>postRight||inLeft>inRight){
            return null;
        }

        int val=map.get(post[postRight]);

        TreeNode root=new TreeNode(in[val]);

        root.left=build(inLeft,val-1,postLeft,postLeft+val-inLeft-1);

        root.right=build(val+1,inRight,postLeft+val-inLeft,postRight-1);

        return root;
    }
}
