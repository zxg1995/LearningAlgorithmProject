package basic_class_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Paul Z on 2020/1/29
 */
public class BSTandCBT {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            value = x;
        }
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
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuilder buf = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    //递归方法判断是否是二叉搜索树
    static class OutputBST{
        boolean isBST;
        int min;
        int max;

        OutputBST(boolean isBST, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    private static OutputBST judgeBST(TreeNode head){
        if (head == null)
            return new OutputBST(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        OutputBST left = judgeBST(head.left);
        OutputBST right = judgeBST(head.right);
        if (left.isBST && right.isBST && left.max < head.value && head.value < right.min){
            if (left.min == Integer.MAX_VALUE && left.max == Integer.MIN_VALUE){
                if (right.min == Integer.MAX_VALUE && right.max == Integer.MIN_VALUE)
                    return new OutputBST(true, head.value, head.value);
                else
                    return new OutputBST(true, head.value, right.max);
            } else {
                if (right.min == Integer.MAX_VALUE && right.max == Integer.MIN_VALUE)
                    return new OutputBST(true, left.min, head.value);
                else
                    return new OutputBST(true, left.min, right.max);
            }
        } else
            return new OutputBST(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean judgeCBT(TreeNode head){
        if (head == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeaf = false;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            if ((isLeaf && (head.left != null || head.right != null)) || (head.left == null && head.right != null))
                return false;
            if (head.left != null)
                queue.offer(head.left);
            if (head.right != null)
                queue.offer(head.right);
            else
                isLeaf = true;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        printTree(head);
        OutputBST output = judgeBST(head);
        System.out.println(output.isBST);
        System.out.println(output.min);
        System.out.println(output.max);
        System.out.print("判断是否为完全二叉树：");
        System.out.println(judgeCBT(head));
        System.out.println("=================================");
        TreeNode head1 = new TreeNode(4);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(6);
        head1.left.left = new TreeNode(1);
        head1.left.right = new TreeNode(3);
        head1.right.left = new TreeNode(5);
        printTree(head1);
        output = judgeBST(head1);
        System.out.println(output.isBST);
        System.out.println(output.min);
        System.out.println(output.max);
        System.out.print("判断是否为完全二叉树：");
        System.out.println(judgeCBT(head1));
    }
}
