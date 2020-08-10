package ForOfferQuestions;

import java.util.ArrayList;

/**
 * Created by Paul Z on 2020/2/12
 */
public class RotatePrintMatrix2 {

    private static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> al = new ArrayList<>();
        int lr = 0;
        int lc = 0;
        int rr = matrix.length - 1;
        int rc = matrix[0].length - 1;
        while (lr <= rr && lc <= rc){
            rotatePrintMatrix(matrix, lr++, lc++, rr--, rc--, al);
        }
        return al;
    }

    private static void rotatePrintMatrix(int[][] matrix, int lr, int lc, int rr, int rc, ArrayList<Integer> al) {
        if (lr == rr && lc == rc)
            al.add(matrix[lr][lc]);
        else if (lr == rr){
            while (lc <= rc)
                al.add(matrix[lr][lc++]);
        } else if (lc == rc){
            while (lr <= rr)
                al.add(matrix[lr++][lc]);
        } else {
            for (int i = lc; i < rc; i++)
                al.add(matrix[lr][i]);
            for (int i = lr; i < rr; i++)
                al.add(matrix[i][rc]);
            for (int i = rc; i > lc; i--)
                al.add(matrix[rr][i]);
            for (int i = rr; i > lr; i--)
                al.add(matrix[i][lc]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(printMatrix(matrix));
    }
}
