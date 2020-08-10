package ForOfferQuestions;

/**
 * Created by Paul Z on 2020/5/20
 *
 * 题目：一个数组，去掉一个数，如何让剩余的数乘积最大？
 * 思路：
 *  1 数组中全是不为负的数，剔除最小的。
 *  2 数组中存在负数，再分三种情况：
 *      2.1 负数个数为奇数，剔除最大的负数即可。
 *      2.2 负数个数为偶数且数组中有不为负的数，剔除最小的非负数。
 *      2.3 负数个数为偶数且数组全为负数，剔除最小的负数。
 */
public class RemoveArrayIndex {
    public static void main(String[] args) {
        int[] nums = {-2,-2,-1,-6,-7,-8};
        System.out.println(removeIndex(nums));
    }

    private static int removeIndex(int[] nums){
        int count = 0;
        int maxF = 0;
        int minF = 0;
        int minZ = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0) {
                maxF = i;
                minF = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= 0) {
                minZ = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                count++;
                if (nums[i] > nums[maxF])
                    maxF = i;
                if (nums[i] < nums[minF])
                    minF = i;
            }
            else {
                if(nums[i] < nums[minZ])
                    minZ = i;
            }
        }
        if ((count & 1) == 0){
            if (count == nums.length)
                return minF;
            else
                return minZ;
        }
        else
            return maxF;
    }
}
