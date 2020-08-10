package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Paul Z on 2019/11/15
 */
public class MergeSort {

    private static void mergeSort(int[] a){
        if (a == null){
            return;
        }
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(int[] a, int l, int r){
        //注意！注意！
        //数组a为空与a = null是两回事！
        //递归的时候边界一定要考虑全面！
        if (l >= r){
            return;
        }
        int mid = l + ((r-l) >> 1);
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, r);
        merge(a, l, mid, r);
    }

    private static void merge(int[] a, int l, int m, int r){
        int[] tmp = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while (p1 <= m && p2 <= r)
            tmp[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        while (p1 <= m)
            tmp[i++] = a[p1++];
        while (p2 <= r)
            tmp[i++] = a[p2++];
        System.arraycopy(tmp, 0, a, l, r-l+1);
    }

    private static void comparatorSort(int[] a){
        Arrays.sort(a);
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
            mergeSort(a1);
            comparatorSort(a2);
            if (!Arrays.equals(a1, a2)){
                succeed = false;
                System.out.println(Arrays.toString(a1));
                System.out.println(Arrays.toString(a2));
                break;
            }
        }
        System.out.println(succeed ? "大概率没错！" : "有问题！");
    }
}
