package DataStructure.深度优先搜索.day_2020_5_27;


/**
 * @Author: 饶嘉伟
 * @Description:
 * 我这里是利用了迪杰斯特拉的求单源最短路径做的
 *
 * @Date: 2020/5/27 20:34
 * @Param a
 * @retur: a
 **/

public class 网络延迟时间743 {
    public static void main(String[] args) {
        Solution1 s=new Solution1 ();
        int times[][]={{2,1,1},{2,3,1},{3,4,1}};
        System.out.println (s.networkDelayTime (times,4,2));
    }
}
class Solution1{
    public int networkDelayTime(int[][] times, int N, int K) {
        int k=K;
        int grid[][]=new int[N+1][N+1];
        int dist[]=new int[N+1];
        boolean isVisited[]=new boolean[N+1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                grid[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<times.length;i++){
            grid[times[i][0]][times[i][1]]=times[i][2];
        }
        for(int i=0;i<grid[0].length;i++){
            dist[i]=grid[k][i];
        }
        dist[k]=0;
        isVisited[k]=true;
        for(int i=1;i<grid.length;i++){
            int min=Integer.MAX_VALUE;
            int goal=0;
            for(int j=1;j<grid.length;j++){
                if(!isVisited[j]&&dist[j]<min){
                    goal=j;
                    min=dist[j];
                }
            }
            isVisited[goal]=true;
            for(int m=1;m<grid.length;m++){
                if(!isVisited[m]&&grid[goal][m]<Integer.MAX_VALUE){
                    if(dist[goal]+grid[goal][m]<dist[m]){
                        dist[m]=dist[goal]+grid[goal][m];
                    }
                }
            }
        }
        int max=0;
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            else{
                if(dist[i]>max)
                    max=dist[i];
            }
        }
        return max;
    }
}
