package ForOfferQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Paul Z on 2020/4/17
 * 描述：
 * n-----输入数组的个数（1<=n<=100000）
 * k-----输入要找第几个数对
 * a[n]-----包含n个整数，可能存在重复
 * 要求找出最小的第k个数对，数对比较法则：先比较第一数的大小，若相同再比较第二个数的大小。
 */
public class FindKthNumberPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        process(a, k);
    }

    private static void process(int[] a, long k) {
        int i = 0;
        while (i < a.length){
            int j = i+1;
            while (j < a.length && a[j] == a[i])
                j++;
            for (int t = 0; t < a.length; t++){
                k -= (j-i);
                if (k <= 0){
                    System.out.println("("+a[i]+","+a[t]+")");
                    return;
                }
            }
            i = j;
        }
    }
}
