package ForOfferQuestions;

import java.util.Arrays;

/**
 * Created by Paul Z on 2020/1/20
 */
public class ReConstructBinaryTree_4 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    private static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if (pre == null || pre.length == 0 || in == null || in.length ==0)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        int i = 0;
        while (in[i] != pre[0])
            i++;
        int[] pre_left = Arrays.copyOfRange(pre, 1, i+1);
        int[] pre_right = Arrays.copyOfRange(pre, i+1, pre.length);
        int[] in_left = Arrays.copyOfRange(in, 0, i);
        int[] in_right = Arrays.copyOfRange(in, i+1, in.length);
        node.left = reConstructBinaryTree(pre_left, in_left);
        node.right = reConstructBinaryTree(pre_right, in_right);
        return node;
    }

    //打印二叉树的模板
    private static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre, in);
        printTree(node);
    }
}
