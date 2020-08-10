package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/24
 */
public class CutRope {

    private static int cutRope1(int target){
        if (target <= 1)
            return 1;
        int res = 0;
        for (int i = 2; i <= target; i++){
            int tmp = i * cutRope1(target - i);
            if (tmp > res)
                res = tmp;
        }
        return res;
    }

    private static int cutRope2(int target){
        if (target == 2 || target == 3)
            return target - 1;
        int s = target / 3;
        int y = target % 3;
        if (y == 1)
            return (int) (Math.pow(3, s - 1) * 4);
        else if (y == 2)
            return (int) (Math.pow(3, s) * 2);
        else
            return (int) Math.pow(3, s);
    }

    public static void main(String[] args) {
        System.out.println(cutRope1(31));
        System.out.println(cutRope1(17));
        System.out.println(cutRope1(7));
        System.out.println(cutRope1(29));

        System.out.println(cutRope2(31));
        System.out.println(cutRope2(17));
        System.out.println(cutRope2(7));
        System.out.println(cutRope2(29));
    }
}
