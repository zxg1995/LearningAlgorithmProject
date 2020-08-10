package ForOfferQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Paul Z on 2020/3/5
 */
public class RobotMovingProblem {

    static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int movingCount(int threshold, int rows, int cols){
        if (rows < 1 || cols < 1 || threshold < 0)
            return 0;
        int sum = 0;
        int[][] map = new int[rows][cols];
        Queue<Position> queue = new LinkedList<>();
        if (judge(0, 0, threshold)) {
            queue.add(new Position(0, 0));
            map[0][0] = 1;
        }
        while (!queue.isEmpty()){
            Position p = queue.poll();
            sum ++;
            if (p.x - 1 >= 0 && map[p.x - 1][p.y] != 1 && judge(p.x - 1, p.y, threshold)) {
                queue.add(new Position(p.x - 1, p.y));
                map[p.x - 1][p.y] = 1;
            }
            if (p.x + 1 < rows && map[p.x + 1][p.y] != 1 && judge(p.x + 1, p.y, threshold)) {
                queue.add(new Position(p.x + 1, p.y));
                map[p.x + 1][p.y] = 1;
            }
            if (p.y - 1 >= 0 && map[p.x][p.y - 1] != 1 && judge(p.x, p.y - 1, threshold)) {
                queue.add(new Position(p.x, p.y - 1));
                map[p.x][p.y - 1] = 1;
            }
            if (p.y + 1 < cols && map[p.x][p.y + 1] != 1 && judge(p.x, p.y + 1, threshold)) {
                queue.add(new Position(p.x, p.y + 1));
                map[p.x][p.y + 1] = 1;
            }
        }
        return sum;
    }

    private static boolean judge(int i, int j, int threshold) {
        int sum = 0;
        String s = String.valueOf(i) + j;
        char[] cs = s.toCharArray();
        for (char c : cs)
            sum += Integer.parseInt(String.valueOf(c));
        return sum <= threshold;
    }

    public static void main(String[] args) {
        int k = 5;
        int r = 12;
        int c = 12;
        System.out.println(movingCount(k, r, c));
    }
}
