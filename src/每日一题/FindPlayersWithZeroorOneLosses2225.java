package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-05-22 09:36
 **/
public class FindPlayersWithZeroorOneLosses2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> winner = new HashMap<> ();
        HashMap<Integer, Integer> loser = new HashMap<> ();
        for (int i = 0; i < matches.length; i++) {
            winner.computeIfPresent (matches[i][0], (k, v) -> {
                return v + 1;
            });
            winner.computeIfAbsent (matches[i][0], (k) -> {
                return 1;
            });
            loser.computeIfPresent (matches[i][1], (k, v) -> {
                return v + 1;
            });
            loser.computeIfAbsent (matches[i][1], (k) -> {
                return 1;
            });
        }
        List<List<Integer>> answer = new ArrayList<> ();

        List<Integer> res = new ArrayList<> ();
        winner.forEach ((k, v) -> {
            if (!loser.containsKey (k)) {
                res.add (k);
            }
        });
        res.sort ((a, b) -> {
            return a - b;
        });
        answer.add (res);
        List<Integer> res1 = new ArrayList<> ();
        loser.forEach ((k, v) -> {
            if (v == 1) {
                res1.add (k);
            }
        });
        res1.sort ((a, b) -> {
            return a - b;
        });
        answer.add (res1);
        return answer;
    }
}
