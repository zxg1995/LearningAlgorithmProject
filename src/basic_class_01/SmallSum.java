package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Paul Z on 2019/11/28
 */
public class SmallSum {

    private static int smallSum(int[] a){
        if (a == null)
            return 0;
        return mergeSort(a, 0, a.length-1);
    }

    private static int mergeSort(int[] a, int l, int r) {
        if (l >= r)
            return 0;
        int mid = l + (r - l) / 2;
        int left = mergeSort(a, l, mid);
        int right = mergeSort(a, mid+1, r);
        int ans = merge(a, l, mid, r);
        return left + right + ans;
    }

    private static int merge(int[] a, int l, int m, int r) {
        int[] tmp = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        int ans = 0;
        while (p1 <= m && p2 <= r) {
            ans += a[p1] < a[p2] ? a[p1] * (r-p2+1) : 0;
            tmp[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        while (p1 <= m)
            tmp[i++] = a[p1++];
        while (p2 <= r)
            tmp[i++] = a[p2++];
        System.arraycopy(tmp, 0, a, l, r-l+1);
        return ans;
    }

    private static int comparator(int[] a){
        if (a == null || a.length < 2)
            return 0;
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++)
                sum += a[j] < a[i] ? a[j] : 0;
        }
        return sum;
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
            int s1 = smallSum(a1);
            int s2 = comparator(a2);
            if (s1 != s2){
                succeed = false;
                System.out.println(s1);
                System.out.println(s2);
                break;
            }
        }
        System.out.println(succeed ? "大概率没错！" : "有问题！");
    }
}
