package DataStructure.图.test;

import DataStructure.图.DepthFirstSearch;
import DataStructure.图.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-11-28 18:30
 **/
public class Test {
    @org.junit.Test
    public void testGraph1() throws FileNotFoundException {
        String path = "/graph/tinyG.txt";
        Scanner in = new Scanner (new File (Test.class.getResource (path).getFile ()));
        Graph g = new Graph (in);
        System.out.println (g.toString ());
        DepthFirstSearch dfs = new DepthFirstSearch (g);
        dfs.printDfs ();
    }
}
