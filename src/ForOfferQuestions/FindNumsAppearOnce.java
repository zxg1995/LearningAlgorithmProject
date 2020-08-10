package ForOfferQuestions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Paul Z on 2020/2/11
 */
public class FindNumsAppearOnce {

    private static void findNumsAppearOnce(int[] array, int[] num1 , int[] num2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : array){
            if (map.containsKey(x))
                map.put(x, 2);
            else
                map.put(x, 1);
        }
        boolean num1IsEmpty = true;
        for (Integer x : map.keySet()){
            if (map.get(x) == 1){
                if (num1IsEmpty){
                    num1[0] = x;
                    num1IsEmpty = false;
                } else
                    num2[0] = x;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,4,7,5,3,7,3,9};
        int[] n1 = new int[1];
        int[] n2 = new int[1];
        findNumsAppearOnce(a,n1,n2);
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
    }
}
