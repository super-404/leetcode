package 每日一题;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-08-26 08:49
 **/
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class 员工的重要性690 {
    Map<Integer, Employee> map = new HashMap<> ();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put (e.id, e);
        }
        return 0;
    }

    public int dfs(int id) {
        Employee e = map.get (id);
        int total = e.importance;
        //加上下属的
        for (int i : e.subordinates) {
            total += dfs (i);
        }
        return total;
    }

    public int bfs(int id) {
        Employee e = map.get (id);
        Queue<Employee> qe = new ArrayDeque<> ();
        qe.add (e);
        int total = 0;
        while (!qe.isEmpty ()) {
            Employee ee = qe.poll ();
            total += ee.importance;
            for (int i : ee.subordinates) {
                Employee em = map.get (i);
                qe.add (em);
            }
        }
        return total;
    }
}
