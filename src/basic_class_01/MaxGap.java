package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Paul Z on 2019/12/16
 * 题目要求：
 * 给定一数组，求排序后相邻两数最大差值，要求时间复杂度为O(n)，且不能使用非基于比较的排序。
 */
public class MaxGap {

    private static int findMaxGap(int[] a){
        if (a == null || a.length < 2)
            return 0;

        int maxOfArray = Integer.MIN_VALUE;
        int minOfArray = Integer.MAX_VALUE;
        for (int x : a){
            if (x > maxOfArray)
                maxOfArray = x;
            if (x < minOfArray)
                minOfArray = x;
        }

        if (maxOfArray == minOfArray)
            return 0;

        boolean[] hasMember = new boolean[a.length + 1];
        int[] minOfBucket = new int[a.length + 1];
        int[] maxOfBucket = new int[a.length + 1];
        int index;
        for (int x : a){
            index = bucket(x, a.length, minOfArray, maxOfArray);
            minOfBucket[index] = hasMember[index] ? Math.min(minOfBucket[index], x) : x;
            maxOfBucket[index] = hasMember[index] ? Math.max(maxOfBucket[index], x) : x;
            hasMember[index] = true;
        }

        int ans = 0;
        int i = 0;
        int j = 1;
        while (j < a.length+1){
            if (hasMember[j]){
                if (ans < minOfBucket[j]-maxOfBucket[i])
                    ans = minOfBucket[j] - maxOfBucket[i];
                i = j;
                j++;
            }
            else
                j++;
        }
        return ans;
    }

    private static int bucket(int num, int len, int min, int max){
        return (num - min) * len / (max - min);
    }

    private static int comparator(int[] a){
        if (a == null || a.length < 2) {
            return 0;
        }
        Arrays.sort(a);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++)
            gap = Math.max(a[i] - a[i-1], gap);
        return gap;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue){
        Random r = new Random();
        int[] ans = new int[r.nextInt(maxSize+1)];
        for (int i = 0; i < ans.length; i++)
            ans[i] = r.nextInt(maxValue+1) - r.nextInt(maxValue);
        return ans;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] a1 = generateRandomArray(maxSize, maxValue);
            int[] a2 = Arrays.copyOf(a1, a1.length);
            int g1 = findMaxGap(a1);
            int g2 = comparator(a2);
            if (g1 != g2){
                succeed = false;
                System.out.println(Arrays.toString(a1));
                System.out.println(Arrays.toString(a2));
                break;
            }
        }
        System.out.println(succeed ? "大概率没错！" : "有问题！");
    }
}
