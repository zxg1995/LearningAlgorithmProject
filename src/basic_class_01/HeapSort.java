package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Paul Z on 2019/12/1
 */
public class HeapSort {

    private static void heapSort(int[] a){
        if (a == null || a.length < 2)
            return;
        for (int i = 0; i < a.length; i++)
            heapInsert(a, i);
        int size = a.length;
        while (size > 1){
            swap(a, 0, --size);
            heapify(a, size);
        }
    }

    private static void heapify(int[] a, int size) {
        int i = 0;
        int left = 1;
        while (left < size){
            int largest = left + 1 < size && a[left+1] > a[left] ? left + 1 : left;
            largest = a[i] > a[largest] ? i : largest;
            if (i == largest)
                break;
            swap(a, i, largest);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private static void heapInsert(int[] a, int i) {
        while (a[i] > a[(i - 1) / 2]){
            swap(a, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] a, int i, int j) {
        if(i != j){
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
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
            heapSort(a1);
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
