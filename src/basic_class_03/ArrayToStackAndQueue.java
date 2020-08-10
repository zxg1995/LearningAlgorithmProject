package basic_class_03;

/**
 * Created by Paul Z on 2019/12/18
 */
public class ArrayToStackAndQueue {

    static class ArrayToStack{
        int[] a;
        int index;

        ArrayToStack(int initSize){
            if (initSize < 0)
                throw new IllegalArgumentException("初始化大小不能小于0");
            a = new int[initSize];
            index = -1;
        }

        private void push(int element){
            if (index == a.length-1)
                throw new ArrayIndexOutOfBoundsException("栈已满，无法入栈");
            else
                a[++index] = element;
        }

        private int pop(){
            if (index == -1)
                throw new ArrayIndexOutOfBoundsException("栈已空，无法出栈");
            else
                return a[index--];
        }

        private int peek(){
            if (index == -1)
                throw new ArrayIndexOutOfBoundsException("栈内已无元素");
            else
                return a[index];
        }
    }

    static class ArrayToQueue{
        int[] a;
        int head;
        int end;
        int size;

        ArrayToQueue(int initSize){
            if (initSize < 0)
                throw new IllegalArgumentException("初始化大小不能小于0");
            a = new int[initSize];
            head = end = 0;
            size = 0;
        }

        private int peek(){
            if (size == 0)
                throw new ArrayIndexOutOfBoundsException("队列内已无元素");
            else
                return a[head];
        }

        private void push(int element){
            if (size == a.length)
                throw new ArrayIndexOutOfBoundsException("队列已满，无法入队");
            else {
                size++;
                a[end] = element;
                end = end == a.length-1 ? 0 : end+1;
            }
        }

        private int pop(){
            if (size == 0)
                throw new ArrayIndexOutOfBoundsException("队列已空，无法出队");
            else {
                size--;
                int res = a[head];
                head = head == a.length-1 ? 0 : head+1;
                return res;
            }
        }
    }

    public static void main(String[] args) {
        ArrayToQueue queue = new ArrayToQueue(10);
        queue.push(1);
        queue.push(2);
        System.out.println(queue.end);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
