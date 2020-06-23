package DataStructure.Union_Find_Sets.leetcode_union练习;

import java.util.*;

/**
 * @Author: 饶嘉伟
 * @Description:
 *  这道题目对我来说比较难，
 *  也是花了比较久的时间
 *  主要还是在构建题目的数据结构上想不明白
 *  比较复杂，题目
 *  一旦想清楚以后
 *  还有许多细节需要注意
 *  麻烦
 *
 *  这道题目还可以用并查集来解决，我是真的看不明白
 *  还是图+dfs来的简单
 *  可以构建一个双向图
 *
 *  a----2.0->b
 *  b----0.5-->a
 *  在进行遍历时，对每条边上的权值执行乘法操作
 *
 * @Date: 2020/3/28 21:21
 * @Param a
 * @retur: a
 **/

public class CalcEquation {

    Map<String, Map<String,Double>> graph=new HashMap<> ();

    public static void main(String[] args) {
        List<List<String>> equ=new LinkedList<> ();

        List<String> ls=new LinkedList<> ();
        ls.add ("a");
        ls.add ("b");
        equ.add (ls);
        List<String> ls2=new LinkedList<> ();
        ls2.add ("b");
        ls2.add ("c");
        equ.add (ls2);
        double [] v={2.0,3.0};
        List<List<String>> queries=new LinkedList<> ();
        List<String> ls3=new LinkedList<> ();
        ls3.add ("a");
        ls3.add ("c");
        queries.add (ls3);
        List<String> ls4=new LinkedList<> ();
        ls4.add ("b");
        ls4.add ("a");
        queries.add (ls4);
        List<String> ls5=new LinkedList<> ();
        ls5.add ("a");
        ls5.add ("e");
        queries.add (ls5);
        List<String> ls6=new LinkedList<> ();
        ls6.add ("a");
        ls6.add ("a");
        queries.add (ls6);
        List<String> ls7=new LinkedList<> ();
        ls7.add ("x");
        ls7.add ("x");
        queries.add (ls7);
        CalcEquation calcEquation = new CalcEquation ();

        calcEquation.calcEquation (equ,v,queries);


    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(equations.size ()==0){
            return null;
        }
        doGraph (equations,values);
        double[] res = new double[queries.size ()];
        int i=0;
        for (List<String> ls:
             queries) {
            res[i++]=dfs(graph,ls.get (0),ls.get(1),new HashSet<> (),1.0);
        }
        return res;
    }

    public  double dfs(Map<String, Map<String, Double>> graph, String first,String second, HashSet<Object> objects,double answer) {
          if(!graph.containsKey (first)||!graph.containsKey (second)){
              return -1;
          }
          Map<String,Double> edge=graph.get (first);
          if(first.equals (second))
              return 1;

              for (Map.Entry<String ,Double> entry :
                      edge.entrySet ()) {
                  //注意这里判断的是否访问过的条件
                  //                  //要小心
                  if(!objects.contains (entry.getKey ())) {
                  objects.add (entry.getKey ());
                  //说明已经找到了终点；
                  double v=entry.getValue ();
                  String goal=entry.getKey ();
                    if(goal.equals (second)){
                        return answer*v;
                  }
                    //如果没有找到的话，深度优先搜索
                  double res=dfs(graph,goal,second,objects,answer*v);
                    //处理返回值
                      //                      //如果res!=-1说明 goal.equals(second)为真也就是说，问题已经得到解决，可以直接返回
                      if(res!=-1){
                          return res;
                      }
              }
          }
              //没有找到的话
              return -1;
    }

    public void doGraph(List<List<String>> equations, double[] values) {
        int i=0;
        for (List<String> ls:
              equations) {
            String first=ls.get (0);
            String second=ls.get (1);
            Map<String,Double> sd=new HashMap<> ();
            sd.put (second,values[i]);
            //如果不存在该节点
            if(!graph.containsKey (first)){
                graph.put (first,sd);
            }
            //如果存在该节点的话，就选择put一下，避免被覆盖
            else{
                graph.get (first).put (second,values[i]);
            }
            Map<String,Double> sb=new HashMap<> ();
            sb.put(first,1/values[i]);
            //同理
            if(!graph.containsKey (second)){
                graph.put (second,sb);
            }else{
                graph.get (second).put (first,1/values[i]);
            }
            i++;
        }
    }
}
