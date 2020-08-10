package basic_class_01;

import java.util.Arrays;

/**
 * Created by Paul Z on 2019/11/29
 */
public class NetherlandsFlag {

    private static void partition(int[] a, int l, int r, int p){
        int p1 = l - 1;
        int p2 = r + 1;
        while (l < p2){
            if (a[l] > p)
                swap(a, l, --p2);
            else if (a[l] < p)
                swap(a, l++, ++p1);
            else
                l++;
        }
    }

    private static void swap(int[] a, int i, int j) {
        if(i != j){
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {4,1,9,7,5,7,3,10,5,0};
        int num = 5;
        partition(a, 0, a.length-1, num);
        System.out.println(Arrays.toString(a));
    }
}
