package ForOfferQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Paul Z on 2020/2/2
 */
public class ZigzagPrintTree {

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

    private static ArrayList<ArrayList<Integer>> ZigzagPrint(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if (pRoot == null)
            return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                pRoot = stack1.pop();
                tmp.add(pRoot.val);
                if (pRoot.left != null)
                    stack2.push(pRoot.left);
                if (pRoot.right != null)
                    stack2.push(pRoot.right);
            }
            if (tmp.size() != 0)
                res.add(tmp);
            tmp = new ArrayList<>();
            while (!stack2.isEmpty()){
                pRoot = stack2.pop();
                tmp.add(pRoot.val);
                if (pRoot.right != null)
                    stack1.push(pRoot.right);
                if (pRoot.left != null)
                    stack1.push(pRoot.left);
            }
            if (tmp.size() != 0)
                res.add(tmp);
            tmp = new ArrayList<>();
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> levelPrint(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(pRoot);
        while (!queue1.isEmpty()){
            while (!queue1.isEmpty()){
                pRoot = queue1.poll();
                tmp.add(pRoot.val);
                if (pRoot.left != null)
                    queue2.offer(pRoot.left);
                if (pRoot.right != null)
                    queue2.offer(pRoot.right);
            }
            if (tmp.size() != 0)
                res.add(tmp);
            tmp = new ArrayList<>();
            while (!queue2.isEmpty()){
                pRoot = queue2.poll();
                tmp.add(pRoot.val);
                if (pRoot.left != null)
                    queue1.offer(pRoot.left);
                if (pRoot.right != null)
                    queue1.offer(pRoot.right);
            }
            if (tmp.size() != 0)
                res.add(tmp);
            tmp = new ArrayList<>();
        }
        return res;
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
        ArrayList<ArrayList<Integer>> res = ZigzagPrint(head);
        for (ArrayList<Integer> list : res)
            System.out.println(list);
        res = levelPrint(head);
        for (ArrayList<Integer> list : res)
            System.out.println(list);
    }
}
