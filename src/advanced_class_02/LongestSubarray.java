package advanced_class_02;

import java.util.LinkedList;

/**
 * Created by Paul Z on 2020/5/31
 * 题目描述：
 *      LeetCode 239.滑动窗口最大值
 * 思路：
 *      滑动窗口最大值的应用
 */
public class LongestSubarray {

    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int k = 0;
        System.out.println(longestSubarray(nums, k));
    }

    private static int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0 || limit < 0)
            return 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length){
            while (!maxQueue.isEmpty() && nums[maxQueue.getLast()] <= nums[j])
                maxQueue.pollLast();
            maxQueue.add(j);
            while (!minQueue.isEmpty() && nums[minQueue.getLast()] >= nums[j])
                minQueue.pollLast();
            minQueue.add(j);
            int maxN = nums[maxQueue.getFirst()];
            int minN = nums[minQueue.getFirst()];
            if (maxN-minN <= limit)
                j++;
            else{
                i++;
                if (i > maxQueue.getFirst())
                    maxQueue.pollFirst();
                if (i > minQueue.getFirst())
                    minQueue.pollFirst();
                ans = Math.max(ans, j-i+1);
            }
        }
        ans = Math.max(ans, j-i);
        return ans;
    }
}
