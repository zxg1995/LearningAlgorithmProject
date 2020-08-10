package ForOfferQuestions;

import java.util.Arrays;

/**
 * Created by Paul Z on 2020/3/9
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostOrderSequenceOfBST {

    private static boolean VerifySequenceOfBST(int[] sequence){
        if (sequence == null || sequence.length == 0)
            return false;
        int[] sortedSequence = Arrays.copyOfRange(sequence, 0, sequence.length);
        Arrays.sort(sortedSequence);
        return process(sequence, 0, sequence.length-1, sortedSequence, 0, sortedSequence.length-1);
    }

    private static boolean process(int[] sequence, int i, int j, int[] sortedSequence, int l, int r) {
        if (i == j)
            return sequence[i] == sortedSequence[l];
        if (j < i)
            return true;
        int index = Arrays.binarySearch(sortedSequence, sequence[j]);
        if (index == -1)
            return false;
        return process(sequence, i, i+index-1-l, sortedSequence, l, index - 1)
                && process(sequence, j-r+index, j-1, sortedSequence, index + 1, r);
    }

    public static void main(String[] args) {
        int[] a = {0,3,1,5,4,2};
        int[] b = {0,2,1,4,3,6,9,8,7,5};
        System.out.println(VerifySequenceOfBST(b));
    }
}
