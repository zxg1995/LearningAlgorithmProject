package basic_class_03;

/**
 * Created by Paul Z on 2019/12/19
 */
public class RotatePrintMatrix {

    private static void printEdge(int[][] m, int aR, int aC, int bR, int bC){
        if (aR == bR && aC == bC)
            System.out.println(m[aR][aC]);
        else if (aR == bR) {
            while (aC <= bC)
                System.out.println(m[aR][aC++]);
        }
        else if (aC == bC){
            while (aR <= bR)
                System.out.println(m[aR++][aC]);
        }
        else {
            for (int i = aC; i < bC; i++)
                System.out.println(m[aR][i]);
            for (int i = aR; i < bR; i++)
                System.out.println(m[i][bC]);
            for (int i = bC; i > aC; i--)
                System.out.println(m[bR][i]);
            for (int i = bR; i > aR; i--)
                System.out.println(m[i][aC]);
        }
    }

    private static void rotatePrintMatrix(int[][] m){
        int ar = 0;
        int ac = 0;
        int br = m.length - 1;
        int bc = m[0].length - 1;
        while (ar <= br && ac <= bc)
            printEdge(m, ar++, ac++, br--, bc--);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotatePrintMatrix(matrix);
    }
}
