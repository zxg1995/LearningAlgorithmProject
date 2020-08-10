package ForOfferQuestions;

import java.util.ArrayList;

/**
 * Created by Paul Z on 2020/2/29
 */
public class FindNumbersWithSum {

    private static ArrayList<Integer> process(int [] array, int sum){
        ArrayList<Integer> al = new ArrayList<>();
        if (array == null || array.length < 2)
            return al;
        int i = 0;
        int j = array.length - 1;
        while (i < j){
            int tmp = array[i] + array[j];
            if (tmp == sum){
                al.add(array[i]);
                al.add(array[j]);
                break;
            }
            else if (tmp < sum)
                i ++;
            else
                j --;
        }
        return al;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,6,7,9,9};
        int sum = 4;
        System.out.println(process(a, sum));
    }
}
