package basic_class_03;

/**
 * Created by Paul Z on 2019/12/18
 * 题目要求：
 * 实现一个特殊的栈，在实现栈基本功能的基础上，再实现返回栈中最小元素的操作（要求时间复杂度为O(1)）。
 */
public class GetMinStack {

    static class MinStack{
        int[] a;
        int[] min;
        int index;

        MinStack(int initSize){
            if (initSize < 0)
                throw new IllegalArgumentException("初始化大小不能小于0");
            a = new int[initSize];
            min = new int[initSize];
            index = -1;
        }

        private void push(int element){
            if (index == a.length-1)
                throw new ArrayIndexOutOfBoundsException("栈已满，无法入栈");
            if (index == -1){
                a[++index] = element;
                min[index] = element;
            }
            else {
                a[++index] = element;
                min[index] = Math.min(element, min[index - 1]);
            }
        }

        private int pop(){
            if (index == -1)
                throw new ArrayIndexOutOfBoundsException("栈已空，无法出栈");
            return a[index--];
        }

        private int peek(){
            if (index == -1)
                throw new ArrayIndexOutOfBoundsException("栈内已无元素");
            return a[index];
        }

        private int getMin(){
            if (index == -1)
                throw new ArrayIndexOutOfBoundsException("栈内已无元素");
            return min[index];
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(5);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
