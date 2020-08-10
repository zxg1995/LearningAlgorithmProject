package ForOfferQuestions;

import java.util.HashMap;

/**
 * Created by Paul Z on 2020/2/26
 */
public class MoreThanHalfNumOfArray {

    private static int MoreThanHalfNum_Solution(int [] array){
        if (array == null || array.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : array){
            if (map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }
        int key = array[0];
        for (Integer t : map.keySet()){
            if (map.get(t) > map.get(key))
                key = t;
        }
        return map.get(key) > array.length/2 ? key : 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
