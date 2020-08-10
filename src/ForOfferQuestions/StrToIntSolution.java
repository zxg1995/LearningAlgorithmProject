package ForOfferQuestions;


/**
 * Created by Paul Z on 2020/3/20
 */
public class StrToIntSolution {

    private static int StrToInt(String str) {
        if (str == null)
            return 0;
        char[] cs = str.toCharArray();
        long sum = 0;
        for (int i = cs.length - 1; i >= 0; i--){
            if (i == 0){
                if (cs[i] == '-' || cs[i] == '+')
                    sum = cs[i] == '-' ? -sum : sum;
                else if (isNum(cs[i]))
                    sum += Math.pow(10, cs.length-1-i) * (cs[i] - '0');
                else
                    return 0;
            }
            else {
                if (isNum(cs[i]))
                    sum += Math.pow(10, cs.length-1-i) * (cs[i] - '0');
                else
                    return 0;
            }
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
            return 0;
        else
            return (int) sum;
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String s1 = "2147483647";
        System.out.println(StrToInt(s1));
        String s2 = "    1a33";
        System.out.println(StrToInt(s2));
    }
}
