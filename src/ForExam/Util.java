package ForExam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Paul Z on 2020/4/8
 */
public class Util {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            value = x;
        }
    }

    //打印二叉树的模板
    private static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuilder buf = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //获取输入的整数序列
//        String str = sc.nextLine();
//        String[] strings = str.split(" ");
//        //转为整数数组
//        int[] ints = new int[strings.length];
//        for (int i = 0; i < strings.length; i++) {
//            ints[i] = Integer.parseInt(strings[i]);
//        }
//        Integer[] a = new Integer[2];
//        ArrayList<Integer> al = new ArrayList<>();
        String s = "a";
        System.out.println(s.substring(1));

        //当字符串中的的空白分别为：单个空格，两个空格，tab制表符时，采用这种方式进行分割
        String[] strings = s.split("\\s+");
    }
}
