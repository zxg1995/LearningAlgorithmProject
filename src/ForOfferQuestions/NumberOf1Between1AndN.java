package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/21
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中
 * 包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮
 * 帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {

    private static int numberOf1Between1AndN_Solution(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            char[] tmp = String.valueOf(i).toCharArray();
            for (char c : tmp){
                if (c == '1')
                    sum ++;
            }
        }
        return sum;
    }

    private static int solution(int n){
        char[] cs = String.valueOf(n).toCharArray();
        int len = cs.length;
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < len - 1; i++){
            int num = cs[i] - '0';
            tmp += num * Math.pow(10, len - i -1);
            sum += num * (len - i - 1) * Math.pow(10, len - i -2);
            if (num == 1)
                sum += (n - tmp +1);
            if (num > 1)
                sum += Math.pow(10, len - i -1);
        }
        if (n - tmp > 0)
            return sum + 1;
        else
            return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN_Solution(211));
        System.out.println(numberOf1Between1AndN_Solution(10011));
        System.out.println(numberOf1Between1AndN_Solution(1234561));
        System.out.println(solution(211));
        System.out.println(solution(10011));
        System.out.println(solution(1234561));
    }
}
