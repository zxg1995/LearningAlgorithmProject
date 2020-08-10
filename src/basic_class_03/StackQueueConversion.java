package basic_class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Paul Z on 2019/12/18
 */
public class StackQueueConversion {

    static class UseQueuesToImplementStack{
        Queue<Integer> data;
        Queue<Integer> help;

        UseQueuesToImplementStack(){
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        private void swap(){
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }

        private void push(Integer element){
            data.add(element);
        }

        private Integer pop(){
            if (data.isEmpty())
                throw new RuntimeException("栈已空，无法出栈");
            while (data.size() > 1){
                help.add(data.poll());
            }
            Integer res = data.poll();
            swap();
            return res;
        }

        private Integer peek(){
            if (data.isEmpty())
                throw new RuntimeException("栈已空，没有元素");
            while (data.size() > 1){
                help.add(data.poll());
            }
            Integer res = data.poll();
            help.add(res);
            swap();
            return res;
        }
    }

    static class UseStacksToImplementQueue{
        Stack<Integer> pushStack;
        Stack<Integer> popStack;

        UseStacksToImplementQueue(){
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        private void add(Integer element){
            pushStack.push(element);
        }

        private Integer poll(){
            if (popStack.isEmpty()){
                if (pushStack.isEmpty())
                    throw new RuntimeException("队列已空，无法出队");
                else {
                    while (!pushStack.isEmpty())
                        popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        private Integer peek(){
            if (popStack.isEmpty()){
                if (pushStack.isEmpty())
                    throw new RuntimeException("队列已空，无法出队");
                else {
                    while (!pushStack.empty())
                        popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }

    public static void main(String[] args) {
        UseStacksToImplementQueue queue = new UseStacksToImplementQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}

