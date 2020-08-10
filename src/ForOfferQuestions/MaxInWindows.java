package ForOfferQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by Paul Z on 2020/1/31
 * 题目要求：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {

    private static ArrayList<Integer> maxInWindows(int[] num, int size){
        if (num == null || size > num.length || size < 1)
            return null;
        int[] maxArray = new int[num.length];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = size-1; i >= 0; i--){
            if (i == size-1)
                maxArray[i] = num[i];
            else
                maxArray[i] = Math.max(num[i], maxArray[i + 1]);
        }
        for (int i = size; i < num.length; i++){
            for (int j = i; j > i - size; j--){
                if (j == i)
                    maxArray[j] = num[i];
                else
                    maxArray[j] = Math.max(maxArray[j], num[i]);
            }
        }
        for (int i = 0; i <= num.length - size; i++)
            res.add(maxArray[i]);
        return res;
    }

    private static ArrayList<Integer> maxInWindows1(int[] num, int size){
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++){
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.pollLast();
            deque.offer(i);
            while (!deque.isEmpty() && deque.peekFirst() <= i - size)
                deque.pollFirst();
            if (i >= size - 1 && !deque.isEmpty())
                res.add(num[deque.peekFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> a = maxInWindows1(num, 3);
        System.out.println(Arrays.toString(a.toArray()));
    }
}
