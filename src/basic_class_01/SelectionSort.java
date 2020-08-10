package basic_class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Paul Z on 2019/11/15
 */
public class SelectionSort {

    private static void selectionSort(int[] a){
        if (a == null || a.length < 2){
            return;
        }
        for (int i = 0; i < a.length-1; i++){
            int minPointer = i;
            for (int j = i+1; j < a.length; j++){
                if (a[minPointer] > a[j])
                    minPointer = j;
            }
            if (minPointer != i)
                swap(a, i, minPointer);
        }
    }

    private static void swap(int[] a, int i, int j) {
        //注意：用这种方法交换值时，i与j不能相等，否则值为0！
        //因为自己跟自己异或结果为0
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
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
            selectionSort(a1);
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
