package DataStructure.深度优先搜索.day_2020_6_18;
import java.lang.reflect.Array;
import java.util.*;


/**
 * @Author: 饶嘉伟
 * @Description:
 *
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。
 * 有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
 * 给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。
 * 设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，
 * 并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * 在结果列表中，选择字典序最小的名字作为真实名字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baby-names-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/6/19 16:21
 * @Param:a
 * @return a
 **/

public class 面试题1707婴儿名字 {
    public static void main(String[] args) {
        String names[]={"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};

        String synonyms[]={"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        Solution s=new Solution ();
        s.trulyMostPopular (names,synonyms);
    }
}

/**
 * @Author: 饶嘉伟
 * @Description
 *              这题又是那种恶心死人不偿命的玩意
 *              给的数据不友好，需要自己提前把需要的数据用恰当的数据结构整合起来
 *              这道题目本来就是一道图的连通性的问题
 *              并查集效率会更高一些
 *              但是dfs和bfs也可以
 *              步骤：
 *                  1.将两个数组中需要的信息提取出来
 *                  2.对应的synonyms中的信息用hashMap保存，方便以后的遍历
 *                  3.利用bfs对names中的每个名字开始遍历，找到每一个子图，
 *                  并且将子图中的各个数据相加
 * @D 2020/6/19 16:19
 * @Para: a
 * @retun: a
 **/

class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {

        if(names.length<=0){
            return new String[0];
        }
        if(synonyms.length==0){
            return names;
        }

        int number[]=new int[names.length];

        Map<String,List<String>> commonNameMap=new HashMap();
        Map<String,Integer> name2index=new HashMap<>();
        Map<String,Integer> res=new HashMap<> ();
        int i=0;
        for(String str:names){
            name2index.put(str.substring (0,str.indexOf ('(')),i);
            number[i++]=Integer.parseInt
                    (str.substring(str.indexOf ('(')+1,str.lastIndexOf(')')));

        }

//        System.out.println (Arrays.toString (number));
        for(String str:synonyms){
            String first=str.substring (str.indexOf ('(')+1,str.indexOf (','));
            String second=str.substring (str.indexOf (',')+1,str.indexOf (')'));
            commonNameMap.computeIfAbsent (first,x->new ArrayList<> ()).add (second);
            commonNameMap.computeIfAbsent (second,x->new ArrayList<> ()).add (first);
        }
//        for(String key:commonNameMap.keySet ()){
//            for (String str:commonNameMap.get (key)) {
//                System.out.println (key + "-----" + str);
//            }
//        }
        boolean visited[]=new boolean[names.length];
        LinkedList<String> commonNames=new LinkedList<> ();

        for (int j = 0; j <names.length ; j++) {
            String str=names[j].substring (0,names[j].indexOf ('('));
            if(!visited[j]){
                 commonNames.add(str);
                 visited[j]=true;
                 int ans=number[name2index.get (str)];
                 res.put (str,ans);
                 while(!commonNames.isEmpty ()){
                     String name=commonNames.poll ();
                     if(!commonNameMap.containsKey (name))
                         continue;
                     for(String relateName:commonNameMap.get (name)){
                        if(!name2index.containsKey (relateName))
                             continue;
                        int index=name2index.get (relateName);
                        if(!visited[index]) {
                            ans += number[index];
                            if (relateName.compareTo (str) < 0) {
                                res.remove (str);
                                str = relateName;
                            }
                            visited[index] = true;
                            res.put (str, ans);
                            commonNames.add(relateName);
                        }
                     }
                 }
            }
        }
        String lastResult[]=new String[names.length];
        int k=0;
        for(Map.Entry<String,Integer> entry : res.entrySet ()){
               lastResult[k++]=entry.getKey ()+"("+entry.getValue ()+")";
        }
        return Arrays.copyOf (lastResult,k);
    }
}
