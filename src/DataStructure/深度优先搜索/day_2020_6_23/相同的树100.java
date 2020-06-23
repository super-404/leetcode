package DataStructure.深度优先搜索.day_2020_6_23;

import DataStructure.深度优先搜索.Tree.TreeNode;

import java.util.ArrayList;
import java.util.ListIterator;

public class 相同的树100 {
}
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1=new ArrayList ();
        ArrayList<TreeNode> list2=new ArrayList();
        dfs(list1,p);
        dfs(list2,q);
        ListIterator<TreeNode> li1=list1.listIterator ();
        ListIterator<TreeNode> li2=list2.listIterator ();
        boolean flag=true;
        while(li1.hasNext ()&&li2.hasNext ()){
            TreeNode t1=li1.next();
            TreeNode t2=li2.next();
            if(t1==null&&t2!=null||t1!=null&&t2==null){
                flag=false;
            }
            if(t1!=null&&t2!=null){
                if(t1.val!=t2.val){
                    flag=false;
                }
            }
        }
        return flag;
    }
    public void dfs(ArrayList<TreeNode> list,TreeNode root){
        list.add(root);
        if(root==null){
            return ;
        }
        dfs(list,root.left);
        dfs(list,root.right);
    }
}
class Solution3 {
    boolean flag=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        return flag;

    }
    public void dfs(TreeNode p,TreeNode q){
        if(p==null&&q!=null||p!=null&&q==null){
            flag=false;
            return;
        }
       else
           if(p!=null&&q!=null){
            if(p.val!=q.val){
                flag=false;
            }
        }
        else{
          return;
        }

        dfs(p.left,q.left);
        dfs(q.left,q.right);
    }
}
