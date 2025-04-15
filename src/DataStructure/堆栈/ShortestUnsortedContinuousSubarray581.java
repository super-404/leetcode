package DataStructure.堆栈;


import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-12-20 20:57
 **/
public class ShortestUnsortedContinuousSubarray581 {

    class Solution {

        public int findUnsortedSubarray(int[] nums) {
            Deque<Integer> di = new LinkedList<> ();
            int start = -1;
            int end = -1;
            //计算最右边不满足条件的值
            for (int i = 0; i < nums.length; i++) {
                if (di.isEmpty ()) {
                    di.push (i);
                } else {
                    if (nums[di.peek ()] > nums[i]) {
                        int topid = di.pop ();
                        di.push (i);
                        di.push (topid);
                        end = i;
                    } else {
                        di.push (i);
                    }
                }
            }
            //计算 最左边的值
            for (int i = nums.length - 1; i >= 0; i--) {
                if (di.isEmpty ()) {
                    di.push (i);
                } else {
                    if (nums[di.peek ()] < nums[i]) {
                        int topid = di.pop ();
                        di.push (i);
                        di.push (topid);
                        start = i;
                    } else {
                        di.push (i);
                    }
                }
            }
            return start == -1 ? 0 : end - start + 1;
        }
    }

    @Test
    public void test() {
        int a[] = {2, 3, 3, 2, 4};
        int unsortedSubarray = new Solution ().findUnsortedSubarray (a);
        System.out.println (unsortedSubarray);
    }

    @Test
    public void testTreeMap() {
        TreeMap<Character, Integer> tci = new TreeMap<Character, Integer> ();
        HashMap<String, Integer> map = new HashMap<> ();
        map.put ("赵四", 23);
        map.put ("刘能", 21);
        map.put ("广坤", 25);
        map.put ("老七", 18);
        System.out.println (map);
        // tci = (TreeMap)sortMap(map);
        System.out.println (tci);


    }
//    public static Map<Character, Integer> sortMap(Map<String, Integer> map) {
//        //利用Map的entrySet方法，转化为list进行排序
//        List<Map.Entry<Character, Integer>> entryList = new ArrayList<Map.Entry<Character, Integer>>();
//
//        entryList.contains (map.entrySet());
//
//        //利用Collections的sort方法对list排序
//        Collections.sort(entryList,(o1,o2)-> {return o1.getValue() - o2.getValue();});
//        //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
////        //LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
////        for (Map.Entry<Character,Integer> e : entryList
////        ) {
////            linkedHashMap.put(e.getKey(),e.getValue());
////        }
////        return linkedHashMap;
//
//    }

}
