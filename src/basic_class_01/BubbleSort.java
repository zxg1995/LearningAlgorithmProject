package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhang on 2019/11/4.
 */
public class BubbleSort {

    private void bubblesort(int[] a){
        if (a==null || a.length < 2) {
        }
        for (int i = 1; i < a.length; i++)
            for (int j = 0; j < a.length-i; j++){
                if (a[j] > a[j+1])
                    swap(a, j, j+1);
            }
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    private void comparator(int[] a){
        Arrays.sort(a);
    }

    private int[] generateRandomArray(int maxSize, int maxValue){
        Random r = new Random();
        int[] arr = new int[r.nextInt(maxSize+1)];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(maxValue+1) - r.nextInt(maxValue);
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] a1 = s.generateRandomArray(maxSize, maxValue);
            int[] a2 = Arrays.copyOf(a1, a1.length);
            s.bubblesort(a1);
            s.comparator(a2);
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
