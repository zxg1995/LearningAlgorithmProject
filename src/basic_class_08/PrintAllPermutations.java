package basic_class_08;

import java.util.HashSet;

/**
 * Created by Paul Z on 2020/2/23
 *
 * 1.打印一个字符串的全部排列
 * 2.打印一个字符串的全部排列，要求不要出现重复的排列
 */
public class PrintAllPermutations {

    private static void printAllPermutations1(String str){
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    private static void process1(char[] chs, int i) {
        if (i == chs.length)
            System.out.println(String.valueOf(chs));
        for (int j = i; j < chs.length; j++){
            swap(chs, i, j);
            process1(chs, i+1);
            swap(chs, i, j);
        }
    }

    private static void printAllPermutations2(String str){
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    private static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String test1 = "abcd";
        printAllPermutations1(test1);
        System.out.println("======");
        printAllPermutations2(test1);
        System.out.println("======");

        String test2 = "abcc";
        printAllPermutations1(test2);
        System.out.println("======");
        printAllPermutations2(test2);
        System.out.println("======");
    }
}
