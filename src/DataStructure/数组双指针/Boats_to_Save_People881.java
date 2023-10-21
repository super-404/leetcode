package DataStructure.数组双指针;

/**
 * @program: leetcode
 * @description: You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 * @author: 饶嘉伟
 * @create: 2023-10-12 13:19
 **/

/*
*
    Example 1:

    Input: people = [1,2], limit = 3
    Output: 1
    Explanation: 1 boat (1, 2)
*
* */
public class Boats_to_Save_People881 {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length;
        int res = 0;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                res++;
            } else {
                res++;
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        float i = 85 * 3 + 83 * 2 + 68 + 87 + 75 * 3 + 80 * 3 + 78 + 87 * 3 + 90 * 3 + 2 * 85 + 69 + 95 * 2 + 84 * 2;
        System.out.println (i / 27);
        System.out.println (30 * (1 / (1 + 0.5 + 0.25 + 0.125)));

    }
}
