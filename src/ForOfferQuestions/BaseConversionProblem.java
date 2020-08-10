package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/2/15
 */
public class BaseConversionProblem {

    //求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
    private static int sumSolution(int n){
        return (n + (int) Math.pow(n, 2)) >> 1;
    }

    //求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
    //方法二：用短路原理
    private static int sumSolution1(int n){
        int sum = n;
        boolean f = (sum > 0) && ((sum += sumSolution1(n - 1)) > 0);
        return sum;
    }

    //写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    private static int specialAdd(int num1,int num2){
        int sum = num1 ^ num2;
        int ans = (num1 & num2) << 1;
        while(ans != 0){
            num1 = sum;
            num2 = ans;
            sum = num1 ^ num2;
            ans = (num1 & num2) << 1;
        }
        return sum;
    }

    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    private static void findNumsAppearOnce(int[] array, int[] num1, int[] num2){
        int xor1 = 0;
        for (int value : array)
            xor1 = xor1 ^ value;
        //在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        int index = 1;
        while((index & xor1)==0)
            //因为可能有多个位为1所以需要求一下位置
            index = index <<1;
        int result1 = 0;
        int result2 = 0;
        for (int value : array) {
            if ((index & value) == 0)
                result1 = result1 ^ value;
            else
                result2 = result2 ^ value;
        }
        num1[0] = result1;
        num2[0] = result2;
    }

    public static void main(String[] args) {
        System.out.println(sumSolution1(1));
        System.out.println(sumSolution1(2));
        System.out.println(sumSolution1(3));
        System.out.println(sumSolution1(10));
        System.out.println(specialAdd(5, 7));
        System.out.println(specialAdd(-1, -2));
    }
}
