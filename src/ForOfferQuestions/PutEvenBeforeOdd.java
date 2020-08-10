package ForOfferQuestions;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Paul Z on 2020/3/7
 */
public class PutEvenBeforeOdd {

    private static void reOrderArray(int[] array){
        if (array == null || array.length < 1)
            return;
        LinkedList<Integer> even = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 != 0)
                array[index++] = array[i];
            else
                even.add(array[i]);
        }
        while (!even.isEmpty())
            array[index++] = even.removeFirst();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,6,7,5,8,9};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }
}
