package ForOfferQuestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Paul Z on 2020/2/22
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinSpliceNumber {

    private static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    private static String PrintMinNumber(int[] numbers){
        if (numbers == null || numbers.length == 0)
            return "";
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            strings[i] = String.valueOf(numbers[i]);
        Arrays.sort(strings, new MyComparator());
        StringBuilder str = new StringBuilder();
        for (String s : strings)
            str.append(s);
        return str.toString();
    }

    public static void main(String[] args) {
        int[] a = new int[]{31,32,34};
        System.out.println(PrintMinNumber(a));
    }
}
