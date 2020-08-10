package basic_class_08;

/**
 * Created by Paul Z on 2020/2/23
 */
public class HanoiTower {

    private static void hanoi(int n){
        if (n < 1)
            System.out.println("Wrong Input!");
        //printHanoi(n, "left", "middle", "right");
        func(n, n, "left", "middle", "right");
    }

    private static void printHanoi(int n, String from, String help, String to) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
            return;
        }
        printHanoi(n-1, from, to, help);
        System.out.println("move " + n + " from " + from + " to " + to);
        printHanoi(n-1, help, from, to);
    }

    private static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
            return;
        }
        func(rest - 1, down - 1, from, to, help);
        func(1, down, from, help, to);
        func(rest - 1, down - 1, help, from, to);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
