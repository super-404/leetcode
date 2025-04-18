package bagu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-13 09:13
 **/
public class CompareTo {
    @Test
    public void testCompareTo() {
        ArrayList<Integer> arrayList = new ArrayList<Integer> ();
        arrayList.add (-1);
        arrayList.add (3);
        arrayList.add (3);
        arrayList.add (-5);
        arrayList.add (7);
        arrayList.add (4);
        arrayList.add (-9);
        arrayList.add (-7);
        System.out.println ("原始数组:");
        System.out.println (arrayList);
// void reverse(List list)：反转
        Collections.reverse (arrayList);
        System.out.println ("Collections.reverse(arrayList):");
        System.out.println (arrayList);

// void sort(List list),按自然排序的升序排序
        Collections.sort (arrayList);
        System.out.println ("Collections.sort(arrayList):");
        System.out.println (arrayList);
// 定制排序的用法
        Collections.sort (arrayList, new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo (o1);
            }
        });
        System.out.println ("定制排序后：");
        System.out.println (arrayList);
        LinkedHashSet lhs = new LinkedHashSet ();

//        lhs.equals ()

    }
}

