package ForExam;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        try {
            m.method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main()方法正常退出");
    }

    private void method1() throws ArithmeticException {
        System.out.println("method1()开始执行");
        System.out.println(10 / 0);
        System.out.println("method1()正常退出");

    }
}