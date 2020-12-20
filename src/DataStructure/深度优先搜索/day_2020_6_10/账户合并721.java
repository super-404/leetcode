package DataStructure.深度优先搜索.day_2020_6_10;

import java.io.Console;
import java.util.*;
//       给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，
//       其中第一个元素 accounts[i][0] 是 名称 (name)，
//       其余元素是 emails 表示该帐户的邮箱地址。
//
//        现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，
//        则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，
//        它们也可能属于不同的人，因为人们可能具有相同的名称。
//        一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
//
//        合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，
//        其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/accounts-merge
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


/**
 * @Author: 饶嘉伟
 * @Description
 *
 * 这题主要是要求拥有相同账户的两个列表合并成一个
 * 我确实没想到可以用图
 * 可以的学习了
 *
 * 步骤1:利用hashMap将每个列表中的账号形成映射关系

    把每个账户下面的邮件都联系起来，
    例如如果王二账户下有a,b,c三个邮件名
    那么最后就会得到这样的一个无向图
     c
    / \
    a--b
   步骤2: 构建好图以后，题目中的要求实际上就是查找无向图中的连通分量，
 *          利用dfs,或者bfs,或者并查集都可以
 *  * @Date: 2020/6/11 17:11
 * @Para: a
 * @retun: a
 **/

public class 账户合并721 {

    public static void main(String[] args) {

        List<List<String>> lls = new ArrayList ();
        List<String> ls1 = new ArrayList<> ();
        ls1.add ("王二");
        ls1.add ("a");
        ls1.add ("b");
        lls.add (ls1);
        List<String> ls2 = new ArrayList<> ();
        ls2.add ("王二");
        ls2.add ("c");
        ls2.add ("b");
        lls.add (ls2);
        List<String> ls3 = new ArrayList<> ();
        ls3.add ("张三");
        ls3.add ("d");
        lls.add (ls3);
        List<String> ls4 = new ArrayList<> ();
        ls4.add ("王二");
        ls4.add ("f");
        lls.add (ls4);
        System.out.println (lls);
        Solution1 s1=new Solution1 ();
        lls=s1.accountsMerge (lls);
        System.out.println (lls);
    }
}

class Solution1 {
    List<List<String>> res = new ArrayList ();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) {
            return null;
        }
        //前面是email，后面是name
        Map<String, String> getNameByEmail = new HashMap<> ();

        Map<String, List<String>> eamilToEmail = new HashMap<> ();
        for (List<String> ls : accounts) {
            String name = "";
            for (String email : ls) {
                //这里这个name主要是因为ls,没有办法用下标取出来
                //所以就这么判断一下
                if (name == "") {
                    name = email;
                    continue;
                }
                eamilToEmail.computeIfAbsent (email, c -> new ArrayList<String> ()).add (ls.get (1));
                eamilToEmail.computeIfAbsent (ls.get (1), c -> new ArrayList<String> ()).add (email);
                getNameByEmail.put (email, name);
            }
        }
        for (String email : eamilToEmail.keySet ()) {
            for (String lsStr : eamilToEmail.get (email)) {
                System.out.println (email + "---" + lsStr);
            }
        }
        //bfs中用到的队列
        LinkedList<List<String>> emailLists = new LinkedList<> ();

        //树集用来筛选已经遍历过的节点
        TreeSet<String> emailSet = new TreeSet<> ();

        for (String email : eamilToEmail.keySet ()) {
            if (emailSet.contains (email))
                continue;
            emailLists.add (eamilToEmail.get (email));
            emailSet.add (email);
            List<String> ls = new ArrayList<> ();
            ls.add (email);
            while (!emailLists.isEmpty ()) {
                List<String> temp = emailLists.poll ();
                for (String e : temp) {
                    if (!emailSet.contains (e)) {
                        emailSet.add (e);
                        ls.add (e);
                        //这里我一不小心写成了get(email);
                        //都是泪啊；
                        emailLists.add (eamilToEmail.get (e));
                    }
                }
            }
            Collections.sort (ls);
            ls.add (0, getNameByEmail.get (email));
            res.add (ls);
        }
        return res;
    }
}
