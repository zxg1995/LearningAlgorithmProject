package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Paul Z on 2019/11/29
 */
public class QuickSort {

    //采用荷兰国旗法进行partition
    private static int[] partition(int[] a, int l, int r, int p){
        int p1 = l - 1;   //p1之前存放的都是小于p的数
        int p2 = r + 1;   //p2之后放的都是大于p的数
        while (l < p2){
            if (a[l] > p)
                swap(a, l, --p2);
            else if (a[l] < p)
                swap(a, l++, ++p1);
            else
                l++;
        }
        return new int[]{p1, p2};
    }

    //采用双指针，将头指针指向的大于a[l]的数与尾指针指向小于等于a[l]的进行位置交换来partition
    private static int[] partition(int[] a, int l, int r){

        int p1 = l;
        int p2 = r;
        while (p1 < p2){
            while (p1 < p2 && a[p2] > a[l])
                p2--;
            while (p1 < p2 && a[p1] <= a[l])
                p1++;
            swap(a, p1, p2);
        }
        swap(a, p1, l);
        return new int[]{p1-1, p1+1};
    }

    private static void swap(int[] a, int i, int j) {
        if(i != j){
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }

    private static void quickSort(int[] a){
        if (a == null)
            return;
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int l, int r){
        if (l >= r)
            return;
        Random random = new Random();
        int num = a[l + random.nextInt(r-l+1)];
        int[] p = partition(a, l, r, num);
        quickSort(a, l, p[0]);
        quickSort(a, p[1], r);
    }

    private static void comparator(int[] a){
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
            quickSort(a1);
            comparator(a2);
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
