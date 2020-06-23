package DataStructure.图.判断图中是否存在环;

import java.util.LinkedList;
import java.util.Scanner;

public class test {
    int graph[][];
    int color[];
   static int count;
    public void creatGraph(int i,int j){
        Scanner in=new Scanner(System.in);
        graph=new int[i][i];
        color =new int [i];
        for (int k = 0; k <j ; k++) {
            int m=in.nextInt ();
            int n=in.nextInt ();
            graph[m][n]=1;
            graph[n][m]=1;
        }
    }
    public void isHavingCircle(int i){
        color[i]=1;
        for (int j = 0; j <graph[i].length; j++) {
            if(graph[i][j]==1){
                if(color[j]==1){
                    count++;
                }
                else{
                    //如果已经检测到了有环了，后面的没必要再遍历了返回
                    isHavingCircle (j);
                }
            }
        }
        color[i]=-1;
    }

    public static void main(String[] args) {
        test t=new test ();
        Scanner in=new Scanner(System.in);
        System.out.println ("请输入顶点个数和边的个数");
        int ver=in.nextInt ();
        int edge=in.nextInt ();
        t.creatGraph ( ver,edge);
        int flag=0;

        for (int i = 0; i <ver; i++) {
            if(t.color[i]!=1&&t.color[i]!=-1)
                t.isHavingCircle (i);
            if(count>0){
                flag=1;
            }
        }
       if(flag==1){
           System.out.println ("有环");
       }else{
            System.out.println ("无环");
       }
        System.out.println (count);
    }
}

