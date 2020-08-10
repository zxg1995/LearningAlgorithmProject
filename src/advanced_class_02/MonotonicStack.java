package advanced_class_02;

import java.util.Stack;

/**
 * Created by Paul Z on 2020/5/30
 * 题目描述：
 *      LeetCode 84.柱状图中最大的矩形
 * 思路：
 *      应用单调栈，遍历每个height，求每个height两边最近比其小的数，
 *      这两个数的索引之差就是以该height为边的最大面积矩阵的宽度。
 */
public class MonotonicStack {
    public static void main(String[] args) {
        int[] a = {2,1,2,1};
        System.out.println(largestRectangleArea(a));
    }

    private static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> monoStack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++){
            //相对于传统单调栈，具有相同边界的相同值只用计算一次
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]){
                Integer index = monoStack.pop();
                int l = monoStack.isEmpty() ? 0 : monoStack.peek()+1;
                ans = Math.max(ans, (i-l)*heights[index]);
            }
            if (monoStack.isEmpty() || heights[monoStack.peek()] < heights[i])
                monoStack.push(i);
        }
        while (!monoStack.isEmpty()){
            Integer index = monoStack.pop();
            int l = monoStack.isEmpty() ? 0 : monoStack.peek()+1;
            ans = Math.max(ans, (heights.length-l)*heights[index]);
        }
        return ans;
    }
}
