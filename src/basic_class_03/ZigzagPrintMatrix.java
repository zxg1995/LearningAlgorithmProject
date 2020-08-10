package basic_class_03;

/**
 * Created by Paul Z on 2019/12/23
 */
public class ZigzagPrintMatrix {

    private static void printDiagonal(int[][] m, int aR, int aC, int bR, int bC, boolean downToUp){
        if (downToUp){
            while (aC <= bC)
                System.out.print(m[aR--][aC++] + " ");
        }
        else {
            while (bR <= aR)
                System.out.print(m[bR++][bC--] + " ");
        }
    }

    private static void zigzagPrintMatrix(int[][] m){
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        boolean downToUp = true;
        while (ac <= m[0].length-1){
            printDiagonal(m, ar, ac, br, bc, downToUp);
            ac = ar == m.length-1 ? ac+1 : ac;
            ar = ar == m.length-1 ? ar : ar+1;
            br = bc == m[0].length-1 ? br+1 : br;
            bc = bc == m[0].length-1 ? bc : bc+1;
            downToUp = !downToUp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }};
        zigzagPrintMatrix(matrix);
    }
}
