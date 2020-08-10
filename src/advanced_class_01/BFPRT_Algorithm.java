package advanced_class_01;

import java.util.*;

/**
 * Created by Paul Z on 2020/6/1
 * 应用问题：
 *      LeetCode 215.数组中的第K个最大元素
 */
public class BFPRT_Algorithm {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    //采用传统的选择随机划分的荷兰国旗方法，最好时间复杂度O(N)，最差时间复杂度O(N^2)。
    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int tmp = getRandomNum(nums, 0, nums.length-1);
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        while (i <= j){
            int p = i;
            int l = i-1;
            int r = j+1;
            while (p < r){
                if (nums[p] > tmp)
                    swap(nums, p++, ++l);
                else if (nums[p] < tmp)
                    swap(nums, p, --r);
                else
                    p++;
            }
            if (k-1 > l && k-1 < r){
                ans = tmp;
                break;
            }
            else if (k-1 >= r) {
                tmp = getRandomNum(nums, r, j);
                i = r;
            }
            else {
                tmp = getRandomNum(nums, i, l);
                j = l;
            }
        }
        return ans;
    }

    private static void swap(int[] nums, int p, int i) {
        int t = nums[p];
        nums[p] = nums[i];
        nums[i] = t;
    }

    private static int getRandomNum(int[] nums, int l, int r) {
        Random random = new Random();
        return nums[random.nextInt(r-l+1)+l];
    }
}
