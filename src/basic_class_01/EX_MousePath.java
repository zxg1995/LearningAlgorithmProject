package basic_class_01;

import java.util.Stack;

/**
 * Created by Paul Z on 2019/12/9
 * 问题描述：
 * 在迷宫某处放一大块奶酪，把一只老鼠Mooshak放入迷宫。
 * 迷宫以二维数组表示，0表示墙，1表示Mooshak可以移动的路径，9表示奶酪所在位置。Mooshak从迷宫左上角(0，0)开始移动。
 * 编写一个MazePath类的方法isPath，判断Mooshak是否能到达奶酪所在地。如果Mooshak和奶酪之间存在一条路径，isPath
 * 方法返回true，否则返回false，Mooshak不能离开迷宫或翻墙。
 */
public class EX_MousePath {

    private static boolean isPath(int[][] g, int rows, int columns){
        int x = 0;
        int y = 0;
        if (g == null || g[x][y] == 0)
            return false;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(x, y));
        while (!stack.isEmpty()){
            if (g[x][y] == 9)
                return true;
            else
                g[x][y] = -1;  //走过的路，标识一下

            if (y > 0 && g[x][y - 1] != -1 && g[x][y - 1] != 0){
                y -= 1;
                stack.push(new Point(x, y));
                continue;
            }
            if (y < columns-1 && g[x][y + 1] != -1 && g[x][y + 1] != 0){
                y += 1;
                stack.push(new Point(x, y));
                continue;
            }
            if (x > 0 && g[x - 1][y] != -1 && g[x - 1][y] != 1){
                x -= 1;
                stack.push(new Point(x, y));
                continue;
            }
            if (x < rows-1 && g[x + 1][y] != -1 && g[x + 1][y] != 0){
                x += 1;
                stack.push(new Point(x, y));
                continue;
            }
            Point pos = stack.pop();
            x = pos.i;
            y = pos.j;
        }
        return false;
    }

    static class Point {
        private int i;
        private int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "(" + i +", " + j +")";
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                       {{1, 1, 1, 1, 1, 0, 0, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 9},
                        {1, 1, 1, 0, 1, 1, 0, 1},
                        {1, 0, 1, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1}};
        System.out.println(isPath(grid, grid.length, grid[0].length));
    }
}
