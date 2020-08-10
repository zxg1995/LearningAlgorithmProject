package ForOfferQuestions;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Paul Z on 2020/3/9
 */
public class GetLeastNumbersInArray {

    private static ArrayList<Integer> getLeastNumbers(int[] input, int k){
        ArrayList<Integer> al = new ArrayList<>();
        if (input == null || input.length < k || k < 1)
            return al;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : input)
            heap.add(x);
        for (int i = 0; i < k; i++)
            al.add(heap.poll());
        return al;
    }

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        int k = 4;
        System.out.println(getLeastNumbers(a, k));
    }
}
