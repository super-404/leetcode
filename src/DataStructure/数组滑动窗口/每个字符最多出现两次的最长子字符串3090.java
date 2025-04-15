package DataStructure.数组滑动窗口;

import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-28 08:40
 **/
public class 每个字符最多出现两次的最长子字符串3090 {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> hci = new HashMap<> ();
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while (right < s.length ()) {
            char c = s.charAt (right);
            hci.computeIfPresent (c, (k, v) -> v + 1);
            hci.putIfAbsent (c, 1);

            while (hci.get (c) > 2) {
                char cl = s.charAt (left);
                hci.computeIfPresent (cl, (k, v) -> {
                    return v - 1;
                });
                if (hci.get (cl) == 0) {
                    hci.remove (cl);
                }
                left++;
            }
            max = Math.max (max, right - left + 1);
            right++;
        }
        return max;
    }

    @Test
    public void test() {
        String s = "eebadadbfa";
        int nums[] = {2, 3, 2, 1};
        int freq[] = {3, 2, -3, 1};
        // mostFrequentIDs (nums,freq);
        System.out.println (10000000 / (8 * 1024));
    }

    //    public long[] mostFrequentIDs(int[] nums, int[] freq) {
//        HashMap<Integer,Integer> hii =new HashMap();
//        PriorityQueue<int[]> pqi = new PriorityQueue<> ((o1, o2) -> o1[1]-o1[2]);
//
//        long [] res  = new long[nums.length];
//        //简易哈希
//        long  [] hash = new long[100001];
//        TreeMap<Long, Integer> m = new TreeMap<>();
//
//
//        for(int i = 0;i<freq.length;i++){
//            final int count = freq[i];
//            int [] temp =  new int[2];
//            temp[0] = nums[i];
//            hash[nums[i]]+=count;
//            hii.computeIfPresent (nums[i],(k,v)->v+count);
//            hii.computeIfAbsent (nums[i],(a)->count);
//            pqi.add (hash[nums[i]]);
//
//            Set<Map.Entry<Integer, Integer>> entries = hii.entrySet ();
//
//            Map.Entry<String, String> stringStringEntry = entries;
//            res[i] = pqi.peek ();
//        }
//        return res;
//    }
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer, Long> cnt = new HashMap<> ();
        TreeMap<Long, Integer> m = new TreeMap<> ();
        int n = nums.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (cnt.containsKey (x) && m.containsKey (cnt.get (x)) && m.merge (cnt.get (x), -1, Integer::sum) == 0) { // --m[cnt[x]] == 0
                m.remove (cnt.get (x));
            }
            long c = cnt.merge (x, (long) freq[i], Long::sum); // cnt[x] += freq[i]
            m.merge (c, 1, Integer::sum); // ++m[cnt[x]]
            ans[i] = m.lastKey ();
        }
        return ans;
    }
}
