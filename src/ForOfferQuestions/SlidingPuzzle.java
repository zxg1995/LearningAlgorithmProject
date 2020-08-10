package ForOfferQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Paul Z on 2020/7/28
 *
 * 题目：
 *      LeetCode 773. 滑动谜题
 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        int[][] b = new int[][]{{3,2,4}, {1,5,0}};
        System.out.println(slidingPuzzle(b));
    }

    public static int slidingPuzzle(int[][] board) {
        Queue<int[][]> state = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        HashSet<int[][]> set = new HashSet<>();
        state.add(board);
        count.add(0);
        while (!state.isEmpty() && !count.isEmpty()){
            int[][] tmp = state.poll();
            int num = count.poll();
            int[] result = getState(tmp);
            if (result[0] == 0){
                return num;
            }
            else {
                if (result[1]-1 >= 0){
                    int[][] a = swap(tmp, result[1], result[2], result[1]-1, result[2]);
                    if (!set.contains(a)){
                        state.add(a);
                        count.add(num+1);
                        set.add(a);
                    }
                }
                if (result[1]+1 < 2){
                    int[][] a = swap(tmp, result[1], result[2], result[1]+1, result[2]);
                    if (!set.contains(a)){
                        state.add(a);
                        count.add(num+1);
                        set.add(a);
                    }
                }
                if (result[2]-1 >= 0){
                    int[][] a = swap(tmp, result[1], result[2], result[1], result[2]-1);
                    if (!set.contains(a)){
                        state.add(a);
                        count.add(num+1);
                        set.add(a);
                    }
                }
                if (result[2]+1 < 3){
                    int[][] a = swap(tmp, result[1], result[2], result[1], result[2]+1);
                    if (!set.contains(a)){
                        state.add(a);
                        count.add(num+1);
                        set.add(a);
                    }
                }
            }
        }
        return -1;
    }

    private static int[][] swap(int[][] board, int x, int y, int x1, int y1) {
        int[][] a = new int[2][3];
        for (int i = 0; i < 2; i++) {
            System.arraycopy(board[i], 0, a[i], 0, 3);
        }
        int t = a[x][y];
        a[x][y] = a[x1][y1];
        a[x1][y1] = t;
        return a;
    }

    private static int[] getState(int[][] board) {
        int sum = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                switch (board[i][j]){
                    case 1 :
                        sum += Math.abs(i-0) + Math.abs(j-0);
                        break;
                    case 2 :
                        sum += Math.abs(i-0) + Math.abs(j-1);
                        break;
                    case 3 :
                        sum += Math.abs(i-0) + Math.abs(j-2);
                        break;
                    case 4 :
                        sum += Math.abs(i-1) + Math.abs(j-0);
                        break;
                    case 5 :
                        sum += (Math.abs(i-1) + Math.abs(j-1));
                        break;
                    default:
                        x = i;
                        y = j;
                        break;
                }
            }
        }
        return new int[]{sum, x, y};
    }

}
