package ForOfferQuestions;

import java.util.ArrayList;

/**
 * Created by Paul Z on 2020/3/1
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很
 * 快的找出所有和为S的连续正数序列
 */
public class FindContinuousSequence {

    private static ArrayList<ArrayList<Integer>> process(int sum){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (sum < 1)
            return arrayLists;
        int count = (int) Math.sqrt(sum * 2);
        for (int i = count; i > 1; i--){
            if (sum * 2 % i != 0)
                continue;
            int tmp = sum * 2 / i;
            int res = tmp - i + 1;
            if (res % 2 == 0){
                int x = res / 2;
                int y = x + i - 1;
                ArrayList<Integer> al = new ArrayList<>();
                for (int j = x; j <= y; j++)
                    al.add(j);
                arrayLists.add(al);
            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        int sum = 45;
        System.out.println(process(sum));
    }
}
