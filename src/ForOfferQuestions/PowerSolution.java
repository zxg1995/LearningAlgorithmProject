package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/3/16
 */
public class PowerSolution {

    private static double power(double base, int exponent){
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        double res = 1;
        if (exponent < 0){
            exponent = -exponent;
            base = 1 / base;
        }
        for (int i = 0; i < exponent; i++)
            res *= base;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power(2, -2));
        System.out.println(power(3.14, 4));
    }
}
