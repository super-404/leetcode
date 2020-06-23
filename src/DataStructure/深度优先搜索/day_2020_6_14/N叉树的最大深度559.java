package DataStructure.深度优先搜索.day_2020_6_14;
import java.util.LinkedList;
import java.util.List;
public class N叉树的最大深度559 {

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


//这个是利用层序遍历加上队列来判断的
//因为层次遍历，是从树的根节点开始，一层一层遍历的
//
/*
 步骤：
    1.根节点如果不为空，添加进入队列
    2.根据队列中的元素初始化levelSize
    3.队列每弹出一个元素，levelSize--,代表已经遍历过该层一个节点
    4.将队列中元素的子节点加入队列
    5.当上一层被遍历完毕以后，也就是，levelSize==0 此时队列中的元素即为该层的元素个数.
 */
class Solution1 {
    int max=0;
    public int maxDepth(Node root) {
        LinkedList<Node> queue=new LinkedList();
        if(root!=null) {
            queue.add (root);
        }
        int levelSize=queue.size();
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            levelSize--;
            for(Node node : temp.children){
                if(node!=null){
                    queue.add(node);
                }
            }
            if(levelSize==0){
                max++;
                levelSize=queue.size();
            }
        }
        return max;
    }

}
