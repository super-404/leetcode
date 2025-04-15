import com.sun.javafx.geom.Edge;
import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-24 19:16
 **/
public class tongchneg {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner (System.in);
//        int n = in.nextInt();
//        int  m = in.nextInt ();
////        // 注意 hasNext 和 hasNextLine 的区别
////        while (in.hasNextInt()) { // 注意 while 处理多个 case
////            int a = in.nextInt();
////            int b = in.nextInt();
////            System.out.println(a + b);
////        }
//        long []odd = new long[n+1];
//        long [] even = new long[n+1];
//        long mod = 1_000_000_007;
//        if(n%2==1){
//            odd[1] =(m+1)/2;
//            even[1] = m/2;
//        }else{
//            even[1] =(m+1)/2;
//            odd[1] = m/2;
//        }
//        for(int i = 2;i<n;i++){
//            odd[i] = (even[i-1]*((m+1)/2))%mod;
//            even[i] = (odd[i-1]*(m/2))%mod;
//        }
//        long res = n%2==1?odd[n]:even[n];
//        System.out.println (res);
//    }
//    registration complete
//    illegal length
//    acount existed
//    illegal charactor
    public static void solution() {
        Scanner in = new Scanner (System.in);
        int t = in.nextInt ();
        in.nextLine ();
        String names[] = new String[t];
        int k = 0;
        while (k < t) {
            names[k] = in.nextLine ();
            k++;
        }
        System.out.println (Arrays.toString (names));
        Set<String> reg = new HashSet<> ();
        for (int i = 0; i < t; i++) {
            String username = names[i];
            // System.out.println (username);
            boolean flag = false;
            if (username.length () < 6 || username.length () > 12) {
                System.out.println ("illegal length");
                //flag = true;
                continue;
            }
            if (flag) {
                continue;
            }
            for (int j = 0; j < username.length (); j++) {
                if (!Character.isLetter (username.charAt (j))) {
                    System.out.println ("illegal charactor");
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            if (reg.contains (username)) {
                System.out.println ("acount existed");
            } else {
                reg.add (username);
                System.out.println ("registration complete");
            }
        }

    }

    public static void main(String[] args) {
        solution1 ();
    }

    @Test
    public void test() {
        solution ();
    }

    public static void solution1() {
        Scanner in = new Scanner (System.in);
        String str = in.nextLine ();
        Set<Character> sc = new HashSet<> ();
        LinkedHashMap<Character, List<Integer>> hcb = new LinkedHashMap<> ();
        //HashMap
        for (int i = 0; i < str.length (); i++) {
            char c = str.charAt (i);
            if (hcb.containsKey (c)) {
                List l = hcb.get (c);
                l.add (i + 1);
                hcb.put (c, l);
            } else {
                List<Integer> li = new ArrayList<> ();
                li.add (i + 1);
                hcb.put (c, li);
            }
        }
        String res = "";
        for (Character c : hcb.keySet ()) {
            List<Integer> l = hcb.get (c);
            if (l.size () > 1) {
                for (Integer i : l) {
                    res += c + ", " + i + ";";
                }
            }
        }
//        List<Integer>
//        for(int i= 0;i<str.length ();i++){
//            char c  = str.charAt (i);
//            if(hcb.get (c)){
//                res+=c+","+(i+1)+";";
//            }
//        }
        System.out.println (res.substring (0, res.length () - 1));
    }

    public static void solution2() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int k = in.nextInt ();
        String str = in.nextLine ();
        int lowCase = 0;
        int upperCase = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt (i);
            if (Character.isUpperCase (c)) {
                upperCase++;
            }
        }
        System.out.println (cc (n, k, upperCase, lowCase));
//        int res =0;
//        if(n>1){
//            res+=upperCase;
//        }
//        lowCase = n- upperCase;
//
//        if(lowCase>=k){
//
//            res+=k;
//        }else{
//            if((k-lowCase)%2==0){
//                res+=n;
//            }else{
//                res+=n-1;
//            }
//        }
//        System.out.println (res);

    }

    public static int cc(int n, int k, int upperCount, int lowerCount) {
        int ofl = Math.min (k, lowerCount);
        int newu = upperCount + ofl;
        int re = k - ofl;
        if (re > 0) {
            int ofu = re / 2;
            newu -= ofu;
        }
        return Math.min (n, newu);
    }

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void solution3() {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int k = sc.nextInt ();
        List<List<Edge>> g = new ArrayList<> ();
        for (int i = 0; i <= n; i++) {
            g.add (new ArrayList<> ());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt ();
            int v = sc.nextInt ();
            long w = sc.nextInt ();
            g.get (u).add (new Edge (v, w));
            g.get (v).add (new Edge (u, w));
        }
        long[] od = dk (g, 1);
        for (int i = 0; i < k; i++) {
            int p = sc.nextInt ();
            long s = sc.nextInt ();
            g.get (1).add (new Edge (p, s));
            g.get (p).add (new Edge (1, s));
        }
        long[] newd = dk (g, 1);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (od[i] == newd[i]) {
                count++;
            }
        }
        System.out.println (count - 1);
    }


    private static long[] dk(List<List<Edge>> g, int start) {
        int n = g.size ();
        long[] dist = new long[n];
        Arrays.fill (dist, Long.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<> (Comparator.comparingLong (e -> e.weight));
        pq.offer (new Edge (start, 0));
        while (!pq.isEmpty ()) {
            Edge cur = pq.poll ();
            int u = cur.to;
            long d = cur.weight;
            if (d > dist[u]) {
                continue;
            }
            for (Edge e : g.get (u)) {
                int v = e.to;
                long w = e.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer (new Edge (v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void solution22() {

    }

}
