package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/3/4
 */
public class PlayingCardsProblem {

    private static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 2)
            return false;
        int[] a = new int[14];
        for (int num : numbers)
            a[num] ++;
        int left = 1;
        while (a[left] == 0)
            left ++;
        int right = 13;
        while (a[right] == 0)
            right --;
        if (right < left)
            return false;
        for (int i = left; i <= right; i++){
            if (a[i] == 0)
                a[0] -- ;
            if (a[i] > 1)
                return false;
        }
        if (a[0] < 0)
            return false;
        return 12 - right + left >= a[0];
    }

    public static void main(String[] args) {
        int[] n = {1,3,4,0,8,0};
        System.out.println(isContinuous(n));
    }
}
