package basic_class_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Paul Z on 2020/2/23
 *
 * 一个数据流中，随时可以取得中位数
 */
public class FindMedianQuick {

    private static class MinComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    private static class MaxComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    static class MedianHolder{
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinComparator());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());

        void modifyTwoHeapsSize(){
            if (maxHeap.size() == minHeap.size() + 2)
                minHeap.add(maxHeap.poll());
            if (minHeap.size() == maxHeap.size() + 2)
                maxHeap.add(minHeap.poll());
        }

        void add(int num){
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }
            if (maxHeap.peek() >= num)
                maxHeap.add(num);
            else {
                if (minHeap.isEmpty()){
                    minHeap.add(num);
                    return;
                }
                if (minHeap.peek() <= num)
                    minHeap.add(num);
                else
                    maxHeap.add(num);
            }
            modifyTwoHeapsSize();
        }

        Integer getMedian(){
            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();
            if (maxHeapSize + minHeapSize == 0)
                return null;
            Integer minHead = minHeap.peek();
            Integer maxHead = maxHeap.peek();
            if (((minHeapSize + maxHeapSize) & 1) == 0)
                return (maxHead + minHead) / 2;
            return maxHeapSize > minHeapSize ? maxHead : minHead;
        }
    }

    private static int[] generateRandomArray(int maxSize, int maxValue){
        Random r = new Random();
        int[] ans = new int[r.nextInt(maxSize) + 1];
        for (int i = 0; i < ans.length; i++)
            ans[i] = r.nextInt(maxValue+1) - r.nextInt(maxValue);
        return ans;
    }

    private static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 2000;
        for (int i = 0; i < testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = generateRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int value : arr) {
                medianHold.add(value);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                System.out.println(Arrays.toString(arr));
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");
    }
}
