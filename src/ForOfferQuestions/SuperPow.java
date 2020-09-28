package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/8/11
 * 题目：
 * LeetCode 372 超级次方
 *
 *  取模运算的规律：
 *  (a * b) % p = (a % p) * (a % p) % p;
 *  (a + b) % p = [(a % p) + (a % p)] % p;
 */
public class SuperPow {

    /**
     * 处理数组的规律：
     *  假设b={1,2,3,4}
     *  superPow(a,{1,2,3,4}) = a^4 * (superPow(a,{1,2,3}))^10
     */
    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0)
            return 0;
        //数组的处理可以借助动态规划
        int[] dp = new int[b.length];
        dp[0] = myPow(a, b[0]);
        for (int i = 1; i < b.length; i++){
            int x = myPow(a, b[i]);
            int y = myPow(dp[i-1], 10);
            dp[i] = x * y % 1337;
        }
        return dp[b.length-1];
    }

    /**
     * 处理大数情况下的指数运算（带取模的）
     * 快速求幂运算：
     *      pow(a,b) = a * pow(a,b-1) //当b为奇数
     *      pow(a,b) = [pow(a,b/2)]^2 //当b为偶数
     */
    private int myPow(int a, int i) {
        if (i == 0)
            return 1;
        if ((i & 1) == 0){
            int tmp = myPow(a, i/2);
            return tmp * tmp % 1337;
        }
        else {
            int tmp = a % 1337 * myPow(a, i-1);
            return tmp % 1337;
        }
    }

    public static void main(String[] args) {
        SuperPow sp = new SuperPow();
        int a = 2;
        int[] b = {1,0};
        System.out.println(sp.superPow(a, b));
    }
}
