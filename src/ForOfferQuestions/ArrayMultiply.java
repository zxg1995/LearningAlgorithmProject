package ForOfferQuestions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Paul Z on 2020/1/30
 * 题目要求：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class ArrayMultiply {

    //时间复杂度为O（n^2）的解法
    private static int[] multiply(int[] A){
        if (A == null)
            return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] B = new int[A.length];
        for (int x : A)
            arrayList.add(x);
        for (int i = 0; i < arrayList.size(); i++){
            Integer tmp = arrayList.get(i);
            Integer sum = 1;
            arrayList.set(i, 1);
            for (Integer x : arrayList)
                sum *= x;
            arrayList.set(i, tmp);
            B[i] = sum;
        }
        return B;
    }

    //时间复杂度为O（n）的解法
    private static int[] multiply1(int[] A){
        if (A == null)
            return null;
        int len = A.length;
        int[] B = new int[len];
        int tmp = 1;
        for (int i = 0; i < len; i++){
            B[i] = tmp;
            tmp *= A[i];
        }
        tmp = 1;
        for (int i = len - 1; i >= 0; i--){
            B[i] *= tmp;
            tmp *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = multiply(a);
        System.out.println(Arrays.toString(b));
        b = multiply1(a);
        System.out.println(Arrays.toString(b));
    }
}
