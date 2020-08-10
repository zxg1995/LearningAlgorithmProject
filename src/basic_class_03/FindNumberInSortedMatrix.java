package basic_class_03;

/**
 * Created by Paul Z on 2019/12/24
 */
public class FindNumberInSortedMatrix {

    private static boolean findNumber(int[][] m, int key){
        int xR = 0;
        int xC = m[0].length - 1;
        while (xR < m.length && xC > -1){
            if (m[xR][xC] == key)
                return true;
            else if (m[xR][xC] > key)
                xC--;
            else
                xR++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        System.out.println(findNumber(matrix, 233));
        System.out.println(findNumber(matrix, 59));
    }
}
