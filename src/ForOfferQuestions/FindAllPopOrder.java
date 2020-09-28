package ForOfferQuestions;

import java.util.*;

/**
 * Created by Paul Z on 2020/9/27
 *
 *  对于给定入栈顺序序列，求所有可能的出栈序列
 */
public class FindAllPopOrder {

    private static List<List<Integer>> findAllPopOrder(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int[] pushed = Arrays.copyOf(nums, nums.length);
        dfs(res, nums, 0, pushed);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, int i, int[] pu) {
        if (i == nums.length){
            if (isPopOrder(pu, nums)){
                List<Integer> l = new ArrayList<>();
                for (int x : nums)
                    l.add(x);
                res.add(l);
            }
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++){
            if (set.contains(nums[j]))
                continue;
            set.add(nums[j]);
            swap(nums, i, j);
            dfs(res, nums, i+1, pu);
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private static boolean isPopOrder(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed){
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> res = findAllPopOrder(nums);
        System.out.println(res);
    }
}
