package ForOfferQuestions;

import java.util.Scanner;

/**
 * Created by Paul Z on 2020/4/9
 * 题目：
 * n-循环次数
 * str-输入数字字符串（包含k）
 * k-目标值
 * ss[0]- 只包含数字的字符串
 * 要求在ss[0]添加+或者-，使得计算结果等于k，求有多少种满足条件的添加方法。
 */
public class SplitStringToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < n; i++){
            String str = sc.nextLine();
            String[] ss = str.split(" ");
            int k = Integer.parseInt(ss[1]);
            int sum = 0;
            int res = process(ss[0], 0, 0, sum, k);
            System.out.println(res);
        }
    }

    private static int process(String s, int i, int j, int sum, int k) {
        if (j == s.length()){
            if (sum == k)
                return 1;
            else
                return 0;
        }
        int num = Integer.parseInt(s.substring(i, j+1));
        int count;
        if (i == 0)
            count =process(s, j+1, j+1, sum+num, k) + process(s, i, j+1, sum, k);
        else
            count = process(s, j+1, j+1, sum+num, k) + process(s, j+1, j+1, sum-num, k) + process(s, i, j+1, sum, k);
        return count;
    }
}
