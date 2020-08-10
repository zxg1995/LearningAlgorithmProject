package ForOfferQuestions;

import java.util.Stack;

/**
 * Created by Paul Z on 2020/2/2
 */
public class FindNodeInBST {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
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
        StringBuilder buf = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    private static TreeNode KthNode(TreeNode pRoot, int k){
        if (k < 1)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        int i = 1;
        while (!stack.isEmpty() || pRoot != null){
            if (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                if (i == k)
                    return pRoot;
                else
                    i++;
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        head1.left = new TreeNode(3);
        head1.right = new TreeNode(7);
        head1.left.left = new TreeNode(2);
        head1.left.right = new TreeNode(4);
        head1.right.left = new TreeNode(6);
        head1.right.right = new TreeNode(8);
        printTree(head1);
        System.out.println(KthNode(head1,3).val);
    }
}
