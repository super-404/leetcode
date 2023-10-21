package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: Given a sorted integer array arr, two integers k and x,
 * <p>
 * return the k closest integers to x in the array.
 * <p>
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * @author: 饶嘉伟
 * @create: 2023-10-19 09:15
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Find_K_Closest_Elements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length - 1;

        //while循环目的是去掉距离x较远的哪一个
        //如果 j 到 i 之间的元素个数不大于k,则没有必要循环
        while (j - i + 1 > k) {

            //如果 j 离得更远,把他排除掉
            if (Math.abs (arr[i] - x) >
                    Math.abs (arr[j] - x)) {
                i++;
            } else {
                //把 i 排除掉
                j--;
            }
        }
        //剩下的k个就是需要的
        List<Integer> resultList = IntStream.range (i, j)
                .mapToObj (index -> arr[index])
                .collect (Collectors.toCollection (ArrayList::new));
        return resultList;
    }
}
