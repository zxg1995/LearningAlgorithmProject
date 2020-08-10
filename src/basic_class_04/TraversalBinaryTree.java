package basic_class_04;

import java.util.Stack;

/**
 * Created by Paul Z on 2020/1/20
 */
public class TraversalBinaryTree {

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

    //采用递归方式的先序遍历
    private static void recursivePreTraversal(TreeNode head){
        if (head == null)
            return;
        System.out.print(head.value + " ");
        recursivePreTraversal(head.left);
        recursivePreTraversal(head.right);
    }

    //采用递归方式的中序遍历
    private static void recursiveInTraversal(TreeNode head){
        if (head == null)
            return;
        recursiveInTraversal(head.left);
        System.out.print(head.value + " ");
        recursiveInTraversal(head.right);
    }

    //采用递归方式的后序遍历
    private static void recursivePostTraversal(TreeNode head){
        if (head == null)
            return;
        recursivePostTraversal(head.left);
        recursivePostTraversal(head.right);
        System.out.print(head.value + " ");
    }

    //采用非递归方式的先序遍历
    private static void preTraversal(TreeNode head){
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
    }

    //采用非递归方式的中序遍历
    private static void inTraversal(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if (head == null){
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            } else {
                stack.push(head);
                head = head.left;
            }
        }
    }

    //采用非递归方式的后序遍历
    private static void postTraversal(TreeNode head){
        if (head == null)
            return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if (head.left != null)
                s1.push(head.left);
            if (head.right != null)
                s1.push(head.right);
        }
        while (!s2.isEmpty())
            System.out.print(s2.pop().value + " ");
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
        System.out.println("=================================");
        System.out.println("先序遍历递归方式的结果：");
        recursivePreTraversal(head);
        System.out.println();
        System.out.println("=================================");
        System.out.println("中序遍历递归方式的结果：");
        recursiveInTraversal(head);
        System.out.println();
        System.out.println("=================================");
        System.out.println("后序遍历递归方式的结果：");
        recursivePostTraversal(head);
        System.out.println();
        System.out.println("=================================");
        System.out.println("先序遍历非递归方式的结果：");
        preTraversal(head);
        System.out.println();
        System.out.println("=================================");
        System.out.println("中序遍历非递归方式的结果：");
        inTraversal(head);
        System.out.println();
        System.out.println("=================================");
        System.out.println("后序遍历非递归方式的结果：");
        postTraversal(head);
        System.out.println();
    }
}
