package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/6/9
 * 题目：
 *      LeetCode 面试题46. 把数字翻译成字符串
 */
public class TranslateNumber {
    public static void main(String[] args) {
        int n = 12258;
        System.out.println(translateNum(n));
    }

    private static int translateNum(int num) {
        if (num < 0)
            return 0;
        String str = String.valueOf(num);
        return count(str, 0);
    }

    private static int count(String str, int i) {
        if (i == str.length())
            return 1;
        if (i > str.length())
            return 0;
        if (i == str.length()-1
                || (Integer.parseInt(str.substring(i,i+2)) > 25
                || Integer.parseInt(str.substring(i,i+2)) < 10))
            return count(str, i+1);
        else
            return count(str, i+1) + count(str, i+2);
    }
}
