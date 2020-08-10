package ForOfferQuestions;

import java.util.PriorityQueue;

/**
 * Created by Paul Z on 2020/3/13
 */
public class GetUglyNumberSolution {

    private static int getUglyNumber1(int index){
        if (index < 1)
            return 0;
        int n = 2;
        int res = 1;
        while (true){
            if (index == 1)
                return res;
            if (isUgly(n)){
                index --;
                res = n;
            }
            n ++;
        }
    }

    private static boolean isUgly(int n) {
        while (n % 2 == 0)
            n = n / 2;
        while (n % 3 == 0)
            n = n / 3;
        while (n % 5 == 0)
            n = n / 5;
        return n == 1;
    }

    private static int getUglyNumber(int index){
        if (index < 1)
            return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long) 1);
        while (true){
            if (!pq.isEmpty()) {
                long x = pq.poll();
                index --;
                if (index == 0)
                    return (int) x;
                if (!pq.contains(x * 2))
                    pq.add(x * 2);
                if (!pq.contains(x * 3))
                    pq.add(x * 3);
                if (!pq.contains(x * 5))
                    pq.add(x * 5);
            }
        }
    }

    public static void main(String[] args) {
        int i = 1500;
        System.out.println(getUglyNumber(i));
    }
}
