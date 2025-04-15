package DataStructure.散列表;

//import edu.princeton.cs.algs4.CollisionSystem;
//import edu.princeton.cs.algs4.Particle;
//import edu.princeton.cs.algs4.StdDraw;

/**
 * @program: leetcode
 * @description: 测试类
 * @author: 饶嘉伟
 * @create: 2020-10-25 20:51
 **/
public class Test {
    @org.junit.Test
    public void TestBaseFunction() {

        SeparateChainingHashST<String, String> sss = new SeparateChainingHashST<> ();
        String s = " ";
        s.split (" ");
        sss.put ("DataStructure.a", "DataStructure.a");
        sss.put ("DataStructure.b", "DataStructure.b");
        sss.put ("c", "c");
        sss.put ("d", "d");
        sss.put ("e", "e");
        sss.put ("f", "f");
        sss.put ("g", "g");
        sss.put ("h", "h");
        sss.put ("i", "i");
        sss.put ("j", "j");
        sss.put ("k", "k");
        sss.put ("l", "l");
        sss.print ();
        sss.delete ("DataStructure.a");
        sss.delete ("c");
        System.out.println (sss.get ("c"));
        System.out.println (sss.get ("DataStructure.a"));
    }

    @org.junit.Test
    public void collision() {
//        int n = 20;  // number of particles (default 20)
//
//        // enable double buffering to support animations
//        StdDraw.enableDoubleBuffering ();
//
//        // create the n particles
//        Particle[] particles = new Particle[n];
//        for (int i = 0; i < n; i++) {
//            particles[i] = new Particle ();
//        }
//
//        // simulate the system
//        CollisionSystem system = new CollisionSystem (particles);
//        system.simulate (Double.POSITIVE_INFINITY);
    }
}
