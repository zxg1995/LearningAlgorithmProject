package ForOfferQuestions;

import java.util.Stack;

/**
 * Created by Paul Z on 2020/2/21
 *
 *   剑指 Offer 31. 栈的压入、弹出序列
 *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 */
public class IsPopOrder {

    private static boolean isPopOrder2(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed){
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPopOrder(int[] pushA, int[] popA){
        if (popA == null || pushA == null)
            return false;
        if (pushA.length != popA.length)
            return false;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (j < popA.length){
            if (i < pushA.length && pushA[i] == popA[j]){
                i ++;
                j ++;
            }
            else if (!stack.isEmpty() && popA[j] == stack.peek()){
                stack.pop();
                j ++;
            }
            else if (i < pushA.length){
                stack.push(pushA[i]);
                i ++;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] p1 = new int[]{4,5,3,2,1};
        int[] p2 = new int[]{3,5,4,2,1};
        System.out.println(isPopOrder(a, p1));
        System.out.println(isPopOrder(a, p2));
    }
}
