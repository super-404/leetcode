package DataStructure.图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Definition for a Node
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node> ();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node> ();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-30 09:47
 **/
public class 克隆图133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap ();

        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add (node);
        // 克隆第一个节点并存储到哈希表中
        visited.put (node, new Node (node.val, new ArrayList ()));

        // 广度优先搜索
        while (!queue.isEmpty ()) {
            // 取出队列的头节点
            Node n = queue.remove ();
            // 遍历该节点的邻居
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey (neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put (neighbor, new Node (neighbor.val, new ArrayList ()));
                    // 将邻居节点加入队列中
                    queue.add (neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get (n).neighbors.add (visited.get (neighbor));
            }
        }

        return visited.get (node);
    }
}
