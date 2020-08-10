package basic_class_05;

/**
 * Created by Paul Z on 2020/2/14
 */
public class IslandsProblem {

    private static int countIslands(int[][] matrix){
        int count = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 1){
                    infect(matrix, i, j);
                    count ++;
                }
            }
        return count;
    }

    private static void infect(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1)
            return;
        matrix[i][j] = 2;
        infect(matrix, i + 1, j);
        infect(matrix, i - 1, j);
        infect(matrix, i, j + 1);
        infect(matrix, i, j - 1);
    }


    public static void main(String[] args) {
        int[][] m1 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
        System.out.println(countIslands(m1));

        int[][] m2 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
        System.out.println(countIslands(m2));
    }
}
