package DataStructure.动态规划.day_2020_7_21;

/**
 * @program: leetcode
 * @description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @author: 饶嘉伟
 * @create: 2020-07-10 17:06
 **/
/*示例:

        输入: 3
        输出: 5
        解释:
        给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

        1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
        2     1         2                 3

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/unique-binary-search-trees
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class 不同的二叉搜索树96 {
    public static void main(String[] args) {
        System.out.println (new Solution ().numTrees (20));
    }
}

//递归的解法
class Solution {
    //这里的这个记忆化数组很重要
    int memory[][];

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        memory = new int[100][100];
        return getAnswer (1, n);
    }

    public int getAnswer(int start, int end) {
        int res = 0;
        //因为对于相同的输入一定有相同的输出
        //因此我们重复利用之前已经计算好的值
        if (memory[start][end] != 0) {
            return memory[start][end];
        }
        if (start > end || start == end)
            return 1;
        for (int i = start; i <= end; i++) {
            //对于1--n的每个值都可能成为根节点，因此需要每个都遍历一遍
            res += getAnswer (start, i - 1) * getAnswer (i + 1, end);
        }
        //将计算好的值保存起来
        return memory[start][end] = res;
    }
}

//动态规划的解法
/*      那n=3时呢？
        我们来看[1,2,3]
        如果提起1作为树根，左边有f(0)种情况，右边f(2)种情况，左右搭配一共有f(0)*f(2)种情况
        如果提起2作为树根，左边有f(1)种情况，右边f(1)种情况，左右搭配一共有f(1)*f(1)种情况
        如果提起3作为树根，左边有f(2)种情况，右边f(0)种情况，左右搭配一共有f(2)*f(0)种情况
        容易得知f(3) = f(0)*f(2) + f(1)*f(1) + f(2)*f(0)
         
        同理,
        f(4) = f(0)*f(3) + f(1)*f(2) + f(2)*f(1) + f(3)*f(0)
        f(5) = f(0)*f(4) + f(1)*f(3) + f(2)*f(2) + f(3)*f(1) + f(4)*f(0)
        ......
        发现了咩？
        对于每一个n，其式子都是有规律的
        每一项两个f()的数字加起来都等于n-1
         
        既然我们已知f(0) = 1, f(1) = 1
        那么就可以先算出f(2),再算出f(3),然后f(4)也可以算了...
        计算过程中可以把这些存起来，方便随时使用
        最后得到的f(n)就是我们需要的解了

        作者：xiao-yan-gou
        链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/er-cha-sou-suo-shu-fu-xi-li-zi-jie-shi-si-lu-by-xi/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
