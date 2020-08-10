package basic_class_07;

import java.util.PriorityQueue;

/**
 * Created by Paul Z on 2020/2/22
 * 金条切分问题
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
 * 长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
 * 板。一群人想整分整块金 条，怎么分最省铜板？
 */
public class LessMoney {

    private static int lessMoney(int[] a){
        if (a == null || a.length == 0)
            return 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int x : a){
            pQ.add(x);
        }
        int sum = 0;
        while (pQ.size() > 1){
            int tmp = pQ.poll() + pQ.poll();
            sum += tmp;
            pQ.add(tmp);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
    }
}
