package basic_class_08;

import java.util.Stack;

/**
 * Created by Paul Z on 2020/2/23
 *
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
 * 使用递归函数。
 */
public class ReverseStackUsingRecursive {

    private static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty())
            return;
        int tmp = removeLastMember(stack);
        reverseStack(stack);
        stack.push(tmp);
    }

    private static int removeLastMember(Stack<Integer> stack) {
        if (stack.size() == 1)
            return stack.pop();
        int tmp = stack.pop();
        int res = removeLastMember(stack);
        stack.push(tmp);
        return res;
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test);
        reverseStack(test);
        System.out.println(test);
    }
}
