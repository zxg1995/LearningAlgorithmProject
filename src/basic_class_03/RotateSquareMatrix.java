package basic_class_03;

import java.util.Arrays;

/**
 * Created by Paul Z on 2019/12/23
 */
public class RotateSquareMatrix {

    private static void rotateEdge(int[][] m, int aR, int aC, int bR, int bC){
        int len = bC - aC;
        for (int i = 0; i < len; i++){
            int tmp = m[aR][aC+i];
            m[aR][aC+i] = m[bR-i][aC];
            m[bR-i][aC] = m[bR][bC-i];
            m[bR][bC-i] = m[aR+i][bC];
            m[aR+i][bC] = tmp;
        }
    }

    private static void rotateSquareMatrix(int[][] m){
        int ar = 0;
        int ac = 0;
        int br = m.length - 1;
        int bc = m[0].length - 1;
        while (ac <= bc)
            rotateEdge(m, ar++, ac++, br--, bc--);
    }

    private static void printMatrix(int[][] m){
        for (int i = 0; i < m.length; i++)
            System.out.println(Arrays.toString(m[i]));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotateSquareMatrix(matrix);
        printMatrix(matrix);
    }
}
