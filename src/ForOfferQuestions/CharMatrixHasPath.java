package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/3/6
 */
public class CharMatrixHasPath {

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix == null || matrix.length < 1 || str == null || str.length < 1)
            return false;
        char[][] m = new char[rows][cols];
        for (int i = 0; i < rows; i++){
            System.arraycopy(matrix, i * cols, m[i], 0, cols);
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (judge(m, i, j, str, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean judge(char[][] matrix, int i, int j, char[] str, int k) {
        if (k == str.length)
            return true;
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return false;
        if (matrix[i][j] != str[k])
            return false;
        char tmp = matrix[i][j];
        matrix[i][j] = 0;
        boolean total = judge(matrix, i - 1, j, str, k + 1) || judge(matrix, i + 1, j, str, k + 1)
                || judge(matrix, i, j - 1, str, k + 1) || judge(matrix, i, j + 1, str, k + 1);
        matrix[i][j] = tmp;
        return total;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};
        char[] m = null;
        //char[] str = {'b','c','c','e','d'};
        char[] str = {'a','b','c','b'};
        System.out.println(hasPath(m, matrix.length, matrix[0].length, str));
    }
}
