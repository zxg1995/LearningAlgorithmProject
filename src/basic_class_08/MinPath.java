package basic_class_08;

/**
 * Created by Paul Z on 2020/2/23
 *
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 */
public class MinPath {

    //使用暴力递归的方法
    private static int minPath1(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        return process1(matrix, 0, 0);
    }

    private static int process1(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            return matrix[i][j];
        if (i == matrix.length - 1)
            return process1(matrix, i, j + 1) + matrix[i][j];
        if (j == matrix[0].length - 1)
            return process1(matrix, i + 1, j) + matrix[i][j];
        return matrix[i][j] + Math.min(process1(matrix, i + 1, j), process1(matrix, i, j + 1));
    }

    private static int minPath2(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = matrix[row-1][col-1];
        for (int i = row - 2; i >= 0; i--)
            dp[i][col-1] = dp[i+1][col-1] + matrix[i][col-1];
        for (int i = col - 2; i >= 0; i--)
            dp[row-1][i] = dp[row-1][i+1] + matrix[row-1][i];
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--)
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] m = {
                { 1, 3, 5, 9 },
                { 8, 1, 3, 4 },
                { 5, 0, 6, 1 },
                { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
