package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/10
 */
public class NumberOfOne {

    private static int NumberOf1(int n){
        int sum = 0;
        boolean isNegative = false;
        if (n < 0){
            n = n ^ Integer.MIN_VALUE;
            isNegative = true;
        }
        while (n != 0){
            int tmp = n % 2;
            if (tmp == 1)
                sum ++;
            n = n / 2;
        }
        if(isNegative)
            return sum + 1;
        else
            return sum;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("1的个数：" + NumberOf1(n));
    }
}
