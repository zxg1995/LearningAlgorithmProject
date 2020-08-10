package basic_class_08;

/**
 * Created by Paul Z on 2020/2/23
 *
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
 * 数字，能不能累加得到aim，返回true或者false(假设均为正数)
 */
public class WhetherGetAim {

    private static boolean canGetAim1(int[] a, int aim){
        return process1(a, 0, 0, aim);
    }

    private static boolean process1(int[] a, int i, int sum, int aim) {
        if (sum == aim)
            return true;
        if (i == a.length)
            return false;
        return process1(a, i+1, sum, aim) || process1(a, i+1, sum+a[i], aim);
    }

    private static boolean canGetAim2(int[] a, int aim){
        boolean[][] dp = new boolean[a.length+1][aim+1];
        for (int i = 0; i < dp.length; i++)
            dp[i][aim] = true;
        for (int i = a.length-1; i >= 0; i--){
            for (int j = aim-1; j >= 0; j--){
                if (j + a[i] <= aim)
                    dp[i][j] = dp[i+1][j] || dp[i+1][j + a[i]];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 9};
        int aim = 3;
        System.out.println(canGetAim1(arr, aim));
        System.out.println(canGetAim2(arr, aim));
    }
}
