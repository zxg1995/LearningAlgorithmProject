package basic_class_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Paul Z on 2020/1/27
 */
public class SerializeAndReconstructTree {

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

    //先序序列化一颗二叉树
    private static String preSerializeTree(TreeNode head){
        if (head == null)
            return "#!";
        String res = head.value + "!";
        res += preSerializeTree(head.left);
        res += preSerializeTree(head.right);
        return res;
    }

    //根据字符串序列重构出二叉树
    private static TreeNode preReconstructTree(String str){
        if (str == null || str.length() < 2)
            throw new RuntimeException("序列化字符串格式有误");
        String[] ss = str.split("!");
        Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
        return reconstructTreeByQueue(queue);
    }

    private static TreeNode reconstructTreeByQueue(Queue<String> queue) {
        if (queue.isEmpty())
            throw new RuntimeException();
        String node = queue.poll();
        if (node.equals("#"))
            return null;
        TreeNode head = new TreeNode(Integer.parseInt(node));
        head.left = reconstructTreeByQueue(queue);
        head.right = reconstructTreeByQueue(queue);
        return head;
    }

    //层次序列化一颗二叉树
    private static String levelSerializeTree(TreeNode head){
        if (head == null)
            return "#!";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res =new StringBuilder();
        res.append(head.value).append("!");
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            if (head.left != null) {
                res.append(head.left.value).append("!");
                queue.offer(head.left);
            } else
                res.append("#!");
            if (head.right != null) {
                res.append(head.right.value).append("!");
                queue.offer(head.right);
            } else
                res.append("#!");
        }
        return res.toString();
    }

    //根据层次序列重构出二叉树
    private static TreeNode levelReconstructTree(String str){
        if (str == null || str.length() < 2)
            throw new RuntimeException("序列化字符串格式有误");
        String[] ss = str.split("!");
        Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
        return levelReconstructTreeByQueue(queue);
    }

    private static TreeNode levelReconstructTreeByQueue(Queue<String> queue) {
        if (queue.size() == 0)
            throw new RuntimeException();
        String string = queue.poll();
        if (string.equals("#"))
            return null;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(string));
        nodeQueue.offer(head);
        while (!nodeQueue.isEmpty()){
            TreeNode cur = nodeQueue.poll();
            if (!queue.isEmpty()){
                string = queue.poll();
                if (string.equals("#"))
                    cur.left = null;
                else {
                    cur.left = new TreeNode(Integer.parseInt(string));
                    nodeQueue.offer(cur.left);
                }
            }
            if (!queue.isEmpty()){
                string = queue.poll();
                if (string.equals("#"))
                    cur.right = null;
                else {
                    cur.right = new TreeNode(Integer.parseInt(string));
                    nodeQueue.offer(cur.right);
                }
            }
        }
        return head;
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
        System.out.println("先序序列化的结果：");
        String string = preSerializeTree(head);
        System.out.println(string);
        System.out.println("根据字符串反序列化的结果：");
        TreeNode node = preReconstructTree(string);
        printTree(node);
        System.out.println("=================================");
        System.out.println("层次序列化的结果：");
        string = levelSerializeTree(head);
        System.out.println(string);
        System.out.println("根据字符串反序列化的结果：");
        TreeNode node1 = levelReconstructTree(string);
        printTree(node1);
    }
}
