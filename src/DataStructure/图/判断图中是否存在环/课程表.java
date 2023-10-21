package DataStructure.图.判断图中是否存在环;

import java.util.LinkedList;

public class 课程表 {


    //方法一采用拓扑排序的方法，利用队列
    public boolean solution1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        int cg[][] = new int[numCourses][numCourses];
        //每个顶点的入度表
        int inDegree[] = new int[numCourses];


        //求出每个顶点的入度
        for (int i = 0; i < prerequisites.length; i++) {
            cg[prerequisites[i][1]][prerequisites[i][0]] = 1;
            inDegree[prerequisites[i][0]]++;
        }
        int count = 0;
        LinkedList<Integer> li = new LinkedList<> ();
        //如果当前的顶点入度为0，那么加入到队列中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                li.add (i);
            }
        }
        //如果队列不为空
        while (!li.isEmpty ()) {
            //弹出队首顶点
            int i = li.pollFirst ();
            //计数器加1
            count++;
            //遍历所有与该顶点有连接的顶点
            for (int k = 0; k < numCourses; k++) {
                if (cg[i][k] == 1) {
                    //断开与该顶点的连接
                    //且发现断开连接后入度也为零，加入队列
                    if (--inDegree[k] == 0) {
                        li.add (k);
                    }
                }
            }
        }
        if (count < numCourses) {
            return false;
        } else {
            return true;
        }

    }

    int color[];
    //每个顶点都有三个标志或者说颜色
    //0 表示未访问过
    //1 表示访问过这个顶点
    //-1 表示访问该顶点以及其后代顶点


    //方法2 利用dfs遍历判断有没有环的存在，性能略低
    //用这种方法判断环的存在时，不能简单的认为
    public boolean solution2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        int cg[][] = new int[numCourses][numCourses];
        color = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            cg[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (!isOk (cg, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOk(int cg[][], int i) {
        //访问过的顶点，标志位1
        color[i] = 1;
        for (int j = 0; j < cg[i].length; j++) {
            if (cg[i][j] == 1) {
                //如果又碰到了访问过的节点，那么肯定是有环的
                if (color[j] == 1)
                    return false;
                else {
                    if (color[j] == -1)
                        continue;
                    else {
                        if (!isOk (cg, j)) {
                            return false;
                        }
                    }
                }
            }
        }
        color[i] = -1;
        return true;
    }
}

