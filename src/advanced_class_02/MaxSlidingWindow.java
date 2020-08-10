package advanced_class_02;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Paul Z on 2020/5/29
 * 题目描述：
 *      LeetCode 239.滑动窗口最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k){
            int res = Integer.MIN_VALUE;
            for (int x : nums)
                res = Math.max(res, x);
            return new int[]{res};
        }
        LinkedList<Integer> dequeue = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++){
            while (!dequeue.isEmpty() && nums[dequeue.getLast()] <= nums[i])
                dequeue.pollLast();
            dequeue.add(i);
            if (dequeue.getFirst() < i - k + 1)
                dequeue.pollFirst();
            if (i >= k-1)
                ans[i-k+1] = nums[dequeue.getFirst()];
        }
        return ans;
    }
}
